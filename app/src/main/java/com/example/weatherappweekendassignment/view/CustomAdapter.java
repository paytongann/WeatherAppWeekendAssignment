package com.example.weatherappweekendassignment.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherappweekendassignment.R;
import com.example.weatherappweekendassignment.model.ListPojo;
import com.example.weatherappweekendassignment.model.WeatherDataList;

import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<String> dataSet;
    private ArrayList<WeatherDataList> listdata;

    CustomAdapter(List<String> dataSet, ArrayList<WeatherDataList> listdata) {
        this.dataSet = dataSet;
        this.listdata = listdata;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.item_layout, null);
        if (itemLayout.getParent() != null) {
            ((ViewGroup) itemLayout.getParent()).removeView(itemLayout);
        }
        return new CustomViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvItemTime.setText(listdata.get(position).getDtTxt());
        holder.tvItemTemp.setText(listdata.get(position).getWeatherMain().getTemp().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

