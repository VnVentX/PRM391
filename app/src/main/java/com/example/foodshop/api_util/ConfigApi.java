package com.example.foodshop.api_util;

public interface ConfigApi {
    String BASE_URL = "https://mffood.herokuapp.com/api/";

    String LOGIN = "users/login";
    String GET_ALL_STORE = "stores/";
    String GET_ALL_CATEGORY = "categories/";
    String GET_STORE_BY_CATEGORY = "stores/byCate/{idCategory}";
}
