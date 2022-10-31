package com.example.mobilepaymentapplication.view_models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobilepaymentapplication.repositories.RegistrationActivityRepository;

import okhttp3.ResponseBody;

public class RegistrationActivityViewModel extends ViewModel {

    private RegistrationActivityRepository registrationActivityRepository;

    public RegistrationActivityViewModel(){
        registrationActivityRepository = new RegistrationActivityRepository();
    }

    public LiveData<ResponseBody> sendRegistrationRequest(Context context, String phoneNumber, String password){
        return registrationActivityRepository.sendRegistrationRequest(context, phoneNumber, password);
    }

}
