package com.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

//Because this class is the brain of an activity, AppCompatActivity is extended for this class for the 
//activity and sets the activity theme. Also since a button is used within the class
//the on click listener has to be implemented so that it works within the activity.
public class TableInput extends AppCompatActivity implements View.OnClickListener {

    //All the global variable are defined here so that they do not have to be passed into each method
    //and so that it is easy to manipulate the data inside the variables.
    EditText inputTableNum; //Creates an edit text object to handle inputs
    Button advanceButton; //creates a button object to handle button clicks
    TextView tableServedError; //A text view object is created so that the class can change the text
                                //inside the text view
    String tableNum; //A global string is defined to store the table number. It is global because
                    //it is defined in more than one class.

    //this method inflates the class which means that it sets up the layout and look of the class
    //by accessing the GUI files.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_input);

        //Creates a toolbar object by locating the toolbar gui object and binds them together
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //sets up the toolbar within the activity
        setSupportActionBar(toolbar);
        //Sets up the back button which is a method that has already been created by the framework.
        //All that's needed to be done is to set it to true.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //This section of code binds the java objects with their respective GUI objects
        inputTableNum = (EditText)findViewById(R.id.inputTableNum);
        tableServedError = (TextView)findViewById(R.id.tableUsedMessage);
        advanceButton = (Button)findViewById(R.id.openCreateOrderButton);
        //this line of code sets an on click listener to the button outside of the method by using
        //'this' as a parameter, which is referencing to the class
        advanceButton.setOnClickListener(this);
    }

    //This method is called when the button is clicked
    @Override
    public void onClick(View v) {
        //A hash map is the package that stores the data to be sent to the server. It is defined here
        HashMap postData = new HashMap();

        //This extracts the table number from the edit text box as a string and stores it in the global
        //string variable that was defined above
        tableNum = inputTableNum.getText().toString();
        //The input is first checked to see if the user left it empty
        if (tableNum.isEmpty()){
            //if so then the previously hidden text view (see GUI file) is made visible and the mesg
            //is set to asking the user to enter the table number
            tableServedError.setText("Enter Table Number");
            tableServedError.setVisibility(View.VISIBLE);
        } else { //else if the table number has been extracted then...
            //first put the table number into our hash map with a tag so it can be identified by the
            //server
            postData.put("TableNum", tableNum);

            //This line opens a connection using HTTP POST and adds the hash map containing the data
            //to be set into the task to be executed
            PostResponseAsyncTask task1 = new PostResponseAsyncTask(TableInput.this, postData, new AsyncResponse() {
                //this method handles the result of executing the PHP script on the server
                @Override
                public void processFinish(String s) {
                    //for testing purposes, the result of the PHP execution can be seen in the log cat but
                    //not in the app
                    Log.d("Hiru", s);
                    //if the messaged received by the server contains the keyword free then allow the
                    //table to be used
                    if (s.contains("free")) {
                        //Since it is free and it will be used. The table needs to be blocked from
                        //other users booking it too. To do this another connection is made in the same way
                        //as before except this time a different hash map is used.
                        HashMap setUpOrder = new HashMap();
                        setUpOrder.put("TableNum", tableNum);
                        PostResponseAsyncTask setUp = new PostResponseAsyncTask(TableInput.this, setUpOrder, new AsyncResponse() {
                            @Override
                            public void processFinish(String s) {
                                Log.d("Hiru", s);
                                //the order number generated (see PHP script) will be stored in this variable. It is necessary to
                                //define it first.
                                String orderNum;
                                //The framework knows that this process can fail and be fatal so therefore a try/catch statement
                                //must be put around the parsing process
                                try {
                                    //a JSON array is created using the method created below
                                    JSONArray arr = convertToJSON(s);
                                    //A JSON object is also created but is empty
                                    JSONObject jsonObject;
                                    //Since the data received is in a JSON array but only one item is received in this case,
                                    //the array has to be parsed first by getting the first and only JSON object before working
                                    //on it
                                    jsonObject = arr.getJSONObject(0);
                                    //The orderID generated by the server is parsed from the JSON object and stored into the
                                    //variable defined above
                                    orderNum = jsonObject.getString("orderID");
                                    startActivity(orderNum); //the startActivity method is called with the order number passed in
                                } catch (JSONException e) {//if an exception is thrown then it can be viewed in the console
                                    e.printStackTrace();
                                }
                            }
                        });
                        //this line executes the php file that is stored in the URL specified
                        setUp.execute("http://10.0.2.2/insertOrder.php");
                    } else if (s.contains("used")) {//if the message received contains the keyword used, then user must be told so.
                        //the previously hidden text view (see GUI file) is made visible and the message
                        //is set to asking the user to enter a table number that is not being used
                        tableServedError.setText("Table Is Already Being Used");
                        tableServedError.setVisibility(View.VISIBLE);
                        //this clears the textbox so that the user can retry
                        inputTableNum.setText("");
                    } else if (s.contains("nonexistant")) {//if the table is non-existant in the server then this block is run.
                        //the previously hidden text view (see GUI file) is made visible and the message
                        //is set to asking the user to enter a table number that actually exists
                        tableServedError.setText("Table Does Not Exist");
                        tableServedError.setVisibility(View.VISIBLE);
                        //this clears the textbox so that the user can retry
                        inputTableNum.setText("");
                    }
                }
            });
            //this line executes the php file that is stored in the URL specified
            long startTime = System.nanoTime();
            task1.execute("http://10.0.2.2/checkTable.php");
            long endTime = System.nanoTime();
            long duration = (endTime - startTime)/1000000;
            Log.d("time", "Requesting table availability check took: " + duration + " milliseconds");
        }
    }

    public void startActivity(String orderNum){
        //This line of code creates an intent which is a package that passes data to the
        //next activity. It requires context of where it is (so that the next activity would)
        //know where it is coming from and it also requires the class that it is going to.
        Intent intent = new Intent(TableInput.this, OrderCreate.class);

        //Since more than one piece of data is being added, it is efficient to use a bundle, which
        //is a package that stores multiple variables that are needed to be passed in an intent
        Bundle bundle = new Bundle();
        //The order number and table number are added to the bundle so that they can be extracted
        //in the order create activity later.
        bundle.putString("order",orderNum);
        Log.d("hiru", "Order number to be passed from table input screen is " + orderNum);
        bundle.putString("Table", tableNum);
        Log.d("hiru", "Table number to be passed from table input screen is " + tableNum);
        //The bundle is put into the intent
        intent.putExtras(bundle);
        //The next activity is started with the information from the intent.
        startActivity(intent);
    }

    //This method converts the string received in JSON array format to an actual JSON array, so that
    //the data can be parsed. An exception is needed to be thrown for standard practises
    public JSONArray convertToJSON(String s) throws JSONException {
        //the JSON array object is created using the string result received from the server
        JSONArray jsonArray = new JSONArray(s);
        //The JSON array is returned to where the method was called.
        return jsonArray;
    }
}