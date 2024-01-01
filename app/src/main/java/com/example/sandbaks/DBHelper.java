package com.example.sandbaks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class DBHelper {
    public final String DATABASE_NAME = "SANDBAKS";
    public final String USER_TABLE_NAME = "account_info";
    public final String USER_ITEMS_TABLE_NAME = "user_items";
    public final String USER_ERA_TABLE = "user_era";

    SQLiteDatabase db;

    public void initDB(Context context) {
        File dbDirectory = context.getDir("databases", Context.MODE_PRIVATE);

        db = SQLiteDatabase.openOrCreateDatabase(new File(dbDirectory, DATABASE_NAME), null);
        createUserTable();
        createUserItemsTable();
        createUserEraTable();
    }

    public void createUserTable() {
        db.execSQL("" +
                "CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME +
                "(userID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "username TEXT, " +
                "email TEXT, " +
                "password TEXT);"
        );
    }

    public boolean doesUsernameExist(String username) {
        String[] columns = {"username"};

        String selection = "username=?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(USER_TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        boolean usernameExists = cursor.moveToFirst();
        cursor.close();
        return usernameExists;
    }


    private String getHashedPasswordFromDatabase(String username) {
        String[] columns = {"userID", "password"};


        String selection = "username=?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(USER_TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        String hashedPassword = null;

        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("password");
            int userIDIndex = cursor.getColumnIndex("userID");

            // Check if the column exists in the cursor
            if (columnIndex != -1) {
                hashedPassword = cursor.getString(columnIndex);
            } else {
                Log.e("DB Error", "Column Password not Found!");
            }

            if (userIDIndex != -1) {
                Utils.userID = cursor.getInt(userIDIndex);
                Log.e("USER ID", String.valueOf(Utils.userID));
            } else {
                Log.e("DB Error", "Column UserID not Found!");
            }


        }

        cursor.close();

        return hashedPassword;
    }

    public void register(Context context, String username, String email, String password) {
        if (doesUsernameExist(username)) {
            Toast.makeText(context, "Username already exists!", Toast.LENGTH_SHORT).show();
            return;
        }

        long userID = initialize_user_info(username, email, password);
        initialize_user_items_info(userID);
        initialize_user_era(userID);
    }

    public long initialize_user_info(String username, String email, String password) {
        String hashedPassword = Utils.encryptPassword(password);

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", hashedPassword);

        return db.insert(USER_TABLE_NAME, null, values);
    }

    public void initialize_user_items_info(long userID) {

        ContentValues values = new ContentValues();
        values.put("userID", userID);
        values.put("stone_items", "Wood|Stone|Air|Water|Soil|Human|Animal");
        values.put("bronze_items", "");
        values.put("iron_items", "");
        values.put("spanish_items", "Abacus|Curanderos|Spaniards|Nipa Leaf");
        values.put("american_items", "American|Car|Technology");
        values.put("japanese_items", "Filipino");
        values.put("ph_items", "PC Chip");

        db.insert(USER_ITEMS_TABLE_NAME, null, values);
    }

    public boolean login(String username, String password) {
        // Retrieve hashed password from the database based on the username
        String storedHashedPassword = getHashedPasswordFromDatabase(username);

        // Check if the entered password is valid
        // Login successful
        // Login failed
        return storedHashedPassword != null && Utils.validPassword(password, storedHashedPassword);
    }

    public void createUserEraTable() {
        db.execSQL("" +
                "CREATE TABLE IF NOT EXISTS " + USER_ERA_TABLE +
                "(userID INTEGER PRIMARY KEY NOT NULL, " +
                "era TEXT);"
        );
    }

    public void initialize_user_era(long userID) {
        ContentValues values = new ContentValues();
        values.put("userID", userID);
        values.put("era", "Stone");

        db.insert(USER_ERA_TABLE, null, values);
    }

    public void updateEra(int userID, String era) {
        ContentValues values = new ContentValues();
        values.put("era", era);
        db.update(USER_ERA_TABLE, values, "userID=?", new String[]{Integer.toString(userID)});
    }

    public String getUserEra(long userID) {
        String columnName = "era";

        String[] columns = {columnName};
        String selection = "userID=?";
        String[] selectionArgs = {String.valueOf(userID)};

        String era = null;;

        Cursor cursor = db.query(USER_ERA_TABLE, columns, selection, selectionArgs, null, null, null);


        if (cursor.moveToFirst()){
            int columnIndex = cursor.getColumnIndex(columnName);

            if (columnIndex != -1){
                era = cursor.getString(columnIndex);
            }

            else {
                Log.e("DB Error", "Column " + columnName + " not found!");
            }
        }

        cursor.close();

        return era;
    }

    public void createUserItemsTable() {
        db.execSQL("" +
                "CREATE TABLE IF NOT EXISTS " + USER_ITEMS_TABLE_NAME +
                "(userID INTEGER PRIMARY KEY NOT NULL, " +
                "stone_items TEXT, " +
                "bronze_items TEXT, " +
                "iron_items TEXT, " +
                "spanish_items TEXT, " +
                "american_items TEXT, " +
                "japanese_items TEXT, " +
                "ph_items TEXT);"
        );
    }

    public void updateStoneItems(int userID, String stoneItems) {
        ContentValues values = new ContentValues();
        values.put("stone_items", stoneItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{Integer.toString(userID)});
    }

    public void updateBronzeItems(int userID, String bronzeItems) {
        ContentValues values = new ContentValues();
        values.put("bronze_items", bronzeItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public void updateIronItems(int userID, String ironItems) {
        ContentValues values = new ContentValues();
        values.put("iron_items", ironItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public void updateSpanishItems(int userID, String spanishItems) {
        ContentValues values = new ContentValues();
        values.put("spanish_items", spanishItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public void updateAmericanItems(int userID, String americanItems) {
        ContentValues values = new ContentValues();
        values.put("american_items", americanItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public void updateJapaneseItems(int userID, String japaneseItems) {
        ContentValues values = new ContentValues();
        values.put("japanese_items", japaneseItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public void updatePHItems(int userID, String phItems) {
        ContentValues values = new ContentValues();
        values.put("ph_items", phItems);
        db.update(USER_ITEMS_TABLE_NAME, values, "userID=?", new String[]{String.valueOf(userID)});
    }

    public String getStoneItems(int userID) {
        return getItemsForEra(userID, "stone_items");
    }

    public String getBronzeItems(int userID) {
        return getItemsForEra(userID, "bronze_items");
    }

    public String getIronItems(int userID) {
        return getItemsForEra(userID, "iron_items");
    }

    public String getSpanishItems(int userID) {
        return getItemsForEra(userID, "spanish_items");
    }

    public String getAmericanItems(int userID) {
        return getItemsForEra(userID, "american_items");
    }

    public String getJapaneseItems(int userID) {
        return getItemsForEra(userID, "japanese_items");
    }

    public String getPHItems(int userID) {
        return getItemsForEra(userID, "ph_items");
    }

    private String getItemsForEra(int userID, String columnName) {
        String[] columns = {columnName};
        String selection = "userID=?";
        String[] selectionArgs = {String.valueOf(userID)};

        Cursor cursor = db.query(USER_ITEMS_TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        String items = null;

        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(columnName);

            if (columnIndex != -1) {
                items = cursor.getString(columnIndex);
            } else {
                Log.e("DB Error", "Column " + columnName + " not found!");
            }
        }

        cursor.close();

        return items;
    }
}
