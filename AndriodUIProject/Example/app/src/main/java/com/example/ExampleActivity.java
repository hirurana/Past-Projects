package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ExampleActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.MESSAGE"; /* declare the final message to be passed on to next activity */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view){
        //Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class); /* create an intention */
        EditText editText = (EditText) findViewById(R.id.edit_message); /* connect to string.xml */
        String message = editText.getText().toString(); /* create variable to store message input */
        intent.putExtra(EXTRA_MESSAGE, message); /* put the message into a final variable */
        startActivity(intent); /* begin the next activity */
    }
}
