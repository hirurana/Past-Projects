package com.listviewtest;

import android.content.Context;
import android.media.session.PlaybackState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] foods) {
        super (context, R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater hirusInflater = LayoutInflater.from(getContext());
        View customView = hirusInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView hiruText = (TextView) customView.findViewById(R.id.hirusText);

        hiruText.setText(singleFoodItem);
        return customView;
    }


}
