package com.example.dima.req;

import android.app.Application;


import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.sql.Configuration;
import io.requery.sql.EntityDataStore;
import io.requery.sql.TableCreationMode;


public class ExApp extends Application {
    private EntityDataStore<Persistable> dataStore;

//
//    EntityDataStore<Persistable> getData() {
//        if (dataStore == null) {
//            // override onUpgrade to handle migrating to a new version
//
//            DatabaseSource source = new DatabaseSource(this, Models.DEFAULT, 1);
//            if (BuildConfig.DEBUG) {
//                // use this in development mode to drop and recreate the tables on every upgrade
//                source.setTableCreationMode(TableCreationMode.DROP_CREATE);
//            }
//            Configuration configuration = source.getConfiguration();
//            dataStore = new EntityDataStore<Persistable>(configuration);
//        }
//        return dataStore;
//    }

}
