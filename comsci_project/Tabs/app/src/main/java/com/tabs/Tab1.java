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

public class Tab1 extends Fragment{



    public static Tab1 newInstance() {
        Tab1 fragment = new Tab1();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cooking, container, false);
        String[] food = {"Test", "Test1", "test2"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, food);
        ListView list = (ListView)view.findViewById(R.id.listView);
        list.setAdapter(adapter);
        return view;
    }


}
