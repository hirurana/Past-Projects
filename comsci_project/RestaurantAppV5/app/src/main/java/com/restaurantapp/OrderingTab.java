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

/**
 * Created by hiru on 01/04/2016.
 */
public class OrderingTab extends Fragment implements AsyncResponse {

    private ArrayList<orders> orderList;
    private ListView CookingList;

    public static OrderingTab newInstance() {
        OrderingTab fragment = new OrderingTab();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ordering_tab, container, false);
        PostResponseAsyncTask task = new PostResponseAsyncTask(getContext(), this);
        task.execute("http://10.0.2.2/OrderingOrders.php");
        return rootView;
    }


    @Override
    public void processFinish(String s) {
        orderList = new JsonConverter<orders>().toArrayList(s, orders.class);

        BindDictionary<orders> dict = new BindDictionary<orders>();
        dict.addStringField(R.id.OrderTableNumber, new StringExtractor<orders>() {
            @Override
            public String getStringValue(orders item, int position) {
                return "Table " + item.table_number;
            }


        });

        FunDapter<orders> adapter = new FunDapter<>(getContext(), orderList, R.layout.layout_list, dict);

        CookingList = (ListView)getActivity().findViewById(R.id.orderingList);
        CookingList.setAdapter(adapter);
    }
}
