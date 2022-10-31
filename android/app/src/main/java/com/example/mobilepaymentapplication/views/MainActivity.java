package com.example.mobilepaymentapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilepaymentapplication.R;
import com.example.mobilepaymentapplication.databinding.PartialMainActivityBinding;
import com.example.mobilepaymentapplication.shared_preferences.RecordLoginData;
import com.example.mobilepaymentapplication.view_models.MainActivityViewModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{

    private PartialMainActivityBinding mainBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainActivity(this);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        if (!RecordLoginData.getRememberMeChecked(this)) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void wallet(String phoneNumber){
        mainActivityViewModel.sendWalletRequest(this, phoneNumber).observe(this, walletResponse ->{
            if (walletResponse != null){
                mainBinding.tvBalance.setText(walletResponse.getTotal());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (RecordLoginData.getIsLoggedIn(this)) {
            System.out.println("Ödemeden sonrası 2");
            wa(RecordLoginData.getPhoneNumber(this));
        }
    }
}