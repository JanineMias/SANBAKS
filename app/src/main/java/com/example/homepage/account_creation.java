package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class account_creation extends AppCompatActivity {

    EditText getUser, getEmail, getPass, getRePass;

    Button back, createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        init();

    }

    public void init() {
        getUser = findViewById(R.id.etUserName);
        getEmail = findViewById(R.id.etEmail);
        getPass = findViewById(R.id.etPass);
        getRePass = findViewById(R.id.etConfirmPass);
      //  back = findViewById(R.id.btnBack);
        createAccount = findViewById(R.id.btnCreateAccount);

        // adds information to database and goes back to home
        createAccount.setOnClickListener(v -> createAccount());

        //goes back to account setting/LogIn page

        back.setOnClickListener(v -> back());

    }

    public void createAccount() {
                Intent backHome = new Intent(account_creation.this, MainActivity.class);
                startActivity(backHome);
    }

    public void back() {
                Intent backHome = new Intent(account_creation.this, account_setting.class);
                startActivity(backHome);

    }
}
