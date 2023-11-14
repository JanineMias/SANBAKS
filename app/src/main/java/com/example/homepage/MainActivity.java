package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ImageView space;
    public AnimationDrawable animationDrawable;

    public Button play, account;

    String username;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init() {
        space = findViewById(R.id.background);
        animationDrawable = (AnimationDrawable) space.getDrawable();
        play = findViewById(R.id.btnPlay);
        account = findViewById(R.id.btnAccount);
        user = findViewById(R.id.tvIGN);

        username = user.getText().toString();

        // goes to play the main game or tutorial page
        play.setOnClickListener(v -> Play());

        //goes to account setting page
        account.setOnClickListener(v -> AccountSettings());

    }
    private void Play() {
        Intent playGame = new Intent(MainActivity.this, playgame.class);
        startActivity(playGame);
    }


    private void AccountSettings() {
        Intent playGame = new Intent(MainActivity.this, account_setting.class);
        startActivity(playGame);
    }


    public void onStart() {
        super.onStart();
        animationDrawable.start();
    }

}