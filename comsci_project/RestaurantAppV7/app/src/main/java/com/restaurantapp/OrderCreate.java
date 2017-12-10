package com.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

//Because this class is the brain of an activity, AppCompatActivity is extended for this class
// for the
//activity and sets the activity theme
public class OrderCreate extends AppCompatActivity{

    //This section defines the objects that will be used in this activity
    //This defines the number picker object that will be used for selecting the
    //quantity to be ordered
    NumberPicker numPicker;
    //This text box object will be used to allow the user to input the dish number
    //of the food to be ordered
    EditText inputFoodName;
    //This variable will be used to store the current total cost and will be updated
    //each time another item is added to the list
    double totalCost;
    //this variable will hold the quantity of the dish that is being added to the list
    String quantity;

    //The following variables are used to hold data that has been brought from the
    //previous activity as an intent

    //This variable will hold the order number that was generated when the table was
    //assigned to the order
    String orderNum;
    //This variable holds the table number of which the food is being ordered to.
    String TableNumber;

    //These private objects can only be accessed within the java class and are needed
    //for the listView.

    //This array list will store the food that is to be ordered
    private ArrayList<String> foodList;
    //this array adapter is needed so that the arraylist can be presented in the listView
    private ArrayAdapter<String> aa;
    //This defines the listView object that will be used to display the items to be ordered
    private ListView orderCreateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //This sets up the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //This section of code is used to extract the intent made in the previous activity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //These variables that were previously defined are assigned to the order number
        //and the table number that was passed from the previous activity.
        orderNum = bundle.getString("order");
        TableNumber = bundle.getString("Table");
        //This section is for testing purposes to see whether the correct order number
        //and table number are passed through
        Log.d("Hiru", "Order number obtained in order create screen is" + orderNum);
        Log.d("Hiru", "Table Number obtained in order create screen is" + TableNumber);

        //set up number picker
        numPicker = (NumberPicker)findViewById(R.id.quantityPicker);
        //set maximum value on the number picker
        numPicker.setMaxValue(20);
        //set minimum value on the number picker
        numPicker.setMinValue(1);
        //set false to remove additional borders around the scroller
        numPicker.setWrapSelectorWheel(false);

        //creates a new array list object from the foodList variable defined above
        foodList = new ArrayList<String>();
        //Binds the order list  and input box to the objects in the XML layout file using
        // the IDs given to the order list object and the input box
        orderCreateList = (ListView)findViewById(R.id.orderCreateList);
        inputFoodName = (EditText)findViewById(R.id.inputFoodName);
        //creates an array adapter so that the array can be viewed in the list view
        //this array adapter will be for a string array with a simple list and the array
        //used will be foodList
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodList);
        //this binds the data from the array adapter to the actual list view
        orderCreateList.setAdapter(aa);

        //this sets up the floating action button which will be used to add a dish to the
        //list
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //since the FAB was prone to be null this if statement was added to remove the
        //warnings
        if (fab != null) {
            //A listener is used to wait for the user to interact with the object before
            //initiating an event
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //when the FAB is tapped the value input into the input text box is
                    //extracted, converted into string and stored in a string variable
                    String foodRefNum = inputFoodName.getText().toString();
                    //the same is done to the current position of the number picker
                    quantity = String.valueOf(numPicker.getValue());
                    //the addFoodIntoList method is then run with the parameter of the
                    //number entered by the user
                    addFoodIntoList(foodRefNum);
                }
            });
        }
    }

    //This method is called when the advanced button is clicked by the user. It seems
    //like it has no purpose in this java file because it is not called by any other java
    //method. It is instead called by the XML file that is binded to this java file
    public void openOrderConfirm(View view) {
        //An intent object is created so that information can be passed on to the next
        //activity, which is the order confirm screen
        Intent intent = new Intent(this, order_confirm.class);
        //A bundle is created to store the actual information. This bundle is placed into
        //the intent which is then transfered to the next activity
        Bundle bundle = new Bundle();
        //the final cost, table number and order ID are all added to the bundle with their
        //respective tags for easy identification when extracting these variables
        bundle.putDouble("FinalCost",totalCost);
        Log.d("Hiru", "Final cost being sent from order create is" + totalCost);
        bundle.putString("table", TableNumber);
        Log.d("Hiru", "Table Number being sent from order create is" + TableNumber);
        bundle.putString("orderID", orderNum);
        Log.d("Hiru", "orderID being sent from order create is" + orderNum);
        //this is where the bundle is put into the intent
        intent.putExtras(bundle);
        //The command is given to start the next activity with the intent that has just
        //been set up
        startActivity(intent);
    }

    //this method takes the food number entered and displays the correct dish name in the
    //list view. It also repeats the dish based on the quantity ordered
    public void addFoodIntoList(String foodNumber){
        //a hash map is created so that a connection can be made to the database
        HashMap postData = new HashMap();
        //the food number extracted from the textbox, the quantity from the number picker
        //and the generated order number are all put into the hashmap
        postData.put("foodRefNum", foodNumber);
        postData.put("quantity", quantity);
        postData.put("orderID", orderNum);

        //this line sets up the task to perform a HTTP Post with the values in the hashmap.
        //The values are put into a php script and run; the results are handled here
        PostResponseAsyncTask extractFoodName = new PostResponseAsyncTask(OrderCreate.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                //for testing purposes, the result (raw JSON form) is printed in the logcat
                Log.d("Hiru", s);
                //since this operation is prone to failure, a try catch statement has been included
                //to ensure that the program does not crash if for example there is no network
                //connection
                try {
                    //convert the result (which is in string format) into a JSON array
                    JSONArray arr = convertToJSON(s);
                    //get the first thing in the array and create a JSON object out of it
                    JSONObject jsonObject = arr.getJSONObject(0);
                    //get the food name
                    String name = jsonObject.getString("food_name");
                    //and the cost from the json object
                    double cost = jsonObject.getDouble("food_price");


                    //repeating item for non single quantity code
                    //takes the quantity obtained by the position of the number picker.
                    for (int i = 0; i < Integer.parseInt(quantity); i++) {
                        //add the price to the cost
                        totalCost += cost;
                        //add the food name into the list
                        foodList.add(0, name);
                        //updates the list so that the changes can be seen
                        aa.notifyDataSetChanged();
                        //reset the input box
                        inputFoodName.setText("");
                        //reset the number picker
                        numPicker.setValue(1);;
                    }
                    //record the final cost in the log files for testing
                    Log.d("Hiru", String.valueOf(totalCost));
                    //if an error occurs be sure to print the error for debugging
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        //method used to time the SQL query speed
        //start the timer
        long startTime = System.nanoTime();
        //run the sql query by accessing a php file on the server
        extractFoodName.execute("http://10.0.2.2/getFoodName.php");
        //end the timer
        long endTime = System.nanoTime();
        //find the speed by finding the difference of the two timers; divide by 1000000 to show the
        //time in milliseconds
        long duration = (endTime - startTime)/1000000;
        Log.d("time", "Requesting dish number conversion took: " + duration + " milliseconds");
    }

    //convert result of SQL query into a JSON array
    public JSONArray convertToJSON(String s) throws JSONException {
        //JSON array constructor using the result string from the SQL query
        JSONArray jsonArray = new JSONArray(s);
        //return the array to wherever it was called
        return jsonArray;
    }
}