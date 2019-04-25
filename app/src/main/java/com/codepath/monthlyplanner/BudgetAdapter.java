package com.codepath.monthlyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.codepath.monthlyplanner.Models.BudgetItem;

import java.util.ArrayList;
import java.util.List;

public class BudgetAdapter extends ArrayAdapter<BudgetItem> {
    public BudgetAdapter(Context context, ArrayList<BudgetItem> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BudgetItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_budget, parent, false);
        }
        // Lookup view for data population
        TextView tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
        TextView  tvAmount = (TextView) convertView.findViewById(R.id.tvAmount);
        // Populate the data into the template view using the data object
        tvDescription.setText(item.description);
        tvAmount.setText(Double.toString(item.amount));
        // Return the completed view to render on screen
        return convertView;
    }
}
