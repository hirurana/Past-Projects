package com.restaurantapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class order_confirm extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        double TotalCost = bundle.getDouble("FinalCost");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);


        TextView finalPrice = (TextView)findViewById(R.id.costLabel);
        finalPrice.setText(format.format(TotalCost));
    }

}
