package com.codepath.monthlyplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.codepath.monthlyplanner.Models.CalendarItem;

import org.json.JSONArray;

import java.util.ArrayList;

public class DailyScheduleActivity extends AppCompatActivity {
    private EditText etEvent;
    private EditText etDescription;
    private EditText etTime;
    private EditText etLocation;
    private EditText etReminder;
    private Button btnAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_schedule);
        etEvent = findViewById(R.id.etEvent);
        etDescription = findViewById(R.id.etDescription);
        etTime = findViewById(R.id.etTime);
        etLocation = findViewById(R.id.etLocation);
        etReminder = findViewById(R.id.etReminder);
        btnAddEvent = findViewById(R.id.btnAddEvent);

        // Construct the data source
        ArrayList<CalendarItem> arrayOfUsers = new ArrayList<CalendarItem>();
        // Create the adapter to convert the array to views
        CalendarAdapter adapter = new CalendarAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvSchedule);
        listView.setAdapter(adapter);
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DailyScheduleActivity.this, AddEventActivity.class);
                startActivity(i);
            }
        });

//        // Add item to adapter
//           CalendarItem newItem = new CalendarItem(etEvent, etDescription, etTime, etLocation, etReminder);
//           adapter.add(newItem);
//        // Or even append an entire new collection
//        // Fetching some data, data has now returned
//        // If data was JSON, convert to ArrayList of User objects.
//        JSONArray jsonArray = ...;
//        ArrayList<CalendarItem> newUsers = CalendarItem.fromJson(jsonArray)
//        adapter.addAll(newUsers);
      }

}
