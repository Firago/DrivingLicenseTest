package com.dfirago.drivinglicensetest.common.setup;

import android.support.annotation.NonNull;
import android.util.Log;

import com.dfirago.drivinglicensetest.common.utils.AssetReader;
import com.dfirago.drivinglicensetest.database.dao.CategoryDao;
import com.dfirago.drivinglicensetest.database.dao.CategoryQuestionDao;
import com.dfirago.drivinglicensetest.database.dao.ConfigurationDao;
import com.dfirago.drivinglicensetest.database.dao.QuestionDao;
import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.entities.ConfigurationEntry;
import com.dfirago.drivinglicensetest.database.model.entities.Question;
import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.database.model.enums.ConfigurationKey;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionGroup;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
import com.dfirago.drivinglicensetest.database.model.relationships.CategoryQuestion;
import com.dfirago.drivinglicensetest.database.model.types.ResponseOption;
import com.dfirago.drivinglicensetest.database.utils.CategoryProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public class DatabaseSetupExecutor implements SetupExecutor {

    private final static String TAG = "DatabaseSetupExecutor";

    private final Map<CategoryType, Category> categoryMap = CategoryProvider.forTypes(CategoryType.values());

    private ConfigurationDao configurationDao;
    private QuestionDao questionDao;
    private CategoryDao categoryDao;
    private CategoryQuestionDao categoryQuestionDao;
    private AssetReader assetReader;

    @Inject
    public DatabaseSetupExecutor(ConfigurationDao configurationDao, QuestionDao questionDao,
                                 CategoryDao categoryDao, CategoryQuestionDao categoryQuestionDao,
                                 AssetReader assetReader) {
        this.configurationDao = configurationDao;
        this.questionDao = questionDao;
        this.categoryDao = categoryDao;
        this.categoryQuestionDao = categoryQuestionDao;
        this.assetReader = assetReader;
    }

    @Override
    public boolean execute() throws Exception {
        Log.d(TAG, "Checking if database needs to be populated based on DATABASE_READY flag");
        Boolean databaseReady = isDatabaseReady();
        Log.d(TAG, "DATABASE_READY entry value: " + databaseReady);
        if (!Boolean.TRUE.equals(databaseReady)) {
            populateDatabase();
            configurationDao.update(ConfigurationKey.DATABASE_READY, String.valueOf(true));
            return true;
        }
        return false;
    }

    private Boolean isDatabaseReady() {
        String databaseReadyValue = configurationDao.findByKey(ConfigurationKey.DATABASE_READY);
        if (databaseReadyValue == null) {
            databaseReadyValue = String.valueOf(false);
            ConfigurationEntry entry = new ConfigurationEntry();
            entry.setKey(ConfigurationKey.DATABASE_READY);
            entry.setValue(String.valueOf(false));
            configurationDao.insert(entry);
        }
        return Boolean.valueOf(databaseReadyValue);
    }

    private void populateDatabase() throws JSONException {
        Log.d(TAG, "Populating database - START");
        questionDao.deleteAll();
        categoryDao.deleteAll();
        JSONArray questions = readQuestions();
        Log.d(TAG, "Total number of questions: " + questions.length());

        for (Category category : categoryMap.values()) {
            category.setId(categoryDao.insert(category));
        }

        for (int i = 0; i < questions.length(); i++) {
            Log.d(TAG, "Processing question: " + (i + 1));
            JSONObject questionObject = questions.getJSONObject(i);
            Question question = parseQuestion(questionObject);
            question.setId(questionDao.insert(question));
            List<CategoryQuestion> relations = getCategoryQuestionRelations(question, questionObject);
            for (CategoryQuestion relation : relations) {
                categoryQuestionDao.insert(relation);
            }
        }

        Log.d(TAG, "Populating database - FINISH");
    }

    private List<CategoryQuestion> getCategoryQuestionRelations(
            Question question, JSONObject questionObject) throws JSONException {

        List<CategoryQuestion> result = new ArrayList<>();
        JSONArray categories = questionObject.getJSONArray("categories");
        for (int j = 0; j < categories.length(); j++) {
            String category = categories.getString(j);
            CategoryType categoryType = CategoryType.valueOf(category);
            CategoryQuestion categoryQuestion = new CategoryQuestion();
            categoryQuestion.setCategoryId(categoryMap.get(categoryType).getId());
            categoryQuestion.setQuestionId(question.getId());
            result.add(categoryQuestion);
        }
        return result;
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
