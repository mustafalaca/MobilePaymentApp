package com.example.mobilepaymentapplication.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobilepaymentapplication.common_functions.Intent;
import com.example.mobilepaymentapplication.models.RegistrationRequest;
import com.example.mobilepaymentapplication.network.RetrofitApi;
import com.example.mobilepaymentapplication.network.RetrofitClient;

import okhttp3.ResponseBody;

public class RegistrationActivityRepository {

    private RetrofitApi retrofitApi;
    private Intent intent;

    public RegistrationActivityRepository(){}

    public LiveData<ResponseBody> sendRegistrationRequest(Context context, String phoneNumber, String password){
        MutableLiveData<ResponseBody> data = new MutableLiveData<>();
        retrofitApi = RetrofitClient.getRetrofitInstance().create(RetrofitApi.class);
        RegistrationRequest registrationRequest = new RegistrationRequest(phoneNumber, password);
        retrofitApi.registrationRequest(registrationRequest).enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if(response.code() == 200){
                    data.setValue(response.body());
                    Toast.makeText(context, "Kayıt İşlemi Başarılı", Toast.LENGTH_SHORT).show();
                    intent = new Intent();
                    intent.finish(context);
                    System.out.println("200");
                }else if(response.code() == 409){
                    Toast.makeText(context, "Bu kullanıcı daha önceden kayıt edilmiştir.", Toast.LENGTH_SHORT).show();
                }
                else{
                    System.out.println("else");
                    Toast.makeText(context, "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                data.setValue(null);
                System.out.println("sendRegistrationRequest onFailure: " + t.getMessage().toString());
                Toast.makeText(context, "Kayıt Başarısız(onFailure)", Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }
}
