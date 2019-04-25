package com.codepath.monthlyplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BudgetAddItem extends AppCompatActivity {
    private Button btnAdd;
    private RadioButton rbIncome;
    private RadioButton rbExpense;
    private EditText category;
    private EditText amount;
    private EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_add_item);
        btnAdd = findViewById(R.id.btnAdd);
        rbExpense = findViewById(R.id.radioExpenses);
        rbIncome = findViewById(R.id.radioIncome);
        category = findViewById(R.id.etCategory);
        amount = findViewById(R.id.etAmount);
        description = findViewById(R.id.etDescription);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            Boolean income = false;
            @Override
            public void onClick(View v) {

                // Prepare data intent
                Intent data = new Intent();
                // Pass relevant data back as a result
                if (rbIncome.isChecked()){
                    income = true;
                }
                data.putExtra("income", income);
                data.putExtra("category", category.getText().toString());
                data.putExtra("amount", Double.parseDouble(amount.getText().toString()));
                data.putExtra("description", description.getText().toString());
                data.putExtra("code", 200); // ints work too
                // Activity finished ok, return the data
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes the activity, pass data to parent
            }
        });


    }
}
