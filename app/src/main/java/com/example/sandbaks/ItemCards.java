package com.example.sandbaks;

import android.graphics.Bitmap;

public class ItemCards {
        String itemName;
        Bitmap image;

    public ItemCards(String itemName, Bitmap image) {
        this.itemName = itemName;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public Bitmap getImage() {
        return image;
    }
}
