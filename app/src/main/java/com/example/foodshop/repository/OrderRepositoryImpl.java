package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

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
}
