package com.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText hirusinput;
    TextView hirusText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hirusinput = (EditText)findViewById(R.id.hirusinput);
        hirusText = (TextView)findViewById(R.id.hirusText);

        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        hirusText.setText(dbString);
        hirusinput.setText("");
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        String product = hirusinput.getText().toString();
        Products p = new Products(product);
        dbHandler.addProduct(p);
        printDatabase();
    }

    //Delete a product to the database
    public void deleteButtonClicked(View view){
        String inputText = hirusinput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
}
