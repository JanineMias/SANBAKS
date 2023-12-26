package com.example.sandbaks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemRecyclerViewAdapater extends RecyclerView.Adapter<ItemRecyclerViewAdapater.MyViewHolder> {

    Context context;
    ArrayList<ItemCards> itemCardsArrayList;

    public ItemRecyclerViewAdapater(Context context, ArrayList<ItemCards> itemCardsArrayList){
        this.context = context;
        this.itemCardsArrayList = itemCardsArrayList;
    }

    @NonNull
    @Override
    public ItemRecyclerViewAdapater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_card_view, parent, false);

        return new ItemRecyclerViewAdapater.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewAdapater.MyViewHolder holder, int position) {
//        holder.itemName.setText(itemCardsArrayList.get(position).getItemName());
        holder.itemIcon.setImageBitmap(itemCardsArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return itemCardsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView itemIcon;
//        TextView itemName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemIcon = itemView.findViewById(R.id.itemIcon);
//            itemName = itemView.findViewById(R.id.itemName);


        }
    }
}