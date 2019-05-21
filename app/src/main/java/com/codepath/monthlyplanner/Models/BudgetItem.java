package com.codepath.monthlyplanner.Models;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;

public class BudgetItem extends RealmObject {
    private String category;
    public String description;
    public Double amount;

    public BudgetItem(){
    }

    public BudgetItem(String category, String description, Double amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
    }


    public String getCategory(String category){
        return this.category;
    }


    public String getDescription(String description){
        return this.description;
    }

    public Double getAmount(Double amount){
        return this.amount;
    }

    public static ArrayList<BudgetItem> getItems() {
        ArrayList<BudgetItem> items = new ArrayList<BudgetItem>();

        return items;
    }
}
