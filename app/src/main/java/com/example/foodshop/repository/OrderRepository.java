package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order, CallbackData<OrderDetail> callBack);
    void fetchAllOrder(String idUser, CallbackData<List<OrderDetail>> callBack);
}
