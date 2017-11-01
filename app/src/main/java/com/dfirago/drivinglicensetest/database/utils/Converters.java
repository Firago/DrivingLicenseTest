package com.dfirago.drivinglicensetest.database.utils;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;
import com.dfirago.drivinglicensetest.database.model.enums.ConfigurationKey;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionGroup;
import com.dfirago.drivinglicensetest.database.model.enums.QuestionType;
import com.dfirago.drivinglicensetest.database.model.types.ResponseOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 11/1/2017.
 */
public class Converters {

    @TypeConverter
    public static CategoryType toCategoryType(String value) {
        return value == null ? null : CategoryType.valueOf(value);
    }

    @TypeConverter
    public static String toString(CategoryType value) {
        return value == null ? null : value.name();
    }

    @TypeConverter
    public static ConfigurationKey toConfigurationKey(String value) {
        return value == null ? null : ConfigurationKey.valueOf(value);
    }

    @TypeConverter
    public static String toString(ConfigurationKey value) {
        return value == null ? null : value.name();
    }

    @TypeConverter
    public static QuestionGroup toQuestionGroup(String value) {
        return value == null ? null : QuestionGroup.valueOf(value);
    }

    @TypeConverter
    public static String toString(QuestionGroup value) {
        return value == null ? null : value.name();
    }

    @TypeConverter
    public static QuestionType toQuestionType(String value) {
        return value == null ? null : QuestionType.valueOf(value);
    }

    @TypeConverter
    public static String toString(QuestionType value) {
        return value == null ? null : value.name();
    }

    @TypeConverter
    public static List<ResponseOption> toResponseOptionList(String value) {
        List<ResponseOption> result = new ArrayList<>();
        if (value != null) {
            String[] tokens = value.split("###");
            for (String token : tokens) {
                result.add(Converters.toResponseOption(token));
            }
        }
        return result;
    }

    @TypeConverter
    public static String toString(List<ResponseOption> value) {
        List<String> mapped = new ArrayList<>();
        if (value != null) {
            for (ResponseOption responseOption : value) {
                mapped.add(Converters.toString(responseOption));
            }
            return TextUtils.join("###", mapped);
        }
        return null;
    }

    private static ResponseOption toResponseOption(String value) {
        String[] tokens = value.split("::");
        ResponseOption responseOption = new ResponseOption();
        responseOption.setValue(tokens[0]);
        responseOption.setCorrect(Boolean.valueOf(tokens[1]));
        return responseOption;
    }

    private static String toString(ResponseOption value) {
        return value == null ? null : String.format("%s::%b", value.getValue(), value.isCorrect());
    }
}
