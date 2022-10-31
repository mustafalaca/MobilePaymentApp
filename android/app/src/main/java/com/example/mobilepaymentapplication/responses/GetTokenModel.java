package com.example.mobilepaymentapplication.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTokenModel {

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "GetTokenModel{" +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
