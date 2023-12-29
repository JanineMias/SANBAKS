package com.example.sandbaks;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static String itemName;
    public static Bitmap itemIcon;

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
}
