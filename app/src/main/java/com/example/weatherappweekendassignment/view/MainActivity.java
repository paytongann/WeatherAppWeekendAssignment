package com.example.weatherappweekendassignment.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.weatherappweekendassignment.R;
import com.example.weatherappweekendassignment.presenter.Presenter;
import com.example.weatherappweekendassignment.presenter.PresenterContract;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private PresenterContract presenter;
    private TextView tvLocale;
    private TextView tvTemperature;
    private TextView tvStatus;
    private ImageView ivSettiing;
    private ConstraintLayout clCurrentWeather;
    private String unit;
    private TextView tvItemTime1, tvItemTime2, tvItemTime3, tvItemTime4;
    private ImageView ivItemIcon1, ivItemIcon2, ivItemIcon3, ivItemIcon4;
    private TextView tvItemTemp1, tvItemTemp2, tvItemTemp3, tvItemTemp4;

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
        tvItemTime1 = findViewById(R.id.tvItemTime1);
        tvItemTime2 = findViewById(R.id.tvItemTime2);
        tvItemTime3 = findViewById(R.id.tvItemTime3);
        tvItemTime4 = findViewById(R.id.tvItemTime4);
        ivItemIcon1 = findViewById(R.id.ivItemIcon1);
        ivItemIcon2 = findViewById(R.id.ivItemIcon2);
        ivItemIcon3 = findViewById(R.id.ivItemIcon3);
        ivItemIcon4 = findViewById(R.id.ivItemIcon4);
        tvItemTemp1 = findViewById(R.id.tvItemTemp1);
        tvItemTemp2 = findViewById(R.id.tvItemTemp2);
        tvItemTemp3 = findViewById(R.id.tvItemTemp3);
        tvItemTemp4 = findViewById(R.id.tvItemTemp4);
        tvLocale = findViewById(R.id.tv_locale);
        tvTemperature = findViewById(R.id.tv_current_temp);
        tvStatus = findViewById(R.id.tv_weather_cond);
        ivSettiing = findViewById(R.id.iv_settings);
        clCurrentWeather = findViewById(R.id.cl_current_weather);
        ivSettiing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

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
        if (backgroundWarm)
            clCurrentWeather.setBackgroundColor(getResources().getColor(R.color.colorWarm));
        else clCurrentWeather.setBackgroundColor(getResources().getColor(R.color.colorCold));
    }

    public void editTime(String time1, String time2, String time3, String time4) {
        tvItemTime1.setText(time1);
        tvItemTime2.setText(time2);
        tvItemTime3.setText(time3);
        tvItemTime4.setText(time4);
    }

    public void editIcon(String icon1, String icon2, String icon3, String icon4) {
        setIcon1(icon1);
        setIcon2(icon2);
        setIcon3(icon3);
        setIcon4(icon4);
    }

    public void setIcon1(String icon) {
        if (icon.equals("10n")) {
            ivItemIcon1.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("10d")) {
            ivItemIcon1.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("03d")) {
            ivItemIcon1.setImageResource(R.drawable.three_day);
        } else if (icon.equals("01d")) {
            ivItemIcon1.setImageResource(R.drawable.one_day);
        } else if (icon.equals("02d")){
            ivItemIcon1.setImageResource(R.drawable.two_day);
        } else if (icon.equals("04")){
            ivItemIcon1.setImageResource(R.drawable.four_day);
        }
    }

    public void setIcon2(String icon) {
        if (icon.equals("10n")) {
            ivItemIcon2.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("10d")) {
            ivItemIcon2.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("03d")) {
            ivItemIcon2.setImageResource(R.drawable.three_day);
        } else if (icon.equals("01d")) {
            ivItemIcon2.setImageResource(R.drawable.one_day);
        } else if (icon.equals("02d")){
            ivItemIcon2.setImageResource(R.drawable.two_day);
        } else if (icon.equals("04")){
            ivItemIcon2.setImageResource(R.drawable.four_day);
        }
    }

    public void setIcon3(String icon) {
        if (icon.equals("10n")) {
            ivItemIcon3.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("10d")) {
            ivItemIcon3.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("03d")) {
            ivItemIcon3.setImageResource(R.drawable.three_day);
        } else if (icon.equals("01d")) {
            ivItemIcon3.setImageResource(R.drawable.one_day);
        } else if (icon.equals("02d")){
            ivItemIcon3.setImageResource(R.drawable.two_day);
        } else if (icon.equals("04")){
            ivItemIcon3.setImageResource(R.drawable.four_day);
        }
    }

    public void setIcon4(String icon) {
        if (icon.equals("10n")) {
            ivItemIcon4.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("10d")) {
            ivItemIcon4.setImageResource(R.drawable.ten_night);
        } else if (icon.equals("03d")) {
            ivItemIcon4.setImageResource(R.drawable.three_day);
        } else if (icon.equals("01d")) {
            ivItemIcon4.setImageResource(R.drawable.one_day);
        } else if (icon.equals("02d")){
            ivItemIcon4.setImageResource(R.drawable.two_day);
        } else if (icon.equals("04")){
            ivItemIcon4.setImageResource(R.drawable.four_day);
        }
    }

    public void editTemp(String temp1, String temp2, String temp3, String temp4) {
        tvItemTemp1.setText(temp1);
        tvItemTemp2.setText(temp2);
        tvItemTemp3.setText(temp3);
        tvItemTemp4.setText(temp4);
    }

}
