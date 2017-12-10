package com.restaurantapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
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
import com.google.gson.JsonParser;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderCreate extends AppCompatActivity{

    NumberPicker numPicker;
    EditText inputFoodName;
    double totalCost;
    int quantity;
    int orderID;

    private ArrayList<String> foodList;
    private ArrayAdapter<String> aa;
    private ListView orderCreateList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String test = bundle.getString("order");
        orderID = Integer.parseInt(test);
        Log.d("Hiru", "orderIDfrom2 is " + orderID);
        //set up number picker
        numPicker = (NumberPicker)findViewById(R.id.quanityPicker);
        numPicker.setMaxValue(20);
        numPicker.setMinValue(1);
        numPicker.setWrapSelectorWheel(false);

        foodList = new ArrayList<String>();
        orderCreateList = (ListView)findViewById(R.id.orderCreateList);
        inputFoodName = (EditText)findViewById(R.id.inputFoodName);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodList);
        orderCreateList.setAdapter(aa);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String foodRefNum = inputFoodName.getText().toString();
                    int foodNum = Integer.parseInt(foodRefNum);
                    Log.d("Hiru", "foodrefnum is " + foodNum);
                    quantity = numPicker.getValue();
                    addFoodIntoList(foodNum);
                }
            });
        }
    }

    public void openOrderConfirm(View view) {
        Intent intent = new Intent(this, order_confirm.class);
        startActivity(intent);
    }

    public void addFoodIntoList(int foodNumber){

        HashMap postData = new HashMap();
        postData.put("foodRefNum", foodNumber);
        postData.put("orderID", orderID);
        postData.put("quantity", quantity);
        PostResponseAsyncTask extractFoodName = new PostResponseAsyncTask(OrderCreate.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                try {
                    Log.d("Hiru", s);
                    JSONArray arr = convertToJSON(s);
                    JSONObject jsonObject = arr.getJSONObject(0);
                    String name = jsonObject.getString("food_name");
                    double cost = jsonObject.getDouble("food_price");
                    totalCost += cost;
                    Toast.makeText(OrderCreate.this, Double.toString(totalCost), Toast.LENGTH_LONG).show();

                    for (int i = 0; i < quantity; i++) {
                        foodList.add(0, name);
                        aa.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        extractFoodName.execute("http://10.0.2.2/getFoodName.php");

    }

    public JSONArray convertToJSON(String s) throws JSONException {
        JSONArray jsonArray = new JSONArray(s);
        return jsonArray;
    }
}

