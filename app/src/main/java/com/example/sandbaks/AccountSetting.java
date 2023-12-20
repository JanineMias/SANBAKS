package com.example.sandbaks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AccountSetting extends AppCompatActivity {
    EditText Username,Password;
    TextView SignUp;
    Button LogIn,back;
    DBHelper dbHelper = new DBHelper();


    public ImageView city;
    public AnimationDrawable city_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        init();
    }


    public void init() {

        // database  method here
        city = findViewById(R.id.ivCity);
        city_animation = (AnimationDrawable) city.getDrawable();

        dbHelper.initDB(this);

        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        SignUp = findViewById(R.id.tvSignUp);
        LogIn = findViewById(R.id.btnLogIn);
        back = findViewById(R.id.btnBackAccountS);

        // back to homepage
        back.setOnClickListener(v -> back());
        //if username and pass is correct then the user can log in
        LogIn.setOnClickListener(v -> LogIn());

        // goes to signup page
        SignUp.setOnClickListener(v -> SignUp());
}
    public void LogIn() {
        String username = Username.getText().toString();
        String password = Password.getText().toString();

        if (username.equals("")){
            Toast.makeText(this, "Enter Username!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.equals("")){
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean login = dbHelper.login(username, password);

        // Checks if login success
        if (!login){
            Toast.makeText(this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent h = new Intent(AccountSetting.this, MainActivity.class);

        h.putExtra("isLoggedIn", true);
        Toast.makeText(this, "Login Success!!", Toast.LENGTH_SHORT).show();
        startActivity(h);

    }
    private void SignUp() {
        Intent SignUp = new Intent(AccountSetting.this, AccountCreation.class);
        startActivity(SignUp);
    }
    private void back() {
        Intent back = new Intent(AccountSetting.this, MainActivity.class);
        startActivity(back);
    }
    public void onStart() {
        super.onStart();
        city_animation.start();
    }
}