package com.codepath.monthlyplanner;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class BudgetActivity extends AppCompatActivity {
    private FloatingActionButton addItemButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("hi", "Worked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        addItemButton = findViewById(R.id.addItemButton);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BudgetActivity.this, BudgetAddItem.class);
                startActivity(i); // brings up the second activity
            }
        });

    }
}
