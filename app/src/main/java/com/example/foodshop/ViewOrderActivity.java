package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.foodshop.adapter.OrderListViewAdapter;
import com.example.foodshop.model.OrderDetail;
import com.example.foodshop.model.OrderDetailList;

import java.util.List;

public class ViewOrderActivity extends AppCompatActivity {
    OrderDetail orderDetail;
    TextView txtStoreName, txtTime, txtTotal, txtUsername, txtNote;
    ListView productList;
    OrderListViewAdapter adapter;
    List<OrderDetailList> orderList;
    double total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        Intent intent = getIntent();
        orderDetail = (OrderDetail) intent.getSerializableExtra("orderDetail");

        txtUsername = findViewById(R.id.txtUserName);
        txtStoreName = findViewById(R.id.txtStoreName);
        txtTime = findViewById(R.id.txtTime);
        productList = findViewById(R.id.orderContainer);
        txtNote = findViewById(R.id.txtNote);
        txtTotal = findViewById(R.id.txtTotalPrice);

        txtUsername.setText(orderDetail.getUserFullName());
        txtStoreName.setText(orderDetail.getStoreName());
        if(orderDetail.getNotes().length() != 0) {
            txtNote.setText(orderDetail.getNotes());
        }

        orderList = orderDetail.getOrderDetail();
        adapter = new OrderListViewAdapter(orderList);
        adapter.notifyDataSetChanged();
        productList.setAdapter(adapter);

        for(OrderDetailList a: orderList) {
            total = total + (a.getQuantity()*a.getUnitPrice());
        }
        txtTotal.setText("Tổng Tiền: " + total + "VND");
    }
}
