package com.example.sandbaks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class account_creation extends AppCompatActivity {

    EditText getUser, getEmail, getPass, getRePass;

    Button back, createAccount;
    DBHelper dbHelper = new DBHelper();

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
        back = findViewById(R.id.btnBack);
        createAccount = findViewById(R.id.btnCreateAccount);

        // adds information to database and goes back to home
        createAccount.setOnClickListener(v -> createAccount());

        //goes back to account setting/LogIn page

        back.setOnClickListener(v -> back());

        dbHelper.initDB(this);
    }

    public boolean passwordChecker(String password, String confirmedPassword){
        //Return true if the password matches the confirmed password
        return password.equals(confirmedPassword);
    }

    public boolean emailChecker(String email){

        // Email Validity using REGEX
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        // Return true if the email address is valid, else false
        return matcher.matches();
    }

    public void createAccount() {

        String username = getUser.getText().toString();
        String email = getEmail.getText().toString();
        String password = getPass.getText().toString();
        String confirmedPassword = getRePass.getText().toString();

        // Checks email validity
        if (!emailChecker(email)) {
            Toast.makeText(this, "Enter Valid Email!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Checks the passwords
        if (!passwordChecker(password, confirmedPassword)){
            Toast.makeText(this, "The passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Register user
        dbHelper.register(username, email, password);

        Intent backHome = new Intent(account_creation.this, account_setting.class);
        // pop up will be done if the created account is added to the database
        startActivity(backHome);
    }

    public void back() {
                Intent backHome = new Intent(account_creation.this, account_setting.class);
                startActivity(backHome);

    }
}
