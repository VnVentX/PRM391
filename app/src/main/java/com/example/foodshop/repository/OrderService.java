package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OrderService {
    @POST(ConfigApi.ORDER)
    Call<OrderDetail> makeOrder(@Body Order order);
}
