package com.domencai.bookreader;

import android.app.Application;
import android.content.Context;

/**
 * Created by Domen、on 2017/11/27.
 */

public class App extends Application {
    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
