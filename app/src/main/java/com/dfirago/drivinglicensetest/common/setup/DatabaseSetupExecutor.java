package com.dfirago.drivinglicensetest.common.setup;

import android.support.annotation.NonNull;
import android.util.Log;

import com.dfirago.drivinglicensetest.common.database.CategoryService;
import com.dfirago.drivinglicensetest.common.database.ConfigurationService;
import com.dfirago.drivinglicensetest.common.database.QuestionService;
import com.dfirago.drivinglicensetest.common.database.utils.CategoryProvider;
import com.dfirago.drivinglicensetest.common.model.Category;
import com.dfirago.drivinglicensetest.common.model.CategoryType;
import com.dfirago.drivinglicensetest.common.model.ConfigurationEntry;
import com.dfirago.drivinglicensetest.common.model.ConfigurationKey;
import com.dfirago.drivinglicensetest.common.model.Question;
import com.dfirago.drivinglicensetest.common.model.QuestionGroup;
import com.dfirago.drivinglicensetest.common.model.QuestionType;
import com.dfirago.drivinglicensetest.common.model.ResponseOption;
import com.dfirago.drivinglicensetest.common.utils.AssetReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class DatabaseSetupExecutor implements SetupExecutor {

    private final static String TAG = "DatabaseSetupExecutor";

    private final Map<CategoryType, Category> categoryMap = CategoryProvider.forTypes(CategoryType.values());

    private ConfigurationService configurationService;
    private QuestionService questionService;
    private CategoryService categoryService;
    private AssetReader assetReader;

    @Inject
    public DatabaseSetupExecutor(ConfigurationService configurationService, QuestionService questionService,
                                 CategoryService categoryService, AssetReader assetReader) {
        this.configurationService = configurationService;
        this.questionService = questionService;
        this.categoryService = categoryService;
        this.assetReader = assetReader;
    }

    @Override
    public boolean execute() throws Exception {
        Log.d(TAG, "Checking if database needs to be populated based on DATABASE_READY flag");
        ConfigurationEntry databaseReadyEntry = configurationService
                .findByKey(ConfigurationKey.DATABASE_READY, true);
        Log.d(TAG, "DATABASE_READY flag is set to " + databaseReadyEntry.getValue());
        if (Boolean.valueOf(databaseReadyEntry.getValue()).equals(Boolean.FALSE)) {
            populateDatabase();
            databaseReadyEntry.setValue(String.valueOf(true));
            configurationService.put(databaseReadyEntry);
            return true;
        }
        return false;
    }

    private void populateDatabase() throws JSONException {
        Log.d(TAG, "Populating database - START");
        questionService.removeAll();
        categoryService.removeAll();
        JSONArray questions = readQuestions();
        Log.d(TAG, "Total number of questions: " + questions.length());
        for (int i = 0; i < questions.length(); i++) {
            Log.d(TAG, "Processing question: " + (i + 1));
            JSONObject questionObject = questions.getJSONObject(i);
            Question question = parseQuestion(questionObject);
            questionService.put(question);
        }
        Log.d(TAG, "Populating database - FINISH");
    }

    @NonNull
    private Question parseQuestion(JSONObject questionObject) throws JSONException {

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

        return question;
    }

    @NonNull
    private JSONArray readQuestions() throws JSONException {
        String questionsJson = assetReader.readText("questions.json");
        return new JSONArray(questionsJson);
    }
}
