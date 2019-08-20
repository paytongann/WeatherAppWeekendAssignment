package com.example.weatherappweekendassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentCityStatePojo {

        @SerializedName("input_index")
        @Expose
        public Integer inputIndex;
        @SerializedName("city_states")
        @Expose
        public List<CityStatePojo> cityStates = null;

}
