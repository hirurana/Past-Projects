package com.restaurantapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class order_confirm extends AppCompatActivity {

    String TableNumber;
    private ArrayList<String> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        double TotalCost = bundle.getDouble("FinalCost");
        TableNumber = bundle.getString("Table");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);


        TextView finalPrice = (TextView)findViewById(R.id.costLabel);
        finalPrice.setText(format.format(TotalCost));
    }

    @Override
    public void supportNavigateUpTo(Intent upIntent) {
        super.supportNavigateUpTo(upIntent);
        Intent intent = new Intent(this, OrderCreate.class);
        intent.putExtra("Table", TableNumber);
        startActivity(intent);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Hiru", String.valueOf(outState));
    }
}
