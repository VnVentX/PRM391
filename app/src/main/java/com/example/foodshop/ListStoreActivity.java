package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.example.foodshop.adapter.StoreListViewAdapter;
import com.example.foodshop.model.Store;
import com.example.foodshop.presenter.StoreListPresenter;
import com.example.foodshop.view.LoadingView;
import com.example.foodshop.view.StoreListView;

import java.util.ArrayList;
import java.util.List;

public class ListStoreActivity extends AppCompatActivity implements LoadingView, StoreListView{
    ListView listViewStore;
    StoreListViewAdapter storeListViewAdapter;
    List<Store> stores;
    StoreListPresenter storeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_store);

        Intent intent = getIntent();
        String idCategory = intent.getStringExtra("idCategory");
        String name = intent.getStringExtra("categoryName");

        TextView title = findViewById(R.id.txtTitle);
        title.setText(name);

        listViewStore = findViewById(R.id.storeContainer);
        storeListPresenter = new StoreListPresenter(this, this);
        stores = new ArrayList<>();
        storeListViewAdapter = new StoreListViewAdapter(stores);
        listViewStore.setAdapter(storeListViewAdapter);
        storeListPresenter.fetchStoreByCateFromServer(idCategory);
        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Store store = stores.get(i);
                Intent intent = new Intent(ListStoreActivity.this, StoreActivity.class);
                intent.putExtra("store", store);
                startActivityForResult(intent, 200);
            }
        });
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
        Toast.makeText(ListStoreActivity.this, throwable, Toast.LENGTH_LONG).show();
    }
}
