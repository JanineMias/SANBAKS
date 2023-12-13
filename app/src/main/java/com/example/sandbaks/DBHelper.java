package com.example.sandbaks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.mindrot.jbcrypt.BCrypt;

import java.io.File;

public class DBHelper {
    public final String DATABASE_NAME = "SANDBAKS";
    public final String TABLE_NAME = "account_info";

    SQLiteDatabase db;

    Cursor cursor;


    public boolean login(String username, String password) {
        // Retrieve hashed password from the database based on the username
        String storedHashedPassword = getHashedPasswordFromDatabase(username);

        // Check if the entered password is valid
        if (storedHashedPassword != null && validPassword(password, storedHashedPassword)) {
            // Login successful
            return true;
        } else {
            // Login failed
            return false;
        }
    }

    private String getHashedPasswordFromDatabase(String username) {
        String[] columns = {"password"};

        String selection = "username=?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        String hashedPassword = null;

        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("password");

            // Check if the column exists in the cursor
            if (columnIndex != -1) {
                hashedPassword = cursor.getString(columnIndex);
            }
            else {
                Log.e("DB Error", "Column Password not Found!");
            }
        }

        cursor.close();

        return hashedPassword;
    }

    public void register(String username, String email, String password){

        String hashedPassword = encryptPassword(password);

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", hashedPassword);
        values.put("era", 0);

        db.insert(TABLE_NAME, null, values);
    }

    public String encryptPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean validPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

    public void initDB(Context context){
        File dbDirectory = context.getDir("databases", Context.MODE_PRIVATE);

        db = SQLiteDatabase.openOrCreateDatabase(new File(dbDirectory, DATABASE_NAME), null);
        db.execSQL(""+
                "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + "(userID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "username TEXT, " +
                "email TEXT, " +
                "password TEXT, " +
                "era INTEGER);"
        );
    }

    public void updateAccount(String userID){

    }
}
