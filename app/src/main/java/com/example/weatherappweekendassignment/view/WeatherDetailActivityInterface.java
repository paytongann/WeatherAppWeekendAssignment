package com.example.weatherappweekendassignment.view;

import android.widget.LinearLayout;

import com.example.weatherappweekendassignment.model.WeatherDataList;

import java.util.ArrayList;
import java.util.List;

interface WeatherDetailActivityInterface {
    void editCurrentWeather(String city, String temperature, String condition);
    void setUpRecyclerView(List<String> dateList,  ArrayList<WeatherDataList> listdata);
}
