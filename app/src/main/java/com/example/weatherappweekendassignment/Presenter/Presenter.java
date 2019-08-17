package com.example.weatherappweekendassignment.Presenter;

import com.example.weatherappweekendassignment.Model.ApiInterface;
import com.example.weatherappweekendassignment.Model.List;
import com.example.weatherappweekendassignment.Model.ListResults;
import com.example.weatherappweekendassignment.View.ViewContract;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    private ViewContract view;

    @Override
    public void onBindView(ViewContract view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }

    @Override
    public void initNetworkCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getWeather("30030","metric" ,"b6295034215bfc7aebcd2e661b356203")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListResults>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListResults listResults) {
                        view.onDataPopulated(listResults.RelatedTopics);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onErrorDataCharacter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onSuccessDataCharacter(ArrayList<List> data) {
        view.onDataPopulated(data);
    }

    @Override
    public void onErrorDataCharacter(String errorMessage) {
        view.onErrorDataCharacter(errorMessage);
    }
}
