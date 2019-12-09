package com.example.foodshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderDetail implements Serializable {
    @SerializedName("idOrders")
    String idOrders;

    @SerializedName("createAt")
    String createAt;

    @SerializedName("storeName")
    String storeName;

    @SerializedName("userFullName")
    String userFullName;

    @SerializedName("notes")
    String notes;

    @SerializedName("rating")
    String rating;

    @SerializedName("status")
    String status;

    @SerializedName("totalPrice")
    double totalPrice;

    @SerializedName("orderDetail")
    List<OrderDetailList> orderDetail;

    public String getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(String idOrders) {
        this.idOrders = idOrders;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderDetailList> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailList> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
