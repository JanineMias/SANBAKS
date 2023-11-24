package com.example.homepage;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class playgame extends AppCompatActivity {



    public Button stone, bronze, iron, spanish, american, japan, self;

    // menu setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        init ();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        if (item.getItemId() == R.id.homepage) {
            Toast.makeText(this, "back to homepage", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.volume){

            Toast.makeText(this, "adjust volume", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.findElement) {
            Toast.makeText(this, "find an unlocked element", Toast.LENGTH_SHORT).show();
            return true;
        }

            else super.onOptionsItemSelected(item);
        return false;
    }


    public void init() {
        // code for stone fragment
        stone = findViewById(R.id.btnStone);
        stone.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, stoneFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for bronze fragment
        bronze = findViewById(R.id.btnBronze);
        bronze.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, bronzeFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for iron fragment
        iron = findViewById(R.id.btnIron);
        iron.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, ironFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for spanish fragment
        spanish = findViewById(R.id.btnSpanish);
        spanish.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, spanishFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for american fragment
        american = findViewById(R.id.btnAmerica);
        american.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, americanFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for japan fragment
        japan = findViewById(R.id.btnJapan);
        japan.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, japanFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for self rule fragment
        self = findViewById(R.id.btnSelf);
        self.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, selfFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

    }
}