package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodshop.adapter.ProductListViewAdapter;
import com.example.foodshop.cart.CartObj;
import com.example.foodshop.model.Product;
import com.example.foodshop.model.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {
    Store store;
    ListView productList;
    TextView storeName, storeDecrip;
    ImageView storeIamge;
    List<Product> products;
    ProductListViewAdapter productListViewAdapter;
    CartObj cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        cart = new CartObj();
        Intent intent = getIntent();
        store = (Store) intent.getSerializableExtra("store");
        storeName = findViewById(R.id.storeName);
        storeDecrip = findViewById(R.id.storeDecrip);
        storeIamge = findViewById(R.id.storeImage);

        cart.setIdStore(store.getIdStore());
        storeName.setText(store.getName());
        storeDecrip.setText(store.getDescription());
        Glide.with(StoreActivity.this).load(store.getImageUrl()).into(storeIamge);

        productList = findViewById(R.id.foodContainer);
        products = store.getProductsByIdStore();
        productListViewAdapter = new ProductListViewAdapter(products, cart);
        productListViewAdapter.notifyDataSetChanged();
        productList.setAdapter(productListViewAdapter);
    }
}
