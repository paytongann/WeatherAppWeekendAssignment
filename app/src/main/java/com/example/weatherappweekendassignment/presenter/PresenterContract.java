package com.example.weatherappweekendassignment.presenter;

import com.example.weatherappweekendassignment.model.ListPojo;

import java.util.ArrayList;

public interface PresenterContract {
    void initRetrofit(String zipCode, String unit);
    void onDataPopulated(ArrayList<ListPojo> data);
}
