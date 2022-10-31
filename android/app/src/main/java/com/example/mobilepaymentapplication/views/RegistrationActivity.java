package com.example.mobilepaymentapplication.views;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilepaymentapplication.R;
import com.example.mobilepaymentapplication.databinding.ActivityRegistrationBinding;
import com.example.mobilepaymentapplication.view_models.RegistrationActivityViewModel;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding registrationBinding;
    private RegistrationActivityViewModel registrationActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        registrationBinding.setRegistrationActivity(this);
        registrationActivityViewModel = new ViewModelProvider(this).get(RegistrationActivityViewModel.class);
    }

    public void register(String phoneNumber, String password, String confirmPassword){
                System.out.println("Registration successful");
                if(phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "Boşlukları doldurunuz.", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(confirmPassword)){
                        sendRegistrationRequest(phoneNumber, password, confirmPassword);
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Şifreler uyuşmuyor.", Toast.LENGTH_SHORT).show();
                    }
                }
    }

    public void sendRegistrationRequest(String phoneNumber, String password, String confirmPassword){
        registrationActivityViewModel.sendRegistrationRequest(this, phoneNumber, password).observe(this, responseBody -> {
            if(responseBody != null){
                System.out.println("Registration successful");
            }
        });
    }
}