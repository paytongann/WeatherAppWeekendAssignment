package com.example.weatherappweekendassignment.Model;

import java.util.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://api.openweathermap.org/data/2.5/forecast?zip=30030&units=metric&appid=b6295034215bfc7aebcd2e661b356203
    @GET("forecast?")
    Observable<ListResults> getWeather(
            @Query("zip") String zip,
            @Query("units") String units,
            @Query("appid") String appid);
}
