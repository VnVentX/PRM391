package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Category;

import java.util.List;

public interface CategoryRepository {
    void fetchListCategory(CallbackData<List<Category>> callback);
}
