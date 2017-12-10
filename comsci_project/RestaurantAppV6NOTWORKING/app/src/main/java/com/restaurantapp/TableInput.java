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

public class TableInput extends AppCompatActivity implements View.OnClickListener {

    EditText inputTableNum;
    Button advanceButton;
    TextView tableServedError;
    String tableNum;
    String orderID;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputTableNum = (EditText)findViewById(R.id.inputTableNum);
        tableServedError = (TextView)findViewById(R.id.tableUsedMessage);
        advanceButton = (Button)findViewById(R.id.openCreateOrderButton);
        advanceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();

        tableNum = inputTableNum.getText().toString();
        if (tableNum.isEmpty()){
            tableServedError.setText("Enter Table Number");
            tableServedError.setVisibility(View.VISIBLE);
        } else {
            postData.put("TableNum", tableNum);

            PostResponseAsyncTask task1 = new PostResponseAsyncTask(TableInput.this, postData, new AsyncResponse() {
                @Override
                public void processFinish(String s) {
                    if (s.contains("free")) {
                        HashMap setUpOrder = new HashMap();
                        setUpOrder.put("TableNum", tableNum);
                        PostResponseAsyncTask setUp = new PostResponseAsyncTask(TableInput.this, setUpOrder, new AsyncResponse() {
                            @Override
                            public void processFinish(String s) {
                                String orderNum = null;
                                try {
                                    JSONArray arr = convertToJSON(s);
                                    JSONObject jsonObject = null;
                                    jsonObject = arr.getJSONObject(0);
                                    orderNum = jsonObject.getString("orderID");
                                    startActivity(orderNum);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        setUp.execute("http://10.0.2.2/insertOrder.php");
                    } else if (s.contains("used")) {
                        tableServedError.setText("Table Is Already Being Used");
                        tableServedError.setVisibility(View.VISIBLE);
                        inputTableNum.setText("");
                    } else if (s.contains("nonexistant")) {
                        tableServedError.setText("Table Does Not Exist");
                        tableServedError.setVisibility(View.VISIBLE);
                        inputTableNum.setText("");
                    }
                }
            });
            task1.execute("http://10.0.2.2/checkTable.php");
        }
    }

    public void startActivity(String orderNum){
        Intent intent = new Intent(TableInput.this, OrderCreate.class);

        Bundle bundle = new Bundle();
        bundle.putString("order",orderNum);
        bundle.putString("Table", tableNum);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public JSONArray convertToJSON(String s) throws JSONException {
        JSONArray jsonArray = new JSONArray(s);
        return jsonArray;
    }
}