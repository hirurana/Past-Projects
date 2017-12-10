package com.restaurantapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.restaurantapp.ServedTab;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

//Because this class is the brain of an activity, AppCompatActivity is extended for this class for the
//activity and sets the activity theme
public class OpenOrders extends AppCompatActivity{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    //this method inflates the class which means that it sets up the layout and look of the class
    //by accessing the GUI files.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_orders);

        //Creates a toolbar object by locating the toolbar gui object and binds them together
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //sets up the toolbar within the activity
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //enables the adapter to use the sections pager adapter that was previously set up
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //This sets up the tabs so that the user can switch through the different tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //This binds the host of the section contents with the tab bar.
        tabLayout.setupWithViewPager(mViewPager);

        //This sets up a floating action bar that goes ontop of the activity instead of inside it
        //this means that the listview would not conflict the button as they are ontop of each other
        //rather and next to each other.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //The app did not previously run because it thought that there was a high chance that
        //the floating action bar would be empty. This meant that it was necessary to make sure that
        //the action bar was not empty (not null) with the following line of code.
        assert fab != null;
        //Since this is a special type of button, it requires a listener that waits for the user
        //to press the fab before doing something
        fab.setOnClickListener(new View.OnClickListener() {
            //this method is implemented so that the fab behaves like a normal button when in reality
            //it works differently
            @Override
            public void onClick(View view) {
                //This line of code creates an intent which is a package that passes data to the
                //next activity. It requires context of where it is (so that the next activity would)
                //know where it is coming from and it also requires the class that it is going to.
                //Since no data is needed to be transferred, no data has been added into the intent
                Intent intent = new Intent(OpenOrders.this, TableInput.class);
                //this starts the next activity with the information of the intent.
                startActivity(intent);
            }
        });

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        //this sets the sections pager adapter as a superclass which means that it is a class which
        //gives methods to a subclasses which are used below. In other words, it defines a class
        //within a class.
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //this method is responsible for opening the correct fragment in the correct tab it does
        //this by taking the position of the selected tab and returning a fragment using a switch
        //which is many if statements.
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                //if its the first tab then return the ordering tab
                case 0:
                    return OrderingTab.newInstance();
                //if its the second tab then return the cooking tab
                case 1:
                    return CookingTab.newInstance();
                //if its the third tab then return the ready tab
                case 2:
                    return ReadyTab.newInstance();
                //if its the fourth tab then return the served tab
                case 3:
                    return ServedTab.newInstance();
            }
            //this ensures that the method returns nothing. This is here because the method is not
            //void which means that it has to return something.
            return null;

        }

        //this method defines how many tabs there will be
        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        //This sets the title of each tab according the position of the tab using a switch.
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    //this names the first tab
                    return "ORDER";
                case 1:
                    //this names the second tab
                    return "COOKING";
                case 2:
                    //this names the third tab
                    return "READY";
                case 3:
                    //this names the fourth tab
                    return "SERVED";
            }
            //this ensures that the method returns nothing. This is here because the method is not
            //void which means that it has to return something.
            return null;
        }
    }



}
