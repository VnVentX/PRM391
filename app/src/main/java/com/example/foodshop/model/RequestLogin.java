package com.example.foodshop.model;

import java.io.Serializable;

public class RequestLogin implements Serializable {
    String email;
    String password;
    String tokenGmail;

    public RequestLogin(String email, String password, String tokenGmail) {
        this.email = email;
        this.password = password;
        this.tokenGmail = tokenGmail;
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

    public String getTokenGmail() {
        return tokenGmail;
    }

    public void setTokenGmail(String tokenGmail) {
        this.tokenGmail = tokenGmail;
    }
}
