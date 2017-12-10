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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

//Because this class is the brain of an activity, AppCompatActivity is extended for this class for the
//activity and sets the activity theme. Also since a button is used within the class
//the on click listener has to be implemented so that it works within the activity.
public class order_confirm extends AppCompatActivity implements View.OnClickListener {

    //All the global variable are defined here so that they do not have to be passed into each method
    //and so that it is easy to manipulate the data inside the variables.
    String TableNumber;
    Button orderConfirmBut;
    String orderID;

    //this method inflates the class which means that it sets up the layout and look of the class
    //by accessing the GUI files.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        //Creates a toolbar object by locating the toolbar gui object and binds them together
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //sets up the toolbar within the activity
        setSupportActionBar(toolbar);
        //Sets up the back button which is a method that has already been created by the framework.
        //All that's needed to be done is to set it to true.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //this chunk of code is responsible for extracting data that was passed in from the
        //previous activity. A bundle object is created and the intent is placed inside it
        Bundle bundle = getIntent().getExtras();
        //since they are of the same format the data put in can easily be extracted using their tags
        //The variables have already been defined above as they are global
        double TotalCost = bundle.getDouble("FinalCost"); //The total cost of the order is stored here
        TableNumber = bundle.getString("table"); //the table number for this order is stored here
        orderID = bundle.getString("orderID"); //the order id for this order is stored here
        Log.d("hiru", "Table number in the order confirm screen obtained is " + TableNumber);
        Log.d("hiru", "Order ID in the order confirm screen obtained is " +orderID);
        //this is used to convert the double number that is the total cost into a curreny to be
        //displayed onto the screen
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);

        //The button object created earlier is binded to its respective GUI object here
        orderConfirmBut = (Button)findViewById(R.id.orderConfirmButton);
        //An on click listener is set so that the button can perform an action if clicked
        orderConfirmBut.setOnClickListener(this);

        //The textview object is created here and is binded to its respective GUI object here
        TextView finalPrice = (TextView)findViewById(R.id.costLabel);
        //the total cost number is converted into currency format and displayed here.
        finalPrice.setText(format.format(TotalCost));
    }

    //since the opening the order create activity requires a the table number and order id of the
    //order, the values are passed back when the back button is clicked
    @Override
    public void supportNavigateUpTo(Intent upIntent) {
        super.supportNavigateUpTo(upIntent);
        //This line of code creates an intent which is a package that passes data to the
        //next activity. It requires context of where it is (so that the next activity would)
        //know where it is coming from and it also requires the class that it is going to.
        Intent intent = new Intent(this, OrderCreate.class);
        //This adds the variables to be sent to the next activity along with tags so that they can be
        //identified when extracting.
        intent.putExtra("table", TableNumber);
        intent.putExtra("order", orderID);
        //The next activity is started with the information from the intent.
        startActivity(intent);
    }


    //This method is called when the button is clicked
    @Override
    public void onClick(View v) {
        //A hash map is the package that stores the data to be sent to the server. It is defined here
        HashMap postData = new HashMap();
        //The orderID is put into the hash map with a tag so it can be identified by the server
        postData.put("orderID", orderID);
        //This line opens a connection using HTTP POST and adds the hash map containing the data
        //to be set into the task to be executed
        PostResponseAsyncTask setToCooking = new PostResponseAsyncTask(order_confirm.this, postData, new AsyncResponse() {
            //this method handles the result of executing the PHP script on the server
            @Override
            public void processFinish(String s) {
                //if the result contains the keyword 'success' then the start activity method is called
                if (s.contains("success")) {
                    startActivity();
                } else { //otherwise an error has occured and is output into the logcat
                    Log.d("Hiru", "error");
                }
            }
        });
        //this line executes the php file that is stored in the URL specified
        long startTime = System.nanoTime();
        setToCooking.execute("http://10.0.2.2/finalConfirm.php");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        Log.d("time", "Time taken to set up order in database took: " + duration + " milliseconds");
    }

    private void startActivity() {
        //This line of code creates an intent which is a package that passes data to the
        //next activity. It requires context of where it is (so that the next activity would)
        //know where it is coming from and it also requires the class that it is going to.
        //Since no data is needed to be transferred, no data has been added into the intent
        Intent intent = new Intent(this, OpenOrders.class);
        //this starts the next activity with the information of the intent.
        startActivity(intent);
    }
}
