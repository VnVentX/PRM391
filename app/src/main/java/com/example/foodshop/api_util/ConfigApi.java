package com.example.foodshop.api_util;

public interface ConfigApi {
    String BASE_URL = "https://mffood.herokuapp.com/api/";

    String LOGIN = "users/login";
    String GET_ALL_STORE = "stores/";
    String GET_ALL_CATEGORY = "categories/";
    String GET_STORE_BY_CATEGORY = "stores/byCate/{idCategory}";
    String ORDER = "orders/";
    String GET_ORDER_BY_USERID = "orders/byUser/{idUser}";
    String GET_USERD_DETAIL = "users/{idUser}";
    String UPDATE_USER = "users/{idUser}";
    String GET_ACCOUNT_USERID = "accounts/{idUser}";
    String SEARCH_STORE = "stores/search";
}
