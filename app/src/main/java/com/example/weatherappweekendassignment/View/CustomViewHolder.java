package com.example.weatherappweekendassignment.View;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherappweekendassignment.R;

public class CustomViewHolder extends RecyclerView.ViewHolder  {

    ImageView ivWeatherIcon;
    TextView tvTime, tvTemp;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ivWeatherIcon = itemView.findViewById(R.id.item_icon);
        tvTime = itemView.findViewById(R.id.item_time);
        tvTemp = itemView.findViewById(R.id.item_temperature);
    }
}
