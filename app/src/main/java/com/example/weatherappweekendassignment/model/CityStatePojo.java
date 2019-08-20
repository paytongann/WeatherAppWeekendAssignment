package com.example.weatherappweekendassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityStatePojo {

    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("state_abbreviation")
    @Expose
    public String stateAbbreviation;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("mailable_city")
    @Expose
    public Boolean mailableCity;

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}
