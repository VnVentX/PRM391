package com.example.foodshop.api_util;

public interface CallbackData<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
