package com.example.foodshop.model;

import java.io.Serializable;
import java.util.List;

public class ResponseLoginDTO implements Serializable {
    String idUser;
    String tokenJWT;
    List<String> userRoleDTO;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTokenJWT() {
        return tokenJWT;
    }

    public void setTokenJWT(String tokenJWT) {
        this.tokenJWT = tokenJWT;
    }

    public List<String> getUserRoleDTO() {
        return userRoleDTO;
    }

    public void setUserRoleDTO(List<String> userRoleDTO) {
        this.userRoleDTO = userRoleDTO;
    }
}
