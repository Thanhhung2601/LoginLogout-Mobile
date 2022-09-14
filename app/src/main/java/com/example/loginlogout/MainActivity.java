package com.example.loginlogout ;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginlogout.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView email , password ;
    ArrayList<User> users = new ArrayList<User>();
    User newUser ;
    User userFinded = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
    }

    public void handleRegister(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Register.class);
        startActivityForResult(intent , Register.RESULT);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void handleLogin(View view){
        users.forEach((user) -> {
            if(user.getEmail().equals(newUser.getEmail())){
                userFinded = user ;
            }
        });
        if(userFinded != null){
            if(userFinded.getPassword().equals(password.getText().toString())){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Home.class) ;
                intent.putExtra("userData" , userFinded);
                startActivity(intent);
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Password wrong", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Not found user !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Register.RESULT){
            newUser = (User) data.getExtras().getSerializable("user");
            users.add(newUser);
        }
    }


}