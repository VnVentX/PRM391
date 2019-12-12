package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepositoryImpl implements OrderRepository {
    OrderService orderService = RetrofitConfiguration.getRetrofitAdapter().create(OrderService.class);
    @Override
    public void createOrder(Order order, final CallbackData<OrderDetail> callBack) {
        Call<OrderDetail> call = orderService.makeOrder(order);
        call.enqueue(new Callback<OrderDetail>() {
            @Override
            public void onResponse(Call<OrderDetail> call, Response<OrderDetail> response) {
                OrderDetail orderDetail = response.body();
                if(orderDetail != null) {
                    callBack.onSuccess(orderDetail);
                }else {
                    callBack.onFail("Order Error!!!");
                }
            }

            @Override
            public void onFailure(Call<OrderDetail> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }

    @Override
    public void fetchAllOrder(String idUser, final CallbackData<List<OrderDetail>> callBack) {
        Call<List<OrderDetail>> call = orderService.getAllOrder(idUser);
        call.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                List<OrderDetail> orderDetails = response.body();
                if(orderDetails != null) {
                    callBack.onSuccess(orderDetails);
                }else {
                    callBack.onFail("No Order!!!");
                }
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }
}
