package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodshop.adapter.StoreListViewAdapter;
import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Store;
import com.example.foodshop.repository.StoreRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    ListView listViewStore;
    List<Store> storesList;
    StoreListViewAdapter storeListViewAdapter;
    StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_store);

        TextView title = findViewById(R.id.txtTitle);
        listViewStore = findViewById(R.id.storeContainer);
        storesList = new ArrayList<>();

        Intent intent = getIntent();
        String searchValue = intent.getStringExtra("searchValue");
        title.setText(searchValue);
        storeRepository.fetchStoreByName(searchValue, new CallbackData<List<Store>>() {
            @Override
            public void onSuccess(List<Store> stores) {
                storesList = stores;
                if(storesList != null) {
                    storeListViewAdapter = new StoreListViewAdapter(storesList);
                    storeListViewAdapter.notifyDataSetChanged();
                    listViewStore.setAdapter(storeListViewAdapter);
                }else {
                    Toast.makeText(SearchResultActivity.this, "None Store", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });

        listViewStore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Store store = storesList.get(i);
                Intent intent = new Intent(SearchResultActivity.this, StoreActivity.class);
                intent.putExtra("store", store);
                startActivityForResult(intent, 200);
            }
        });
    }
}
