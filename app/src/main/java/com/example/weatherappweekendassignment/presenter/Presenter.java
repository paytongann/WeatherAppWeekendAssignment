package com.example.weatherappweekendassignment.presenter;

import android.content.Context;
import android.util.Log;

import com.example.weatherappweekendassignment.model.ApiInterface;
import com.example.weatherappweekendassignment.model.ResultPojo;
import com.example.weatherappweekendassignment.model.WeatherDataList;
import com.example.weatherappweekendassignment.model.ListPojo;
import com.example.weatherappweekendassignment.view.MainActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Presenter implements PresenterContract{


    private Context context;
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private PresenterContract view;

    public Presenter(Context context) {
        this.context = context;
    }

    @Override
    public void initRetrofit(String zipCode, String unit) {
        final String  appId = "b6295034215bfc7aebcd2e661b356203";
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/")
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        Observable<ListPojo> observable = apiInterface.getWeatherData(zipCode, unit, appId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListPojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListPojo weatherData) {
                        List<WeatherDataList> dataSet = weatherData.getList();
                        String city = weatherData.getCity().getName();
                        String temperature = dataSet.get(0).getWeatherMain().getTemp().toString() + "°";
                        String status = dataSet.get(0).getWeather().get(0).getMain();
                        ((MainActivity) context).editCurrentWeather(city, temperature, status);

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void onDataPopulated(ArrayList<ListPojo> data) {

    }
}
