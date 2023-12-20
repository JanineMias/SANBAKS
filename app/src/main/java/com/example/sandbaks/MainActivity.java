package com.example.sandbaks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean isLoggedIn = false;
    public ImageView space;
    public AnimationDrawable animationDrawable;

    public Button play, account;

    String username;
    TextView user;

    DBHelper dbHelper = new DBHelper();

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
       Intent receivedIntent = getIntent();

       if (!receivedIntent.hasExtra("isLoggedIn")) Log.e("isLoggedIn", "Not yet logged In");

       isLoggedIn = receivedIntent.getBooleanExtra("isLoggedIn", false);

       if (!isLoggedIn){
           Toast.makeText(this, "Login your account first!", Toast.LENGTH_SHORT).show();
           return;
       }

        Intent playGame = new Intent(MainActivity.this, PlayGame.class);
        startActivity(playGame);
    }


    private void AccountSettings() {
        Intent accountSet = new Intent(MainActivity.this, AccountSetting.class);
        startActivity(accountSet);
    }

    public void onStart() {
        super.onStart();
        animationDrawable.start();
        dbHelper.initDB(this);
    }
}