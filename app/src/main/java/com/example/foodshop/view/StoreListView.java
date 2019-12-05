package com.example.foodshop.view;

import com.example.foodshop.model.Store;

import java.util.List;

public interface StoreListView {
    void onSuccessFetchStoreList(List<Store> movieArrayList);
    void onFailureFetchStoreList(String throwable);
}
