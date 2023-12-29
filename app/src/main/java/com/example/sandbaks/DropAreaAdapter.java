package com.example.sandbaks;

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

            itemView.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View view, DragEvent dragEvent) {
                    int state = dragEvent.getAction();

                    String draggedItemName = Utils.itemName;
                    Bitmap draggedItemIcon = Utils.itemIcon;

                    int position = getAdapterPosition();

                    switch (state) {
                        case DragEvent.ACTION_DROP:
                            if (!itemName.getText().equals(" ")) {
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
                            } else {
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
        }
    }
}