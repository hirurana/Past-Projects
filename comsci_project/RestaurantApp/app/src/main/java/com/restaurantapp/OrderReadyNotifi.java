package com.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class OrderReadyNotifi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ready_notifi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView OrderReadyLabel = (TextView)findViewById(R.id.ReadyLabel);
        OrderReadyLabel.setText("Order number " + "#7896" + " is ready to be collected for table:");

        TextView tableNumReady = (TextView)findViewById(R.id.readyTableNum);
        tableNumReady.setText("07");
    }

    public void openMainScreen(View view) {
        Intent intent = new Intent(this, CurrentOrders.class);
        startActivity(intent);
    }

}
