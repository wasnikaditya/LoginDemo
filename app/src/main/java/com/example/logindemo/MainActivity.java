package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;

    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;
    private  TextView userRegistration;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        Info = findViewById(R.id.tvInfo);
        Info.setText("No of  attempts remaining: 5");
        Login = findViewById(R.id.btnLogin);
        userRegistration = findViewById(R.id.tvRegister);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));

            }
        });
    }


    private void validate(String userName,String userPassword) {
        if ((userName=="Admin")&&(userPassword=="1234")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {

            counter--;
            Info.setText("No of attempts remaining:" + String.valueOf(counter));
            if(counter==0) {
                Login.setEnabled(false);
            }
        }
    }

    }


