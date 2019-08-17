package com.example.weatherappweekendassignment.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherappweekendassignment.Model.List;
import com.example.weatherappweekendassignment.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<List> dataSet;
    private Context context;

    public CustomAdapter(Context context){
        this.context = context;
    }

    public void setDataset(ArrayList<List> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvTemp.setText(Double.toString(dataSet.get(position).main.temp));
        holder.tvTime.setText(dataSet.get(position).dt);
        Glide.with(context).load(dataSet.get(position).weather.icon).into(holder.ivWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
