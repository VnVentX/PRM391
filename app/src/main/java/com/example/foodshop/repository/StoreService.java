package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface StoreService {
    @GET(ConfigApi.GET_ALL_STORE)
    Call<List<Store>> getAllStore();
    @GET(ConfigApi.GET_STORE_BY_CATEGORY)
    Call<List<Store>> getStore(@Path("idCategory") String idCategory);
}
