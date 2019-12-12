package com.example.foodshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.foodshop.model.ResponseLoginDTO;
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
    ResponseLoginDTO user;

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
        user = (ResponseLoginDTO) intent.getSerializableExtra("user");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setMessage("Đặt Món Thành Công");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CartActivity.this, MainActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onFail(String msg) {
                if(msg != "") {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                    builder.setMessage("Số tiền của bạn không đủ!!!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(CartActivity.this, MainActivity.class);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
