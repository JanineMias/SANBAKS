package com.example.sandbaks;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static Bitmap getBitmapFromAssets(String fileName) throws IOException {
        AssetManager assetManager = MainActivity.context.getAssets();
        InputStream istr = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        istr.close();
        return bitmap;
    }
}
