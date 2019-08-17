package com.example.weatherappweekendassignment.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.weatherappweekendassignment.Model.List;
import com.example.weatherappweekendassignment.Presenter.Presenter;
import com.example.weatherappweekendassignment.R;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity implements ViewContract {

    ImageView ivSettings;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ivSettings = findViewById(R.id.iv_settings);
        ivSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        initUI();
        onBindPresenter();
    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBindView(this);
        presenter.initNetworkCall();
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        adapter = new CustomAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDataPopulated(ArrayList<List> data) {
        adapter.setDataset(data);
    }

    @Override
    public void onErrorDataCharacter(String errorMessage) {
        onErrorDataCharacter(errorMessage);
    }
}