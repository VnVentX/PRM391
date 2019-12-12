package com.example.foodshop.model;

import java.io.Serializable;

public class User implements Serializable {
    String idUser;
    String avatar;
    String firstName;
    String lastName;
    String email;
    String password;
    String createAt;
    String updateAt;
    boolean enabled;
    String tokenEmail;
    String tokenJWT;
    double balance;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTokenEmail() {
        return tokenEmail;
    }

    public void setTokenEmail(String tokenEmail) {
        this.tokenEmail = tokenEmail;
    }

    public String getTokenJWT() {
        return tokenJWT;
    }

    public void setTokenJWT(String tokenJWT) {
        this.tokenJWT = tokenJWT;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
