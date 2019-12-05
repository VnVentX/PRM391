package com.example.foodshop.presenter;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Category;
import com.example.foodshop.repository.CategoryRepository;
import com.example.foodshop.repository.CategoryRepositoryImpl;
import com.example.foodshop.view.CategoryListView;
import com.example.foodshop.view.LoadingView;

import java.util.List;

public class CategoryListPresenter {
    CategoryRepository categoryRepo = new CategoryRepositoryImpl();
    CategoryListView categoryListView;
    LoadingView loadingView;

    public CategoryListPresenter(CategoryListView categoryListView, LoadingView loadingView) {
        this.categoryListView = categoryListView;
        this.loadingView = loadingView;
    }

    public void fetchListCategoryFromServer() {
        categoryRepo.fetchListCategory(new CallbackData<List<Category>>() {
            @Override
            public void onSuccess(List<Category> categories) {
                loadingView.hideProgress();
                categoryListView.onSuccessFetchCategoryList(categories);
            }

            @Override
            public void onFail(String msg) {
                loadingView.hideProgress();
                categoryListView.onFailureFetchCategoryList(msg);
            }
        });
        loadingView.showProgress();
    }
}
