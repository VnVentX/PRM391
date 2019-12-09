package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;

public interface UserRepository {
    void checkLogin(RequestLogin logins, boolean isGmail, CallbackData<ResponseLoginDTO> callBack);
}
