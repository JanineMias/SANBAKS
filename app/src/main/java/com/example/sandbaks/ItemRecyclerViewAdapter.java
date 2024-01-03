package com.example.sandbaks;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.MyViewHolder> {

    private final ItemRecyclerViewInterface itemRecyclerViewInterface;
    Context context;
    ArrayList<ItemCards> itemCardsArrayList;
    int color;

    public ItemRecyclerViewAdapter(Context context, ArrayList<ItemCards> itemCardsArrayList, ItemRecyclerViewInterface itemRecyclerViewInterface, int color){
        this.context = context;
        this.itemCardsArrayList = itemCardsArrayList;
        this.itemRecyclerViewInterface = itemRecyclerViewInterface;
        this.color = color;
    }

    @NonNull
    @Override
    public ItemRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_card_view, parent, false);
        return new ItemRecyclerViewAdapter.MyViewHolder(view, itemRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.itemName.setText(itemCardsArrayList.get(position).getItemName());
        holder.itemName.setTextColor(this.color);
        holder.itemIcon.setImageBitmap(itemCardsArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return itemCardsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView itemIcon;
        TextView itemName;

        public MyViewHolder(@NonNull View itemView, ItemRecyclerViewInterface itemRecyclerViewInterface) {
            super(itemView);

            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (itemRecyclerViewInterface != null) {

                        PlayGame.closeSideBar();

                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            ClipData clipData;
                            itemRecyclerViewInterface.onItemSelected(position);
                            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
                            clipData = ClipData.newPlainText(itemName.getText().toString(),null);

                            Utils.itemName = itemName.getText().toString();
                            Utils.itemIcon = Utils.getBitmapFromImageView(itemIcon);

                            view.startDrag(clipData,dragShadowBuilder,view,0);

                            return true;
                        }
                    }
                    return false;
                }
            });
        }
    }
}