package com.codepath.monthlyplanner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private Button goTo;
    private Button calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up Realm Database
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("Monthly-Planner")
                .build();
        Realm.setDefaultConfiguration(configuration);

        goTo = findViewById(R.id.goTo);
        calendar = findViewById(R.id.goToCalendar);

        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BudgetActivity.class);
                startActivity(i); // brings up the second activity
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(i); // brings up the second activity
            }
        });

    }
}
