package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderService {
    @POST(ConfigApi.ORDER)
    Call<OrderDetail> makeOrder(@Body Order order);

    @GET(ConfigApi.GET_ORDER_BY_USERID)
    Call<List<OrderDetail>> getAllOrder(@Path("idUser") String idUser);
}
