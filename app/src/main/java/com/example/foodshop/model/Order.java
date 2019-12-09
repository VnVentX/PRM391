package com.example.foodshop.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    String idStore;
    String idUser;
    String notes;
    List<OrderDetail> orderDetailList;

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

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Order(String idStore, String idUser, String notes, List<OrderDetail> orderDetailList) {
        this.idStore = idStore;
        this.idUser = idUser;
        this.notes = notes;
        this.orderDetailList = orderDetailList;
    }
}
