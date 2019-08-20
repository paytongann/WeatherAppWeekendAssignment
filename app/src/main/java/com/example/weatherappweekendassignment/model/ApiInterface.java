package com.example.weatherappweekendassignment.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("data/2.5/forecast")
    Observable<ListPojo> getWeatherData(
            @Query("zip") String zip,
            @Query("units") String unit,
            @Query("appid") String apiKey);

    //https://us-zipcode.api.smartystreets.com/lookup?auth-id=dc661aab-8408-a6ff-4fa4-fb19898ec4c5&auth-token=jYhGFhrSzMvudzS0g1o3&zipcode=33331
    @GET("lookup")
    Call<List<ParentCityStatePojo>> getZipcode(
            @Query("auth-id") String id,
            @Query("auth-token") String token,
            @Query("zipcode") String zip
    );
}

