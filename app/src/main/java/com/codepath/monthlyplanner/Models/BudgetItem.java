package com.codepath.monthlyplanner.Models;

import java.util.ArrayList;

public class BudgetItem {
    public String category;
    public String description;
    public Double amount;

    public BudgetItem(String category, String description, Double amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
    }


    public String getCategory(){
        return category;
    }


    public String getDescription(){
        return description;
    }

    public Double getAmount(){
        return amount;
    }

    public static ArrayList<BudgetItem> getItems() {
        ArrayList<BudgetItem> items = new ArrayList<BudgetItem>();

        return items;
    }
}
