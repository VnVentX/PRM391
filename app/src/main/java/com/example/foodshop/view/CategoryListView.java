package com.example.foodshop.view;

import com.example.foodshop.model.Category;

import java.util.List;

public interface CategoryListView {
    void onSuccessFetchCategoryList(List<Category> movieArrayList);
    void onFailureFetchCategoryList(String throwable);
}
