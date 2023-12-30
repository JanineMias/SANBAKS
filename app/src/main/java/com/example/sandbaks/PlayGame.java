package com.example.sandbaks;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayGame extends AppCompatActivity {
    public Button stone, bronze, iron, spanish, american, japan, self;
    private static boolean openSidebar;
    private String currentMenu = "None";
    static LinearLayout sidebar;

    ArrayList<ItemCards> itemsOnScreen = new ArrayList<>();

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
        setupRecyclerView();
        PlayerData.initialItems();
        init();
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
            sideBar("Stone");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, StoneFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for bronze fragment
        bronze = findViewById(R.id.btnBronze);
        bronze.setOnClickListener(v -> {
            sideBar("Bronze");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, BronzeFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for iron fragment
        iron = findViewById(R.id.btnIron);
        iron.setOnClickListener(v -> {
            sideBar("Iron");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, IronFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for spanish fragment
        spanish = findViewById(R.id.btnSpanish);
        spanish.setOnClickListener(v -> {
            sideBar("Spanish");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, SpanishFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for american fragment
        american = findViewById(R.id.btnAmerica);
        american.setOnClickListener(v -> {
            sideBar("American");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, AmericanFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for japan fragment
        japan = findViewById(R.id.btnJapan);
        japan.setOnClickListener(v -> {
            sideBar("Japan");
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, JapanFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });
        // code for self rule fragment
        self = findViewById(R.id.btnSelf);
        self.setOnClickListener(v -> {
            sideBar("Self");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, SelfFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });


    }

    public void sideBar(String newMenu){
        if (currentMenu.equalsIgnoreCase("None")){
            openOrClose();;
        }

        else {
            if(currentMenu.equalsIgnoreCase(newMenu)){
                openOrClose();
            }

            else{
                if(!openSidebar){
                    openSideBar();;
                }
            }
        }
        currentMenu = newMenu;
    }



    public void openOrClose(){
        if (openSidebar) {
            closeSideBar();
        } else {
            openSideBar();
        }
    }

    public void openSideBar() {
        sidebar = findViewById(R.id.sidebarButtons);
        final int startMargin = 0;
        final int endMargin = 300;

        ValueAnimator animator = ValueAnimator.ofInt(startMargin, endMargin);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                updateMargin(animatedValue);
            }
        });
        animator.setDuration(300);
        animator.start();

        openSidebar = true;
    }

    public static void closeSideBar() {

        if (!PlayGame.openSidebar){
            return;
        }

        sidebar = PlayGame.sidebar.findViewById(R.id.sidebarButtons);
        final int startMargin = 300;
        final int endMargin = 0;

        ValueAnimator animator = ValueAnimator.ofInt(startMargin, endMargin);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                updateMargin(animatedValue);
            }
        });
        animator.setDuration(300);
        animator.start();

        PlayGame.openSidebar = false;
    }


    private static void updateMargin(int margin) {
        ViewGroup.MarginLayoutParams sidebarLayoutParams = (ViewGroup.MarginLayoutParams) sidebar.getLayoutParams();
        sidebarLayoutParams.setMarginStart(margin);
        sidebar.setLayoutParams(sidebarLayoutParams);
    }

    private void setupRecyclerView() {
        RecyclerView dropArea = findViewById(R.id.dropSpace);
        GridLayoutManager grid = new GridLayoutManager(this, 4);

        dropArea.setLayoutManager(grid);


        for(int i=0; i<200; i++){
            itemsOnScreen.add(
                    new ItemCards(
                            " ",
                            Utils.createEmptyBitmap()));
        }

        DropAreaAdapter adapter = new DropAreaAdapter(this, itemsOnScreen);

        dropArea.setAdapter(adapter);
    }
}