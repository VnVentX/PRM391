package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;

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
}
