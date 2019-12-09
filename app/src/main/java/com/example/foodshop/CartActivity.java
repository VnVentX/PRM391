package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodshop.cart.CartObj;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity {
    CartObj cart;
    Order order;
    List<OrderDetail> orderDetailList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent intent = getIntent();
        orderDetailList = new ArrayList<>();
        cart = (CartObj) intent.getSerializableExtra("cart");
        orderDetailList.addAll(cart.getItems().values());
        order = new Order(cart.getIdStore(), cart.getUserId(), "", orderDetailList);
    }
}
