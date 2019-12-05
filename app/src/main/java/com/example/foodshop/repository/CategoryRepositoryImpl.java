package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepositoryImpl implements CategoryRepository {
    CategoryService categoryService = RetrofitConfiguration.getRetrofitAdapter().create(CategoryService.class);
    @Override
    public void fetchListCategory(final CallbackData<List<Category>> callback) {
        Call<List<Category>> call = categoryService.getAllCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> dto = response.body();
                if(dto != null) {
                    callback.onSuccess(dto);
                }else {
                    callback.onFail("Empty Category!!!");
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                callback.onFail((t.getMessage()));
            }
        });
    }
}
