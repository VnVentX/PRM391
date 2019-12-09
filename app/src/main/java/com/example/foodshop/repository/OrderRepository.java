package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Order;
import com.example.foodshop.model.OrderDetail;

public interface OrderRepository {
    void createOrder(Order order, CallbackData<OrderDetail> callBack);
}
