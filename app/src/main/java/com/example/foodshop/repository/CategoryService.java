package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET(ConfigApi.GET_ALL_CATEGORY)
    Call<List<Category>> getAllCategory();
}
