package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginlogout.Model.User;

public class Register extends AppCompatActivity {
    public static int RESULT = 1000 ;
    TextView email , password ,userName , confirmPassword ;
    User newUser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        confirmPassword = findViewById(R.id.regisConfirmPassword);
        userName  = findViewById(R.id.regisUserName);
    }

    public void handleBack(View view){
        Intent intent = new Intent();
        intent.putExtra("user" , newUser);
        setResult(RESULT , intent);
        finish();
    }

    public void handleRegister(View view){
        String emailValue = email.getText().toString();
        String passwordlValue = password.getText().toString();
        String userNameValue = userName.getText().toString();
        String confirmPasswordlValue = confirmPassword.getText().toString();
        if(passwordlValue.equals(confirmPasswordlValue)){
            newUser = new User(userNameValue , emailValue , passwordlValue);
            Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Password not correct", Toast.LENGTH_SHORT).show();
        }
    }
}