package com.example.foodshop.cart;

import com.example.foodshop.model.OrderDetailList;
import com.example.foodshop.model.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CartObj implements Serializable {
    private String userId;
    private String idStore;
    private String note;
    private Map<String, OrderDetailList> items;
    OrderDetailList orderDetail;
    int quantity = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdStore() {
        return idStore;
    }

    public void setIdStore(String idStore) {
        this.idStore = idStore;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Map<String, OrderDetailList> getItems() {
        return items;
    }

    public void addItemToCart(Product product) {
        if(this.items == null ) {
            this.items = new HashMap<String, OrderDetailList>();
        }
        if(this.items.containsKey(product.getIdProduct())) {
            orderDetail = (OrderDetailList) this.items.get(product.getIdProduct());
            orderDetail.setQuantity(orderDetail.getQuantity() +1);
        }else{
            orderDetail = new OrderDetailList();
            orderDetail.setIdProduct(product.getIdProduct());
            orderDetail.setProductName(product.getName());
            orderDetail.setUnitPrice(product.getPrice());
            orderDetail.setQuantity(1);
        }

        this.items.put(product.getIdProduct(), orderDetail);
    }

    public void removeItemFromCart(Product product) {
        if(this.items == null) {
            return;
        }

        if(this.items.containsKey(product.getIdProduct())) {
            if(this.items.get(product.getIdProduct()).getQuantity() == 1) {
                this.items.remove(product.getIdProduct());
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }else {
                orderDetail = (OrderDetailList) this.items.get(product.getIdProduct());
                orderDetail.setQuantity(orderDetail.getQuantity() -1);
                this.items.put(product.getIdProduct(), orderDetail);
            }
        }
    }
}
