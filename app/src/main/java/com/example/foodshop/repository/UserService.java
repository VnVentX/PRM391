package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @POST(ConfigApi.LOGIN)
    Call<ResponseLoginDTO> login(@Body RequestLogin logins, @Query("isGmail") boolean isGmail);

    @GET(ConfigApi.GET_USERD_DETAIL)
    Call<User> getUserDetail(@Path("idUser") String idUser);

    @PUT(ConfigApi.UPDATE_USER)
    Call<User> updateUser(@Body User user);
}
