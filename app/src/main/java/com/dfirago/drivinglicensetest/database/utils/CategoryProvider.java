package com.dfirago.drivinglicensetest.database.utils;

import com.dfirago.drivinglicensetest.database.model.entities.Category;
import com.dfirago.drivinglicensetest.database.model.enums.CategoryType;

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
