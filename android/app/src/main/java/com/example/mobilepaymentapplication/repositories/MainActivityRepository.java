package com.example.mobilepaymentapplication.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilepaymentapplication.models.PhoneNumberModel;
import com.example.mobilepaymentapplication.network.RetrofitApi;
import com.example.mobilepaymentapplication.network.RetrofitClient;
import com.example.mobilepaymentapplication.responses.GetTokenModel;
import com.example.mobilepaymentapplication.responses.WalletModel;
import com.example.mobilepaymentapplication.shared_preferences.RecordAmount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityRepository {

    private RetrofitApi retrofitApi;

    public LiveData<WalletModel> walletRequest(Context context,String phoneNumber){
        MutableLiveData<WalletModel> data = new MutableLiveData<>();
        retrofitApi = RetrofitClient.getRetrofitInstance().create(RetrofitApi.class);
        PhoneNumberModel postPhoneNumberModel = new PhoneNumberModel(phoneNumber);
        Call<WalletModel> call = retrofitApi.getAllWalletData(postPhoneNumberModel);
        call.enqueue(new Callback<WalletModel>() {
            @Override
            public void onResponse(Call<WalletModel> call, Response<WalletModel> response) {
                if(response.code() == 200) {
                    data.setValue(response.body());
                    System.out.println("request: " + call.request().toString());
                    System.out.println("getWallet phone: " + phoneNumber);
                    System.out.println("getWallet Response:    " + response.body().toString());
                    RecordAmount.setTl(context, response.body().getTl());
                    RecordAmount.setMepToken(context, response.body().getMepToken());
                }else if(response.code() == 400){
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WalletModel> call, Throwable t) {
                data.setValue(null);
                Toast.makeText(context, "Connection error", Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }
}
