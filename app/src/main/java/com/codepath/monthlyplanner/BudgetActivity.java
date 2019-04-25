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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class BudgetActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 42;
    private FloatingActionButton addItemButton;
    double total = 0;
    private TextView tvTotal;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("hi", "Worked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        addItemButton = findViewById(R.id.addItemButton);
        tvTotal = findViewById(R.id.tvTotal);

        addItemButton.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BudgetActivity.this, BudgetAddItem.class);
                i.putExtra("mode", 2);
                startActivityForResult(i, REQUEST_CODE);// brings up the second activity

            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
            total += data.getExtras().getDouble("amount");
            int code = data.getExtras().getInt("code", 0);
            // Toast the name to display temporarily on screen
            tvTotal.setText("$ " + Double.toString(total));


        }
    }
}
