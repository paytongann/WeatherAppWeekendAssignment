package com.example.weatherappweekendassignment.presenter;

import android.content.Context;
import android.util.Log;

import com.example.weatherappweekendassignment.model.ApiInterface;
import com.example.weatherappweekendassignment.model.CityStatePojo;
import com.example.weatherappweekendassignment.model.ParentCityStatePojo;
import com.example.weatherappweekendassignment.model.WeatherDataList;
import com.example.weatherappweekendassignment.model.ListPojo;
import com.example.weatherappweekendassignment.view.MainActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Presenter implements PresenterContract{

    private Context context;
    private Retrofit retrofit;
    private ApiInterface apiInterface;
    private String state = "";
    public Presenter(Context context) {
        this.context = context;
    }

    @Override
    public void initRetrofit(String zipCode, String unit) {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://us-zipcode.api.smartystreets.com/")
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getZipcode("dc661aab-8408-a6ff-4fa4-fb19898ec4c5", "jYhGFhrSzMvudzS0g1o3", zipCode).enqueue(new Callback<List<ParentCityStatePojo>>() {
            @Override
            public void onResponse(Call<List<ParentCityStatePojo>> call, Response<List<ParentCityStatePojo>> response) {
                if (response.isSuccessful()){
                    state = response.body().get(0).cityStates.get(0).stateAbbreviation;
                }
            }

            @Override
            public void onFailure(Call<List<ParentCityStatePojo>> call, Throwable t) {
                Log.d(TAG, "fail" + t.getMessage());
            }
        });

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
                        int tempInt= (int)Math.round(dataSet.get(0).getWeatherMain().getTemp());
                        String temperature = tempInt + "°";
                        String status = dataSet.get(0).getWeather().get(0).getMain();
                        ((MainActivity) context).editCurrentWeather(city+", " + state, temperature, status);
                        String itemTime1 =dataSet.get(0).getDtTxt().split(" ")[1];
                        itemTime1 = timeConverter(itemTime1);
                        String itemTime2 =dataSet.get(1).getDtTxt().split(" ")[1];
                        itemTime2 = timeConverter(itemTime2);
                        String itemTime3 =dataSet.get(2).getDtTxt().split(" ")[1];
                        itemTime3 = timeConverter(itemTime3);
                        String itemTime4 =dataSet.get(3).getDtTxt().split(" ")[1];
                        itemTime4 = timeConverter(itemTime4);
                        ((MainActivity) context).editTime(itemTime1, itemTime2, itemTime3, itemTime4);
                        String icon1 = dataSet.get(0).getWeather().get(0).getIcon();
                        String icon2 = dataSet.get(1).getWeather().get(0).getIcon();
                        String icon3 = dataSet.get(2).getWeather().get(0).getIcon();
                        String icon4 = dataSet.get(3).getWeather().get(0).getIcon();
                        ((MainActivity) context).editIcon(icon1, icon2, icon3, icon4);
                        int tempItem1= (int)Math.round(dataSet.get(0).getWeatherMain().getTemp());
                        String temp1 = tempItem1 + "°";
                        int tempItem2= (int)Math.round(dataSet.get(1).getWeatherMain().getTemp());
                        String temp2 = tempItem2 + "°";
                        int tempItem3= (int)Math.round(dataSet.get(2).getWeatherMain().getTemp());
                        String temp3 = tempItem3 + "°";
                        int tempItem4= (int)Math.round(dataSet.get(3).getWeatherMain().getTemp());
                        String temp4 = tempItem4 + "°";
                        ((MainActivity) context).editTemp(temp1, temp2, temp3, temp4);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public String timeConverter(String time){
        if (time.equals("01:00:00")){
            time = "1:00 AM";
        } else if (time.equals("02:00:00")){
            time = "2:00 AM";
        } else if (time.equals("03:00:00")){
            time = "3:00 AM";
        } else if (time.equals("04:00:00")){
            time = "4:00 AM";
        } else if (time.equals("05:00:00")){
            time = "5:00 AM";
        } else if (time.equals("06:00:00")){
            time = "6:00 AM";
        } else if (time.equals("07:00:00")){
            time = "7:00 AM";
        } else if (time.equals("08:00:00")){
            time = "8:00 AM";
        } else if (time.equals("09:00:00")){
            time = "9:00 AM";
        } else if (time.equals("10:00:00")){
            time = "10:00 AM";
        } else if (time.equals("11:00:00")){
            time = "11:00 AM";
        } else if (time.equals("12:00:00")){
            time = "12:00 PM";
        } else if (time.equals("13:00:00")){
            time = "1:00 PM";
        } else if (time.equals("14:00:00")){
            time = "2:00 PM";
        } else if (time.equals("15:00:00")) {
            time = "3:00 PM";
        } else if (time.equals("16:00:00")) {
            time = "4:00 PM";
        } else if (time.equals("17:00:00")) {
            time = "5:00 PM";
        } else if (time.equals("18:00:00")) {
            time = "6:00 PM";
        } else if (time.equals("19:00:00")) {
            time = "7:00 PM";
        } else if (time.equals("20:00:00")) {
            time = "8:00 PM";
        } else if (time.equals("21:00:00")) {
            time = "9:00 PM";
        } else if (time.equals("22:00:00")) {
            time = "10:00 PM";
        } else if (time.equals("23:00:00")) {
            time = "11:00 PM";
        } else {
            time = "12:00 AM";
        }
        return time;
    }
}
