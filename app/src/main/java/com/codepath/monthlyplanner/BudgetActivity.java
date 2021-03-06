package com.codepath.monthlyplanner;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.monthlyplanner.Models.BudgetItem;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;


public class BudgetActivity extends AppCompatActivity {
    private Realm myRealm;
    private final int REQUEST_CODE = 42;
    private FloatingActionButton addItemButton;
    public static double total = 0;
    private TextView tvTotal;
    private TextView tvAmount;
    ArrayList<BudgetItem> arrayOfIncome, arrayOfExpenses;
    ArrayList<String> items;
    BudgetAdapter adapterIncome, adapterExpense, realmAdapter;
    ListView lvIncome, lvExpenses;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d("hi", "Worked");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);


        myRealm = Realm.getDefaultInstance();
        final RealmResults<BudgetItem> budgetList = myRealm.where(BudgetItem.class).findAll();
        budgetList.addChangeListener(new RealmChangeListener<RealmResults<BudgetItem>>() {
            @Override
            public void onChange(RealmResults<BudgetItem> elements) {
                for (BudgetItem item: budgetList){


//



                }
            }
        });

//        public void displayAllUsers() {
//
//            RealmResults<BudgetItem> itemList = myRealm.where(BudgetItem.class).findAll();
//
//            StringBuilder builder = new StringBuilder();
//
//            for (BudgetItem item : itemList) {
//                builder.append("ID: ").append(item.getDescription());
//                builder.append("\nName: ").append(item.getAmount());
//                builder.append(", Age: ").append(item.getCategory());
//
//
//            }
//
//
//        }






        addItemButton = findViewById(R.id.addItemButton);
        tvTotal = findViewById(R.id.tvTotal);
        tvAmount = findViewById(R.id.tvAmount);
        arrayOfIncome = new ArrayList<BudgetItem>();
        adapterIncome = new BudgetAdapter(this, arrayOfIncome);
        lvIncome = (ListView) findViewById(R.id.lvIncome);

        lvIncome.setAdapter(adapterIncome);

        arrayOfExpenses = new ArrayList<BudgetItem>();
        adapterExpense = new BudgetAdapter(this, arrayOfExpenses);
        lvExpenses = (ListView) findViewById(R.id.lvExpense);

        lvExpenses.setAdapter(adapterExpense);





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

            final Double amount = data.getExtras().getDouble("amount");
            if(!(data.getExtras().getBoolean("income"))){
                total -= amount;
            }else{
                total += amount;
            }
            final String description = data.getExtras().getString("description");
            final String category = data.getExtras().getString("category");
            int code = data.getExtras().getInt("code", 0);
            // Toast the name to display temporarily on screen
            tvTotal.setText("$ " + Double.toString(total));
            BudgetItem item = new BudgetItem(category, description, amount);
            if(!(data.getExtras().getBoolean("income"))){

                adapterExpense.add(item);

            }else{

                adapterIncome.add(item);


            }
            if(total >= 0){
                tvTotal.setTextColor(this.getResources().getColor(R.color.colorPrimary));
            }else{
                tvTotal.setTextColor(this.getResources().getColor(R.color.red));
            }
            myRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    BudgetItem budgetItem = myRealm.createObject(BudgetItem.class);
                    budgetItem.getCategory(category);
                    budgetItem.getDescription(description);
                    budgetItem.getAmount(amount);

                }
            });
            myRealm.close();

        }


    }



}
