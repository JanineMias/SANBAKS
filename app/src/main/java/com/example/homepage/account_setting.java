package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class account_setting extends AppCompatActivity {
    EditText Username,password;
    TextView SignUp;
    String user;
    Button LogIn,back;

    SQLiteDatabase db;

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

        Username = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
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
            // fetch from database yung pass confirmation with naka switch case

                Intent h = new Intent(account_setting.this, MainActivity.class);
                user = Username.getText().toString();
                h.putExtra("username", user);
                startActivity(h);

    }
    private void SignUp() {
        Intent SignUp = new Intent(account_setting.this, account_creation.class);
        startActivity(SignUp);
    }
    private void back() {
        Intent back = new Intent(account_setting.this, MainActivity.class);
        startActivity(back);
    }
    public void onStart() {
        super.onStart();
        city_animation.start();
    }

}