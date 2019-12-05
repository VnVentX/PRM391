package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Store;

import java.util.List;

public interface StoreRepository {
    void fetchListStore(CallbackData<List<Store>> callback);
    void fetchStoreByCategory(String idCategory, CallbackData<List<Store>> callback);
}
