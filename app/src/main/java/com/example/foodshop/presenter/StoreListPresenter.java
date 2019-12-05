package com.example.foodshop.presenter;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Store;
import com.example.foodshop.repository.StoreRepository;
import com.example.foodshop.repository.StoreRepositoryImpl;
import com.example.foodshop.view.LoadingView;
import com.example.foodshop.view.StoreListView;

import java.util.List;

public class StoreListPresenter {
    StoreRepository storeRepo = new StoreRepositoryImpl();
    StoreListView storeListView;
    LoadingView loadingView;

    public StoreListPresenter(StoreListView storeListView, LoadingView loadingView) {
        this.storeListView = storeListView;
        this.loadingView = loadingView;
    }

    public void fetchListStoreFromServer() {
        storeRepo.fetchListStore(new CallbackData<List<Store>>() {
            @Override
            public void onSuccess(List<Store> stores) {
                loadingView.hideProgress();
                storeListView.onSuccessFetchStoreList(stores);
            }

            @Override
            public void onFail(String msg) {
                loadingView.hideProgress();
                storeListView.onFailureFetchStoreList(msg);
            }
        });
        loadingView.showProgress();
    }

    public void fetchStoreByCateFromServer(String idCategory) {
        storeRepo.fetchStoreByCategory(idCategory, new CallbackData<List<Store>>() {
            @Override
            public void onSuccess(List<Store> stores) {
                loadingView.hideProgress();
                storeListView.onSuccessFetchStoreList(stores);
            }

            @Override
            public void onFail(String msg) {
                loadingView.hideProgress();
                storeListView.onFailureFetchStoreList(msg);
            }
        });
        loadingView.showProgress();
    }
}
