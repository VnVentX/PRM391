package com.example.foodshop.repository;

import android.util.Log;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRespositoryImpl implements UserRepository {
    UserService userService = RetrofitConfiguration.getRetrofitAdapter().create(UserService.class);
    @Override
    public void checkLogin(RequestLogin logins, boolean isGmail, final CallbackData<ResponseLoginDTO> callBack) {
        Call<ResponseLoginDTO> call = userService.login(logins, isGmail);
        call.enqueue(new Callback<ResponseLoginDTO>() {
            @Override
            public void onResponse(Call<ResponseLoginDTO> call, Response<ResponseLoginDTO> response) {
                ResponseLoginDTO loginDTO = response.body();
                Log.d("REQUEST_LOGINDTO", "Login: " + loginDTO);
                if(loginDTO != null) {
                    callBack.onSuccess(loginDTO);
                }else {
                    callBack.onFail("Login Wrong!!!");
                }
            }

            @Override
            public void onFailure(Call<ResponseLoginDTO> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }

    public UserRespositoryImpl() {
        super();
    }

    @Override
    public void fetchUserDetail(String idUser, final CallbackData<User> callBack) {
        Call<User> call = userService.getUserDetail(idUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if(user != null) {
                    callBack.onSuccess(user);
                }else{
                    callBack.onFail("User Error");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }

    @Override
    public void editUser(User user, final CallbackData<User> callBack) {
        Call<User> call = userService.updateUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if(user != null) {
                    callBack.onSuccess(user);
                }else{
                    callBack.onFail("User Error");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }
}
