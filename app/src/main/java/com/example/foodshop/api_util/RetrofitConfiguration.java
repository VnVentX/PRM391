package com.example.foodshop.api_util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {
    private static Retrofit retrofitAdapter;

    public static Retrofit getRetrofitAdapter() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdW1ib3kuOTZAZ21haWwuY29tIiwiZXhwIjoxNTc2MTI3MTAyfQ.1RQKOifrCbzfG9nUjieKTLfxsL59e2NJwV302R9cXfx71gMPMFvmu-seWBQ9wZhGFDvFn-LjXgPrnCrv94603g")
                        .build();
                return chain.proceed(newRequest);
            }
        };
        if(retrofitAdapter == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .readTimeout(80, TimeUnit.SECONDS)
                    .build();
            retrofitAdapter = new Retrofit.Builder().baseUrl(ConfigApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofitAdapter;
    }
}
