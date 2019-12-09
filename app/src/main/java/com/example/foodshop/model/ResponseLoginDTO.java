package com.example.foodshop.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseLoginDTO implements Serializable {

    @SerializedName("idUser")
    String idUser;

    @SerializedName("tokenJWT")
    String tokenJWT;

    @SerializedName("userRoleDTO")
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

    @Override
    public String toString() {
        return "ResponseLoginDTO{" +
                "idUser='" + idUser + '\'' +
                ", tokenJWT='" + tokenJWT + '\'' +
                ", userRoleDTO=" + userRoleDTO +
                '}';
    }
}
