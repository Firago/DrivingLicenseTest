package com.dfirago.drivinglicensetest.common.setup;

import android.util.Log;

import com.dfirago.drivinglicensetest.common.database.utils.CategoryProvider;
import com.dfirago.drivinglicensetest.common.model.Category;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionGroup;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.model.ResponseOption;
import com.dfirago.drivinglicensetest.common.utils.AssetReader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class DatabaseSetupExecutor implements SetupExecutor {

    private final static String TAG = "DatabaseSetupExecutor";

    private BoxStore boxStore;
    private AssetReader assetReader;

    @Inject
    public DatabaseSetupExecutor(BoxStore boxStore, AssetReader assetReader) {
        this.boxStore = boxStore;
        this.assetReader = assetReader;
    }

    @Override
    public Object execute() throws Exception {

        Log.d(TAG, "Populating database - START");

        Box<Category> categoryBox = boxStore.boxFor(Category.class);
        Box<Question> questionBox = boxStore.boxFor(Question.class);

        categoryBox.removeAll();
        questionBox.removeAll();

        String questionsJson = assetReader.readText("questions.json");
        JSONArray questions = new JSONArray(questionsJson);

        Log.d(TAG, "Total number of questions: " + questions.length());

        Map<CategoryType, Category> categoryMap = CategoryProvider.forTypes(CategoryType.values());

        for (int i = 0; i < questions.length(); i++) {

            Log.d(TAG, "Processing question: " + (i + 1));

            JSONObject questionObject = questions.getJSONObject(i);
            Question question = new Question();
            question.setValue(questionObject.getString("value"));
            question.setMedia(questionObject.optString("media"));
            question.setGroup(QuestionGroup.valueOf(questionObject.getString("group")));
            question.setComment(questionObject.optString("comment"));
            question.setPoints(questionObject.getInt("points"));
            question.setType(QuestionType.valueOf(questionObject.getString("type")));

            JSONArray categories = questionObject.getJSONArray("categories");
            for (int j = 0; j < categories.length(); j++) {
                String category = categories.getString(j);
                CategoryType categoryType = CategoryType.valueOf(category);
                question.getCategories().add(categoryMap.get(categoryType));
            }

            JSONArray options = questionObject.getJSONArray("options");
            for (int j = 0; j < options.length(); j++) {
                JSONObject optionObject = options.getJSONObject(j);
                ResponseOption responseOption = new ResponseOption();
                responseOption.setValue(optionObject.getString("value"));
                responseOption.setCorrect(optionObject.getBoolean("correct"));
                question.getOptions().add(responseOption);
            }

            questionBox.put(question);
        }

        Log.d(TAG, "Populating database - FINISH");

        return new Object();
    }
}
