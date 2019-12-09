package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.foodshop.adapter.OrderListViewAdapter;
import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.cart.CartObj;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;
import com.example.foodshop.model.OrderDetailList;
import com.example.foodshop.repository.OrderRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    CartObj cart;
    Order order;
    List<OrderDetailList> orderDetailList;
    TextView txtStoreName, txtTime, txtTotal;
    EditText txtNote;
    ListView productList;
    String total;
    OrderListViewAdapter adapter;
    OrderRepositoryImpl orderRepo = new OrderRepositoryImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        txtStoreName = findViewById(R.id.txtStoreName);
        txtTime = findViewById(R.id.txtTime);
        productList = findViewById(R.id.orderContainer);
        txtNote = findViewById(R.id.txtNote);
        txtTotal = findViewById(R.id.txtTotalPrice);

        Intent intent = getIntent();
        total = intent.getStringExtra("total");
        orderDetailList = new ArrayList<>();
        cart = (CartObj) intent.getSerializableExtra("cart");
        orderDetailList.addAll(cart.getItems().values());
        order = new Order(cart.getIdStore(), cart.getUserId(), null, orderDetailList);

        txtStoreName.setText(intent.getStringExtra("storeName"));
        txtTime.setText("Thời Gian: " + dateFormat.format(date));
        txtTotal.setText("Tổng Tiền: " + total + "VND");

        adapter = new OrderListViewAdapter(orderDetailList);
        adapter.notifyDataSetChanged();
        productList.setAdapter(adapter);

    }

    public void clickToOrder(View view) {
        if(txtNote.getText().length() != 0) {
            order.setNotes(txtNote.getText().toString());
        }
        orderRepo.createOrder(order, new CallbackData<OrderDetail>() {
            @Override
            public void onSuccess(OrderDetail orderDetail) {
                Intent intent = new Intent(CartActivity.this, ViewOrderActivity.class);
                intent.putExtra("orderDetail", orderDetail);
                startActivity(intent);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
