package com.tabs;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tab2 extends Fragment{



    public static Tab2 newInstance() {
        Tab2 fragment = new Tab2();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.served, container, false);
        String[] food = {"Test5", "Test6", "test7"};
        ListAdapter adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, food);
        ListView list2 = (ListView)view.findViewById(R.id.listView2);
        list2.setAdapter(adapter2);
        return view;
    }


}
