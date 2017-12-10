package com.restaurantapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hiru on 28/03/2016.
 */
public class orders {

    //decodes the table number received from the database and stores it into a string
    @SerializedName("tableID")
    public String table_number;
}
