package com.example.sandbaks;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Utils {
    private static Context context;
    public static void setContext(Context ctx) {  // Add this method
        context = ctx;
    }
    public static String itemName;
    public static Bitmap itemIcon;
    public static boolean wasOnScreen;
    public static int previousLocation = 0;

    public static int userID = -1;

    public static String userName = "Guest";

    public static String createSeparatedString(ArrayList<String> itemList) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < itemList.size(); i++) {
            result.append(itemList.get(i));
            if (i < itemList.size() - 1) {
                result.append("|");
            }
        }

        Log.e("ITEMS", result.toString());

        return result.toString();
    }

    static ArrayList<String> getItemsFromString(String items) {
        if (items.isEmpty()) {
            return new ArrayList<>();
        }

        String[] elements = items.split("\\|"); // Needs to have "\\" because "|" is a special character
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static Bitmap getBitmapFromAssets(String fileName) throws IOException {
        AssetManager assetManager = MainActivity.context.getAssets();
        InputStream istr = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        istr.close();
        return bitmap;
    }

    public static Bitmap getBitmapFromImageView(ImageView imageView) {
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();

        Bitmap bitmap = Bitmap.createBitmap(imageView.getDrawingCache());

        imageView.setDrawingCacheEnabled(false);

        return bitmap;
    }

    public static Bitmap createEmptyBitmap() {
        int width = 500;
        int height = 500;

        Bitmap emptyBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        emptyBitmap.eraseColor(Color.TRANSPARENT);

        return emptyBitmap;
    }

    public static String findItemEra(String item){

        List<String> stoneItems = Arrays.asList(context.getResources().getStringArray(R.array.stone_age_items));
        List<String> bronzeItems = Arrays.asList(context.getResources().getStringArray(R.array.bronze_age_items));
        List<String> ironItems = Arrays.asList(context.getResources().getStringArray(R.array.iron_age_items));
        List<String> spanishItems = Arrays.asList(context.getResources().getStringArray(R.array.spanish_era_items));
        List<String> americanItems = Arrays.asList(context.getResources().getStringArray(R.array.american_era_items));
        List<String> japaneseItems = Arrays.asList(context.getResources().getStringArray(R.array.japanese_occupation_items));
        List<String> phItems = Arrays.asList(context.getResources().getStringArray(R.array.philippine_commonwealth_items));


        if (stoneItems.contains(item)){
            return "Stone";
        }

        else if (bronzeItems.contains(item)){
            return "Bronze";
        }

        else if (ironItems.contains(item)){
            return "Iron";
        }

        else if (spanishItems.contains(item)){
            return "Spanish";
        }

        else if (americanItems.contains(item)){
            return "American";
        }

        else if (japaneseItems.contains(item)){
            return "Japanese";
        }

        else if (phItems.contains(item)){
            return "PH";
        }

        return "None";
    }

    public static String encryptPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean validPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }
}
