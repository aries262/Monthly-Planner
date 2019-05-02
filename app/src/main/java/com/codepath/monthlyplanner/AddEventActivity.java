package com.codepath.monthlyplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEventActivity extends AppCompatActivity {
    private EditText etEvent;
    private EditText etDescription;
    private EditText etTime;
    private EditText etLocation;
    private EditText etReminder;
    private Button btnAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        etEvent = findViewById(R.id.etEvent);
        etDescription = findViewById(R.id.etDescriptionEvent);
        etTime = findViewById(R.id.etTime);
        etLocation = findViewById(R.id.etLocation);
        etReminder = findViewById(R.id.etReminder);
        btnAddEvent = findViewById(R.id.btnAdd);
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("event", etEvent.getText().toString());
                data.putExtra("description", etDescription.getText().toString());
                data.putExtra("Time", etTime.getText().toString());
                data.putExtra("location", etLocation.getText().toString());
                data.putExtra("Reminder", etReminder.getText().toString());
                //Activity finsihed ok, return the data.
                setResult(RESULT_OK, data); //Set result code and bundle data for response.
                finish(); //closes the activity, pass data to parent.
            }
        });
    }



    private final int REQUEST_CODE = 20;
    // FirstActivity, launching an activity for a result
    public void onClick(View view) {
        Intent i = new Intent(AddEventActivity.this, DailyScheduleActivity.class);
        i.putExtra("mode", 2); // pass arbitrary data to launched activity
        startActivityForResult(i, REQUEST_CODE);
    }


}
