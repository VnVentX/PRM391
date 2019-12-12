package com.example.foodshop.repository;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.api_util.RetrofitConfiguration;
import com.example.foodshop.model.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepositoryImpl implements AccountRepository {
    AccountService service = RetrofitConfiguration.getRetrofitAdapter().create(AccountService.class);

    @Override
    public void fetchAccountByUserID(String idUser, final CallbackData<List<Account>> callBack) {
        Call<List<Account>> call = service.getAccountByUserID(idUser);
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                List<Account> accounts = response.body();
                if(accounts != null) {
                    callBack.onSuccess(accounts);
                }else{
                    callBack.onFail("Null Account");
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                if(t != null) {
                    callBack.onFail(t.getMessage());
                }
            }
        });
    }
}
