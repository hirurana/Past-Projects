package com.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enable the app icon as the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the message from the intent
        Intent intent = getIntent();
        // store into variable message
        String message = intent.getStringExtra(ExampleActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        //put in the message into the text view
        textView.setText(message);

        // Set the text view as the activity layout
        setContentView(textView);
    }

}
