package com.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et = (EditText)findViewById(R.id.editText);
        lv = (ListView)findViewById(R.id.listView);
        al = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                al);
        lv.setAdapter(aa);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null){
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String item = et.getText().toString();
                    al.add(0, item);
                    aa.notifyDataSetChanged();
                    //step iii: clr edit text
                    et.setText("");
                }
            });
        }
    }

}
