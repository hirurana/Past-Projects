package com.restaurantapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hiru on 25/03/2016.
 */
public class Food {

    @SerializedName("food_name")
    public String food_name;

    @SerializedName("food_price")
    public float food_price;
}
