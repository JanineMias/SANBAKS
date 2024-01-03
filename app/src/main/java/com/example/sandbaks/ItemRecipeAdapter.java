package com.example.sandbaks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemRecipeAdapter extends RecyclerView.Adapter<ItemRecipeAdapter.ItemRecipeViewHolder> {

    Context context;
    ArrayList<ItemRecipeCards> itemRecipes;

    public ItemRecipeAdapter(Context context, ArrayList<ItemRecipeCards> itemRecipes){
        this.context = context;
        this.itemRecipes = itemRecipes;
    }


    @NonNull
    @Override
    public ItemRecipeAdapter.ItemRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_recipe_card_view, parent, false);
        return new ItemRecipeAdapter.ItemRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecipeAdapter.ItemRecipeViewHolder holder, int position) {
        holder.combinationResult.setText(itemRecipes.get(position).getCombinationResult());
        holder.combinationItems.setText(itemRecipes.get(position).getCombinationItems());
    }

    @Override
    public int getItemCount() {
        return itemRecipes.size();
    }

    public static class ItemRecipeViewHolder extends RecyclerView.ViewHolder{

        TextView combinationResult, combinationItems;

        public ItemRecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            combinationItems = itemView.findViewById(R.id.combinationItems);
            combinationResult = itemView.findViewById(R.id.combinationResult);
        }
    }
}
