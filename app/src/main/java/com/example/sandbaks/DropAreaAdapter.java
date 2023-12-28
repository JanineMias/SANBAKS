package com.example.sandbaks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DropAreaAdapter extends RecyclerView.Adapter<DropAreaAdapter.DropAreaViewHolder> {

    private final List<Integer> dataList;
    private final Context context;

    public DropAreaAdapter(Context context, List<Integer> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DropAreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_place_holder, parent, false);
        return new DropAreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DropAreaViewHolder holder, int position) {
        // Bind your data to the ImageView here
        holder.imageView.setImageResource(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class DropAreaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public DropAreaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemPlaceHolder);
        }
    }
}
