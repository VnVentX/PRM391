package com.example.foodshop.cart;

import java.util.HashMap;
import java.util.Map;

public class CartObj {
    private String userId;
    private String idStore;
    private String note;
    private Map<String, Integer> items;
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String title) {
        if(this.items == null ) {
            this.items = new HashMap<String, Integer>();
            quantity = 1;
        }
        if(this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;
        }

        this.items.put(title, quantity);
    }

    public void removeItemFromCart(String title) {
        if(this.items == null) {
            return;
        }

        if(this.items.containsKey(title)) {
            if(this.items.containsValue(1)) {
                this.items.remove(title);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            }else {
                quantity = this.items.get(title) - 1;
                this.items.put(title, quantity);
            }
        }
    }
}
