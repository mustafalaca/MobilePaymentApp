package com.example.mobilepaymentapplication.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WalletModel {

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("mep_token")
    @Expose
    private float mepToken;

    @SerializedName("tl")
    @Expose
    private float tl;

    @SerializedName("mep_token_to_tl")
    @Expose
    private String mepTokenToTl;

    @SerializedName("total")
    @Expose
    private String total;


    public WalletModel(String phoneNumber, float mepToken, float tl, String mepTokenToTl, String totalBalance) {
        this.phoneNumber = phoneNumber;
        this.mepToken = mepToken;
        this.tl = tl;
        this.mepTokenToTl = mepTokenToTl;
        this.total = totalBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getMepToken() {
        return mepToken;
    }

    public void setMepToken(float mepToken) {
        this.mepToken = mepToken;
    }

    public float getTl() {
        return tl;
    }

    public void setTl(float tl) {
        this.tl = tl;
    }

    public String getMepTokenToTl() {
        return mepTokenToTl;
    }

    public void setMepTokenToTl(String mepTokenToTl) {
        this.mepTokenToTl = mepTokenToTl;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "WalletModelResponse{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", mepToken=" + mepToken +
                ", tl=" + tl +
                ", mepTokenToTl='" + mepTokenToTl + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
