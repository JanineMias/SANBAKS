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
            unlockBronze(true);
        }

        if (eras.contains("Iron")){
            unlockIron(true);
        }

        if (eras.contains("Spanish")){
            unlockSpanish(true);
        }

        if (eras.contains("American")){
            unlockAmerican(true);
        }

        if (eras.contains("Japan")){
            unlockJapan(true);
        }

        if (eras.contains("PH")){
            unlockPH(true);
        }
    }

    public static void unlockBronze(boolean fromDB){
        if (PlayGame.bronze.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.bronze.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Bronze");

        if(!fromDB){
            Toast.makeText(MainActivity.context, "Bronze Age Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Unlock Iron");
    }

    public static void unlockIron(boolean fromDB){
        if (PlayGame.iron.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.iron.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Iron");

        if (!fromDB){
            Toast.makeText(MainActivity.context, "Iron Age Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Unlock Spaniards");
    }

    public static void unlockSpanish(boolean fromDB){
        if (PlayGame.spanish.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.spanish.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Spanish");

        if (!fromDB){
            Toast.makeText(MainActivity.context, "Spanish Era Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Unlock Education");
    }

    public static void unlockAmerican(boolean fromDB){
        if (PlayGame.american.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.american.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|American");

        if (!fromDB){
            Toast.makeText(MainActivity.context, "American Era Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Unlock Literature");
    }

    public static void unlockJapan(boolean fromDB){
        if (PlayGame.japan.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.japan.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|Japan");

        if (!fromDB){
            Toast.makeText(MainActivity.context, "Japanese Era Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Unlock Democracy");
    }

    public static void unlockPH(boolean fromDB){
        if (PlayGame.self.getVisibility() == View.VISIBLE){
            return;
        }

        PlayGame.self.setVisibility(View.VISIBLE);

        String era = db.getUserEra(Utils.userID);
        db.updateEra(Utils.userID, era+"|PH");

        if (!fromDB){
            Toast.makeText(MainActivity.context, "Self Rule Era Unlocked!", Toast.LENGTH_SHORT).show();
        }

        PlayGame.goalText.setText("Current Goal: Discover Other Elements");
    }
}