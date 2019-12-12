package com.example.foodshop.repository;

import com.example.foodshop.api_util.ConfigApi;
import com.example.foodshop.model.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AccountService {
    @GET(ConfigApi.GET_ACCOUNT_USERID)
    Call<List<Account>> getAccountByUserID(@Path("idUser") String idUser);
}
