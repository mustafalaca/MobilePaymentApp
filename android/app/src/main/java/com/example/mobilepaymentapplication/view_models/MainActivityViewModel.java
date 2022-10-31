package com.example.mobilepaymentapplication.view_models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobilepaymentapplication.repositories.MainActivityRepository;
import com.example.mobilepaymentapplication.responses.WalletModel;

public class MainActivityViewModel extends ViewModel {

    private MainActivityRepository mainActivityRepository;

    public MainActivityViewModel(){
        mainActivityRepository = new MainActivityRepository();
    }

    public LiveData<WalletModel> sendWalletRequest(Context context, String phoneNumber){
        return mainActivityRepository.walletRequest(context, phoneNumber);
    }

}
