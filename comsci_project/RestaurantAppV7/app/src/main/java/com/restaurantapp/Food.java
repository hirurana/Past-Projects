package com.restaurantapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hiru on 25/03/2016.
 */
public class Food {

    //decodes the food name received from the database and stores it into a string
    @SerializedName("food_name")
    public String food_name;

    //decodes the food price received from the database and stores it into a floating point number
    @SerializedName("food_price")
    public float food_price;

}
