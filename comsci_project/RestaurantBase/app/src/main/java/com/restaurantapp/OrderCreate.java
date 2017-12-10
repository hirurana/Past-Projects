package com.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class OrderCreate extends AppCompatActivity implements AsyncResponse {

    NumberPicker numPicker;
    EditText inputFoodName;
    //final int numPickerValue = numPicker.getValue();

    private ArrayList<Food> foodList;
    private ListView orderCreateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set up number picker
        numPicker = (NumberPicker)findViewById(R.id.quanityPicker);
        numPicker.setMaxValue(20);
        numPicker.setMinValue(1);
        numPicker.setWrapSelectorWheel(false);


        inputFoodName = (EditText)findViewById(R.id.inputFoodName);
        PostResponseAsyncTask taskConvertToFoodName = new PostResponseAsyncTask(OrderCreate.this,this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String foodRefNum = inputFoodName.getText().toString();
                    Toast.makeText(OrderCreate.this, foodRefNum, Toast.LENGTH_LONG).show();
                }
            });
        }
        taskConvertToFoodName.execute("http://10.0.2.2/getFoodName.php");
    }

    public void openOrderConfirm(View view) {
        Intent intent = new Intent(this, order_confirm.class);
        startActivity(intent);
    }

    @Override
    public void processFinish(String s) {
        foodList = new JsonConverter<Food>().toArrayList(s, Food.class);

        BindDictionary<Food> dict = new BindDictionary<Food>();
        dict.addStringField(R.id.CustomListFoodName, new StringExtractor<Food>() {
            @Override
            public String getStringValue(Food food, int position) {
                return food.food_name;
            }
        });
        dict.addStringField(R.id.CustomListFoodPrice, new StringExtractor<Food>() {
            @Override
            public String getStringValue(Food food, int position) {
                NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(Locale.UK);
                return "" + defaultFormat.format(food.food_price);
            }
        });

        FunDapter<Food> adapter = new FunDapter<>(OrderCreate.this, foodList, R.layout.layout_list, dict);

        orderCreateList = (ListView)findViewById(R.id.orderCreateList);
        orderCreateList.setAdapter(adapter);
    }
}

