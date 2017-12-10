package com.timetracker;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ListView;
import android.widget.TextView;

public class TimeTrackerActivity extends Activity{
    private TimeListAdapter mTimeListAdapter = null;

    @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //initialise the timer
            TextView counter = (TextView) findViewById(R.id.counter);
            counter.setText(DateUtils.formatElapsedTime(0));
        if (mTimeListAdapter == null)
                mTimeListAdapter = new TimeListAdapter(this, 0);
            ListView list = (ListView) findViewById(R.id.time_list);
            list.setAdapter(mTimeListAdapter);

    }
    //records current system time and sends a message to the handler, starting the timer
    private void startTimer() {
        mStart = System.currentTimeMillis();
        mHandler.removeMessages(0);
        mHandler.sendEmptyMessages(0);
    }

    //removes any messages from the handler message queue
    private void stopTimer() {
        mHandler.removeMessages(0);
    }

    private void restTimer() {
        stopTimer();
        if (mTimeListAdapter != null)
            mTimeListAdapter.add(mTime/1000);
        mTime = 0;
    }

    private boolean isTimerRunning() {
        return mHandler.hasMessages(0);
    }
}
