package com.restaurantapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;

//this class is a fragment that uses database connections, this is why it extends the fragment
//activity and implements the AsyncResponse library. (So that they can be used within the class)
public class ServedTab extends Fragment implements AsyncResponse {

    //global variables that are only used with in this class are defined here.
    //they are private so that classes outside of this class cannot access this data for
    //security reasons
    private ArrayList<orders> orderList;
    private ListView CookingList;

    //Defines the fragment by making and instance of it which means that it is basically converting
    //the java class into a usable fragment which is called by the fragment controller.
    public static ServedTab newInstance() {
        //this line creates the fragment
        ServedTab fragment = new ServedTab();
        return fragment;
    }

    //this method inflates the class which means that it sets up the layout and look of the class
    //by accessing the GUI files.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_served_tab, container, false);
        //This line opens a connection using HTTP POST
        PostResponseAsyncTask task = new PostResponseAsyncTask(getContext(), this);
        //this line executes the php file that is stored in the URL specified
        task.execute("http://10.0.2.2/ServedOrders.php");
        //this returns the view for standard practising purposes
        return rootView;
    }

    //this method handles the result of executing the PHP script on the server
    @Override
    public void processFinish(String s) {
        //the order list that was previously defined as a global array, stores the result after it
        //has been parsed from a JSON array  (the format it was received) to an array list
        //which is a format that we can manipulate. It makes use of a separate class called the
        //Orders class. That is how data is parse from the JSON array and stored into their respective
        //variables.
        orderList = new JsonConverter<orders>().toArrayList(s, orders.class);
        //This creates a dictionary object where the parse objects will be stored in so that they
        //can be added into the list view with help of the orders.class
        BindDictionary<orders> dict = new BindDictionary<orders>();
        //this block of code adds the parsed table number into the dictionary so that the data can
        //later be presented to the user
        dict.addStringField(R.id.OrderTableNumber, new StringExtractor<orders>() {
            @Override
            public String getStringValue(orders item, int position) {
                //this returns the table number in the correct position of the listview
                return "Table " + item.table_number;
            }


        });

        //this line creates a specialised adapter with help of an external library called the
        //fundapter to allow the stored data to be adapted and put into the listview in a
        //presentable way. It takes the list that was created earlier, the listview item in the GUI
        //file and the dictionary of the way in which data would liked to be seen.
        FunDapter<orders> adapter = new FunDapter<>(getContext(), orderList, R.layout.layout_list, dict);

        //These lines of code create a listview object in the scope of this class by finding the object
        //in the GUI files by using the findViewById method, where the listview item had been given the
        //id 'cookingList'. The line after then binds the adapter along with all the data to the listview object
        //so that the data is visible when running the app.
        CookingList = (ListView)getActivity().findViewById(R.id.servedList);
        CookingList.setAdapter(adapter);
    }
}
