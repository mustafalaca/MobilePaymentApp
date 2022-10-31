package com.example.mobilepaymentapplication.view_models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.mobilepaymentapplication.repositories.LoginActivityRepository;
import com.example.mobilepaymentapplication.responses.GetTokenModel;

public class LoginActivityViewModel extends ViewModel {

    private LoginActivityRepository loginActivityRepository;

    public LoginActivityViewModel(){
        loginActivityRepository = new LoginActivityRepository();
    }

    public LiveData<GetTokenModel> sendLoginRequest(Context context, String phoneNumber, String password){
        return loginActivityRepository.loginRequest(context, phoneNumber, password);
    }

}
