package com.codepath.monthlyplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.monthlyplanner.Models.CalendarItem;

import org.json.JSONArray;

import java.util.ArrayList;

import static com.codepath.monthlyplanner.R.layout.activity_daily_schedule;

public class DailyScheduleActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 28;
    private Button btnAddEvent;

    ArrayList<CalendarItem> arrayOfEvents;
    // Create the adapter to convert the array to views
    CalendarAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_daily_schedule);
        arrayOfEvents = new ArrayList<CalendarItem>();
        adapter = new CalendarAdapter(this, arrayOfEvents);
        btnAddEvent = findViewById(R.id.btnAddEvent);


        // Construct the data source

        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.lvSchedule);
        listView.setAdapter(adapter);
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DailyScheduleActivity.this, AddEventActivity.class);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
      }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

            // Extract name value from result extras
            String name = data.getExtras().getString("name");
            int code = data.getExtras().getInt("code", 0);
            // Toast the name to display temporarily on screen
            String event = data.getExtras().getString("event");
            String description = data.getExtras().getString("description");
            String time = data.getExtras().getString("time");
            String location = data.getExtras().getString("location");
            String reminder = data.getExtras().getString("reminder");


            CalendarItem item = new CalendarItem(event, description, time, location, reminder );
            adapter.add(item);
        }
    }
}
