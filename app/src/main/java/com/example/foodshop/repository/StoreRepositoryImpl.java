package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreRepositoryImpl implements StoreRepository{
    StoreService storeService = RetrofitConfiguration.getRetrofitAdapter().create(StoreService.class);

    @Override
    public void fetchListStore(final CallbackData<List<Store>> callback) {
        Call<List<Store>> call = storeService.getAllStore();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                List<Store> dto = response.body();
                if(dto != null ) {
                    callback.onSuccess(dto);
                }else  {
                    callback.onFail("No Data!!!");
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                if(t != null) {
                    callback.onFail(t.getMessage());
                }
            }
        });
    }

    @Override
    public void fetchStoreByCategory(String idCategory, final CallbackData<List<Store>> callback) {
        Call<List<Store>> call = storeService.getStore(idCategory);
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                List<Store> dto = response.body();
                if(dto != null ) {
                    callback.onSuccess(dto);
                }else  {
                    callback.onFail("No Data!!!");
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                if(t != null) {
                    callback.onFail(t.getMessage());
                }
            }
        });
    }
}
