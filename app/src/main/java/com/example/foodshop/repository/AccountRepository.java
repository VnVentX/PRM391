package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Account;

import java.util.List;

public interface AccountRepository {
    void fetchAccountByUserID(String idUser, CallbackData<List<Account>> callBack);
}
