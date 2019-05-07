package com.codepath.monthlyplanner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.codepath.monthlyplanner.Models.BudgetItem;
import com.codepath.monthlyplanner.Models.CalendarItem;

import java.util.ArrayList;
import java.util.Calendar;


public class CalendarAdapter extends ArrayAdapter<CalendarItem> {
        public CalendarAdapter(Context context, ArrayList<CalendarItem> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d("works", "adapter");
            // Get the data item for this position
            CalendarItem item = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_event, parent, false);
            }
            // Lookup view for data population
            TextView tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            TextView  tvTime= (TextView) convertView.findViewById(R.id.tvTime);
            // Populate the data into the template view using the data object
            tvDescription.setText(item.description);
            tvTime.setText(item.time);
            // Return the completed view to render on screen
            return convertView;
        }
    }


