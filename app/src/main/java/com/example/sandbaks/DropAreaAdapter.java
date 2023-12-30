package com.example.sandbaks;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DropAreaAdapter extends RecyclerView.Adapter<DropAreaAdapter.DropAreaViewHolder> {
    Context context;
    ArrayList<ItemCards> itemCardsArrayList;

    public DropAreaAdapter(Context context, ArrayList<ItemCards> itemCardsArrayList) {
        this.context = context;
        this.itemCardsArrayList = itemCardsArrayList;
    }

    // Add this method inside your DropAreaAdapter class
    private int findEmptyPosition() {
        for (int i = 0; i < itemCardsArrayList.size(); i++) {
            if (itemCardsArrayList.get(i).getItemName().equals(" ")) {
                return i; // Found an empty position
            }
        }
        return -1; // No empty position found
    }

    @NonNull
    @Override
    public DropAreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_view, parent, false);
        return new DropAreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DropAreaViewHolder holder, int position) {
        holder.itemName.setText(itemCardsArrayList.get(position).getItemName());
        holder.itemIcon.setImageBitmap(itemCardsArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemCardsArrayList.size();
    }

    public class DropAreaViewHolder extends RecyclerView.ViewHolder {

        ImageView itemIcon;
        TextView itemName;


        public DropAreaViewHolder(@NonNull View itemView) {
            super(itemView);

            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);


            // Drag Item from sidebar to screen
            itemView.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View view, DragEvent dragEvent) {
                    int state = dragEvent.getAction();

                    String draggedItemName = Utils.itemName;
                    Bitmap draggedItemIcon = Utils.itemIcon;

                    int position = getAdapterPosition();

                    switch (state) {
                        case DragEvent.ACTION_DROP:

                            // If an item already exists on the said screen position
                            if (!itemName.getText().equals(" ")) {
                                // Combine
                                ElementsCombination combinations = new ElementsCombination();
                                combinations.paleolithicAge();
                                combinations.BronzeAge();
                                combinations.IronAge();
                                combinations.SpanishEra();
                                combinations.AmericanEra();
                                combinations.JapaneseEra();
                                combinations.SelfRule();

                                List<String> result = combinations.getCombination(Utils.itemName, itemName.getText().toString());

                                if (result != null) {

                                    for (String item: result){
                                        PlayerData.addItemEra(item);
                                    }

                                    if (result.size() == 1){
                                        itemName.setText(result.get(0));

                                        try {
                                            itemIcon.setImageBitmap(Utils.getBitmapFromAssets(result.get(0) + ".png"));
                                        } catch (IOException e) {
                                            Log.e("Failed to get Image", e.toString());
                                        }

                                        ItemCards updatedItem = null;
                                        try {
                                            updatedItem = new ItemCards(result.get(0), Utils.getBitmapFromAssets(result.get(0) + ".png"));
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        itemCardsArrayList.set(position, updatedItem);
                                    }

                                    else {
                                        // Place the first result at the specified position
                                        itemName.setText(result.get(0));
                                        try {
                                            itemIcon.setImageBitmap(Utils.getBitmapFromAssets(result.get(0) + ".png"));
                                        } catch (IOException e) {
                                            Log.e("Failed to get Image", e.toString());
                                        }
                                        ItemCards updatedItem = null;
                                        try {
                                            updatedItem = new ItemCards(result.get(0), Utils.getBitmapFromAssets(result.get(0) + ".png"));
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        itemCardsArrayList.set(position, updatedItem);

                                        // Place the remaining items anywhere on itemCardsArrayList that has an item with the name as " "
                                        for (int i = 1; i < result.size(); i++) {
                                            int emptyPosition = findEmptyPosition();
                                            if (emptyPosition != -1) {
                                                try {
                                                    itemCardsArrayList.set(emptyPosition, new ItemCards(result.get(i), Utils.getBitmapFromAssets(result.get(i) + ".png")));
                                                } catch (IOException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            } else {

                                            }
                                        }
                                    }
                                } else {
                                    if (Utils.wasOnScreen) {
                                        // Restore the item to the previous location
                                        ItemCards updatedItem = new ItemCards(draggedItemName, draggedItemIcon);
                                        itemCardsArrayList.set(Utils.previousLocation, updatedItem);

                                        // Clear the current position
                                        itemName.setText(" ");
                                        itemIcon.setImageBitmap(Utils.createEmptyBitmap());

                                        Utils.wasOnScreen = false;
                                        Utils.previousLocation = 0;
                                    }
                                }
                            }
                            // If there isn't an item yet
                            else {
                                itemName.setText(draggedItemName);
                                itemIcon.setImageBitmap(draggedItemIcon);

                                ItemCards updatedItem = new ItemCards(draggedItemName, draggedItemIcon);
                                itemCardsArrayList.set(position, updatedItem);
                            }

                            notifyDataSetChanged();

                            break;
                    }

                    return true;
                }
            });


            // DRAG THE ITEM TO A DIFFERENT POSITION
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    PlayGame.closeSideBar();

                    int position = getAdapterPosition();

                    Utils.previousLocation = position;
                    Utils.wasOnScreen = true;

                    if (position != RecyclerView.NO_POSITION) {
                        ClipData clipData;
                        View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
                        clipData = ClipData.newPlainText(itemName.getText().toString(), null);


                        String newName = " ";
                        Bitmap newIcon = Utils.createEmptyBitmap();

                        Utils.itemName = itemName.getText().toString();
                        Utils.itemIcon = Utils.getBitmapFromImageView(itemIcon);

                        ItemCards updatedItem = new ItemCards(newName, newIcon);
                        itemCardsArrayList.set(position, updatedItem);

                        view.startDrag(clipData, dragShadowBuilder, view, 0);


                        notifyDataSetChanged();

                        return true;
                    }
                    return false;
                }
            });
        }
    }
}