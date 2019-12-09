package com.example.foodshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodshop.adapter.StoreListViewAdapter;
import com.example.foodshop.model.Category;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.model.Store;
import com.example.foodshop.presenter.CategoryListPresenter;
import com.example.foodshop.presenter.StoreListPresenter;
import com.example.foodshop.view.CategoryListView;
import com.example.foodshop.view.LoadingView;
import com.example.foodshop.view.StoreListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements StoreListView, LoadingView, CategoryListView {
    ListView listViewStore;
    StoreListViewAdapter storeListViewAdapter;
    List<Store> stores;
    StoreListPresenter storeListPresenter;

    List<Category> categories;
    CategoryListPresenter categoryListPresenter;

    ResponseLoginDTO user;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        MainActivity mainActivity = (MainActivity) view.getContext();
        user = mainActivity.userInfo();

        //load store
        listViewStore = view.findViewById(R.id.courseList);
        storeListPresenter = new StoreListPresenter(this, this);
        stores = new ArrayList<>();
        storeListViewAdapter = new StoreListViewAdapter(stores);
        listViewStore.setAdapter(storeListViewAdapter);
        storeListPresenter.fetchListStoreFromServer();
        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Store store = stores.get(i);
                Intent intent = new Intent(getActivity(), StoreActivity.class);
                intent.putExtra("store", store);
                intent.putExtra("user", user);
                startActivityForResult(intent, 200);
            }
        });

        //load category
        categoryListPresenter = new CategoryListPresenter(this, this);
        categories = new ArrayList<>();
        categoryListPresenter.fetchListCategoryFromServer();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            transaction.remove(fragment);
        }
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 200 && resultCode == Activity.RESULT_OK && data.getBooleanExtra("updated",false)){
            storeListPresenter.fetchListStoreFromServer();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccessFetchStoreList(List<Store> movieArrayList) {
        stores.clear();
        stores.addAll(movieArrayList);
        storeListViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailureFetchStoreList(String throwable) {
        Toast.makeText(getContext(), throwable, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessFetchCategoryList(List<Category> movieArrayList) {
        categories.clear();
        categories.addAll(movieArrayList);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        for(Category c : categories) {
            transaction.add(R.id.categoryContainer, new ItemCategoryFragment(c));
        }
        transaction.commit();
    }

    @Override
    public void onFailureFetchCategoryList(String throwable) {
        Toast.makeText(getContext(), throwable, Toast.LENGTH_LONG).show();
    }
}
