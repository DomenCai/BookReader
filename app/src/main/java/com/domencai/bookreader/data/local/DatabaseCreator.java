package com.domencai.bookreader.data.local;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Domen、on 2018/5/7.
 */
public class DatabaseCreator {
    private static final String DATABASE_NAME = "book_db";
    private AppDatabase mAppDatabase;

    public static DatabaseCreator getInstance(Context context) {
        return new DatabaseCreator(context);
    }

    private DatabaseCreator(Context context) {
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
