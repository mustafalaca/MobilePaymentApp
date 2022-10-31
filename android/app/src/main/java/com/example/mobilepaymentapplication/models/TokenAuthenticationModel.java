package com.example.mobilepaymentapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenAuthenticationModel {

    @SerializedName("token_password")
    @Expose
    private String tokenPassword;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("password")
    @Expose
    private String password;

    public TokenAuthenticationModel(String tokenPassword, String phoneNumber, String password) {
        this.tokenPassword = tokenPassword;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TokenAuthenticationModel{" +
                "tokenPassword='" + tokenPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
