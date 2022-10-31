package com.example.mobilepaymentapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilepaymentapplication.R;
import com.example.mobilepaymentapplication.databinding.ActivityLoginBinding;
import com.example.mobilepaymentapplication.shared_preferences.RecordLoginData;
import com.example.mobilepaymentapplication.view_models.LoginActivityViewModel;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;
    private LoginActivityViewModel loginActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setLoginActivity(this);
        loginActivityViewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);
    }

    public void login(String phoneNumber, String password){
        if(phoneNumber.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Boşlukları doldurunuz.", Toast.LENGTH_SHORT).show();
        }else{
            RecordLoginData.setPhoneNumber(this, phoneNumber);
            RecordLoginData.setPassword(this, password);
            loginRequest(phoneNumber, password);
        }
    }

    public void toRegistrationActivity(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void loginRequest(String phoneNumber, String password){
        loginActivityViewModel.sendLoginRequest(this, phoneNumber, password).observe(this, tokenResponse ->{
            if (tokenResponse != null){
                if(loginBinding.idRememberMe.isChecked()){
                    RecordLoginData.setRememberMeChecked(LoginActivity.this, true);
                }
            }
        });
    }
}