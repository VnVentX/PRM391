package com.example.foodshop.model;

import java.io.Serializable;
import java.util.List;

public class Store implements Serializable {
    String idStore;
    String name, imageUrl, idUser, description, createAt, startTime, endTime;
    boolean enabled;
    List<Category> categoryStoresByIdStore;
    List<Product> productsByIdStore;

    public String getIdStore() {
        return idStore;
    }

    public void setIdStore(String idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Category> getCategoryStoresByIdStore() {
        return categoryStoresByIdStore;
    }

    public void setCategoryStoresByIdStore(List<Category> categoryStoresByIdStore) {
        this.categoryStoresByIdStore = categoryStoresByIdStore;
    }

    public List<Product> getProductsByIdStore() {
        return productsByIdStore;
    }

    public void setProductsByIdStore(List<Product> productsByIdStore) {
        this.productsByIdStore = productsByIdStore;
    }
}
