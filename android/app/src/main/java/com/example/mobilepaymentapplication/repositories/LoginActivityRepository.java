package com.example.mobilepaymentapplication.repositories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilepaymentapplication.common_functions.Intent;
import com.example.mobilepaymentapplication.models.TokenAuthenticationModel;
import com.example.mobilepaymentapplication.network.RetrofitApi;
import com.example.mobilepaymentapplication.network.RetrofitClient;
import com.example.mobilepaymentapplication.network.TokenInterceptor;
import com.example.mobilepaymentapplication.responses.GetTokenModel;
import com.example.mobilepaymentapplication.shared_preferences.RecordLoginData;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityRepository {

    private RetrofitApi retrofitApi;
    private com.example.mobilepaymentapplication.common_functions.Intent intent;
    public static String accessToken, token_password;

    public LoginActivityRepository(){}

    public LiveData<GetTokenModel> loginRequest(Context context, String phoneNumber, String password){
        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH");
        String strDate = sdf.format(c.getTime());
        token_password = strDate;
        MutableLiveData<GetTokenModel> data = new MutableLiveData<>();
        retrofitApi = RetrofitClient.getRetrofitInstance().create(RetrofitApi.class);
        TokenAuthenticationModel tokenModel = new TokenAuthenticationModel(token_password, phoneNumber, password);
        retrofitApi.tokenAuthenticationRequest(tokenModel).enqueue(new Callback<GetTokenModel>() {
            @Override
            public void onResponse(Call<GetTokenModel> call, Response<GetTokenModel> response) {
                if(response.code() == 200){
                    data.setValue(response.body());
                    accessToken = response.body().getAccessToken();
                    TokenInterceptor.setAccessToken(accessToken);
                    RecordLoginData.setIsLoggedIn(context, true);
                    RecordLoginData.setTokenData(context, accessToken);
                    intent = new Intent();
                    intent.finish(context);
                }else if (response.code() == 401) {
                    Toast.makeText(context, "Kullanıcı adı ya da şifre hatalı.", Toast.LENGTH_SHORT).show();
                    System.out.println("401");

                } else if (response.code() == 500) {
                    Toast.makeText(context, "Giriş Başarısız ", Toast.LENGTH_SHORT).show();
                    System.out.println("500");

                } else {
                    Toast.makeText(context, "Giriş Başarısız", Toast.LENGTH_SHORT).show();
                    System.out.println("else");

                }
            }

            @Override
            public void onFailure(Call<GetTokenModel> call, Throwable t) {
                data.setValue(null);
                System.out.println("onFailure");

            }
        });
        return data;
    }
}
