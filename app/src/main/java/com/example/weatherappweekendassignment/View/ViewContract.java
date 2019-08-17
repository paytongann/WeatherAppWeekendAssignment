package com.example.weatherappweekendassignment.View;

import com.example.weatherappweekendassignment.Model.List;

import java.util.ArrayList;

public interface ViewContract {

    void onBindPresenter();
    void initUI();
    void onDataPopulated(ArrayList<List> data);
    void onErrorDataCharacter(String errorMessage);
}
