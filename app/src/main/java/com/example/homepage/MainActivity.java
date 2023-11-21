package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends AppCompatActivity {

    public ImageView space;
    public AnimationDrawable animationDrawable;

    public Button play, account;

    SQLiteDatabase db;

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
        Intent accountSet = new Intent(MainActivity.this, account_setting.class);
        startActivity(accountSet);
    }


    public void onStart() {
        super.onStart();
        animationDrawable.start();
        initDB();
    }

    public void initDB() {
        db = openOrCreateDatabase("UserDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS UserDatabase;");
        db.execSQL("CREATE TABLE IF NOT EXISTS UserDatabase (UserID TEXT PRIMARY KEY, UserName TEXT, UserPass TEXT, GameProgress INTEGER);");

        // pano ihash yung password?

    }
}