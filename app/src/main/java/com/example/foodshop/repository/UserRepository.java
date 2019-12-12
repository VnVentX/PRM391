package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.model.User;

public interface UserRepository {

    void checkLogin(RequestLogin logins, boolean isGmail, CallbackData<ResponseLoginDTO> callBack);
    void fetchUserDetail(String idUser, CallbackData<User> callBack);
    void editUser(User user, CallbackData<User> callBack);
}
