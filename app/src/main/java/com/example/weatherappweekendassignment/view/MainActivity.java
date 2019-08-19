package com.example.weatherappweekendassignment.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherappweekendassignment.R;
import com.example.weatherappweekendassignment.model.WeatherDataList;
import com.example.weatherappweekendassignment.presenter.Presenter;
import com.example.weatherappweekendassignment.presenter.PresenterContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherDetailActivityInterface{

    private PresenterContract presenter;
    private TextView tvLocale;
    private TextView tvTemperature;
    private TextView tvStatus;
    private ImageView ivSettiing;
    private RecyclerView recyclerView;
    private ConstraintLayout clCurrentWeather;
    String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        Intent intent = getIntent();
        setUpViews();
        presenter = new Presenter(this);
        unit = intent.getStringExtra(UserSelectionUtil.UNIT);
        presenter.initRetrofit(intent.getStringExtra(UserSelectionUtil.ZIP),
                intent.getStringExtra(UserSelectionUtil.UNIT));
    }


    private void setUpViews() {
        tvLocale = findViewById(R.id.tv_locale);
        tvTemperature = findViewById(R.id.tv_current_temp);
        tvStatus = findViewById(R.id.tv_weather_cond);
        ivSettiing = findViewById(R.id.iv_settings);
        recyclerView = findViewById(R.id.recycler_view);
        clCurrentWeather = findViewById(R.id.cl_current_weather);
        ivSettiing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void editCurrentWeather(String city, String temperature, String condition) {
        double temperatureDouble = Double.parseDouble(temperature.substring(0, temperature.length() - 1));
        tvLocale.setText(city);
        tvTemperature.setText(temperature);
        tvStatus.setText(condition);
        Boolean backgroundWarm = false;
        if (unit.equals("imperial")) {
            if (temperatureDouble > 80) {
                backgroundWarm = true;
            }
        } else if (unit.equals("metric")) {
            if (temperatureDouble > 27) {
                backgroundWarm = true;
            }
        }

        if (backgroundWarm) clCurrentWeather.setBackgroundColor(getResources().getColor(R.color.colorWarm));
        else clCurrentWeather.setBackgroundColor(getResources().getColor(R.color.colorCold));

    }

    @Override
    public void setUpRecyclerView(List<String> dateList,  ArrayList<WeatherDataList> listdata) {
        CustomAdapter customAdapter = new CustomAdapter(dateList, listdata);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
