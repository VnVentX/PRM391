package com.example.foodshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    @SerializedName("idStore")
    String idStore;
    @SerializedName("idUser")
    String idUser;
    @SerializedName("notes")
    String notes;
    @SerializedName("orderDetailDTOList")
    List<OrderDetailList> orderDetailDTOList;

    public String getIdStore() {
        return idStore;
    }

    public void setIdStore(String idStore) {
        this.idStore = idStore;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Order(String idStore, String idUser, String notes, List<OrderDetailList> orderDetailDTOList) {
        this.idStore = idStore;
        this.idUser = idUser;
        this.notes = notes;
        this.orderDetailDTOList = orderDetailDTOList;
    }

    public List<OrderDetailList> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailList> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }
}
