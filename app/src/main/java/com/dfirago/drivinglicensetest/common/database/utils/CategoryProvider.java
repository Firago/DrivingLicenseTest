package com.dfirago.drivinglicensetest.common.database.utils;

import com.dfirago.drivinglicensetest.common.model.Category;
import com.dfirago.drivinglicensetest.common.model.CategoryType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/13/2017.
 */
public abstract class CategoryProvider {

    public static Map<CategoryType, Category> forTypes(CategoryType... types) {
        Map<CategoryType, Category> result = new HashMap<>();
        for (CategoryType type : types) {
            result.put(type, new Category(type));
        }
        return result;
    }
}
