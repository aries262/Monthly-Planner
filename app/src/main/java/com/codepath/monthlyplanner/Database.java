package com.codepath.monthlyplanner;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Database extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Set up Realm Database
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("Monthly-Planner")
                .build();
        Realm.setDefaultConfiguration(configuration);
    }


}
