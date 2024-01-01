package com.example.sandbaks;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class EraUnlocker {

    static DBHelper db = new DBHelper();

    public static void unlock(){
        db.initDB(MainActivity.context);
        String era = db.getUserEra(Utils.userID);

        ArrayList<String> eras = Utils.getItemsFromString(era);

        if (eras.contains("Bronze")){
            unlockBronze();
        }

        if (eras.contains("Iron")){
            unlockIron();
        }

        if (eras.contains("Spanish")){
            unlockSpanish();
        }

        if (eras.contains("American")){
            unlockAmerican();
        }

        if (eras.contains("Japan")){
            unlockJapan();
        }

        if (eras.contains("PH")){
            unlockPH();
        }
    }

    public static void unlockBronze(){
        if (PlayGame.bronze.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.bronze.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Bronze");
        Toast.makeText(MainActivity.context, "Bronze Age Unlocked!", Toast.LENGTH_SHORT).show();
    }

    public static void unlockIron(){
        if (PlayGame.iron.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.iron.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Iron");
        Toast.makeText(MainActivity.context, "Iron Age Unlocked!", Toast.LENGTH_SHORT).show();
    }

    public static void unlockSpanish(){
        if (PlayGame.spanish.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.spanish.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Spanish");
        Toast.makeText(MainActivity.context, "Spanish Era Unlocked!", Toast.LENGTH_SHORT).show();
    }

    public static void unlockAmerican(){
        if (PlayGame.american.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.american.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|American");
        Toast.makeText(MainActivity.context, "American Era Unlocked!", Toast.LENGTH_SHORT).show();
    }

    public static void unlockJapan(){
        if (PlayGame.japan.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.japan.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Japan");
        Toast.makeText(MainActivity.context, "Japanese Era Unlocked!", Toast.LENGTH_SHORT).show();
    }

    public static void unlockPH(){
        if (PlayGame.self.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.self.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|PH");
        Toast.makeText(MainActivity.context, "Self Rule Era Unlocked!", Toast.LENGTH_SHORT).show();
    }
}