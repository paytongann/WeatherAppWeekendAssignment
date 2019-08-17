package com.example.weatherappweekendassignment.Presenter;

import com.example.weatherappweekendassignment.Model.List;
import com.example.weatherappweekendassignment.View.ViewContract;

import java.util.ArrayList;

public interface PresenterContract {

    void onBindView(ViewContract view);
    void unBindView();
    void initNetworkCall();
    void onSuccessDataCharacter(ArrayList<List> data);
    void onErrorDataCharacter(String errorMessage);

}
