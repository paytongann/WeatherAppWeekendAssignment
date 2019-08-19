package com.example.weatherappweekendassignment.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherappweekendassignment.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView tvItemTime, tvItemTemp;
    ImageView ivItemIcon;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivItemIcon = itemView.findViewById(R.id.item_icon);
        tvItemTemp = itemView.findViewById(R.id.item_temperature);
        tvItemTime = itemView.findViewById(R.id.item_time);
    }
}
