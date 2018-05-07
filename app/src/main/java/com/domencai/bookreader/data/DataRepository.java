package com.domencai.bookreader.data;

import com.domencai.bookreader.App;
import com.domencai.bookreader.data.local.AppDatabase;
import com.domencai.bookreader.data.local.DatabaseCreator;
import com.domencai.bookreader.data.remote.HttpManager;

/**
 * Created by Domen、on 2018/5/7.
 */
public class DataRepository {

    private AppDatabase mAppDatabase;
    private HttpManager mHttpManager;

    public static DataRepository getInstance() {
        return SingleHolder.sInstance;
    }

    private DataRepository() {
        mAppDatabase = DatabaseCreator.getInstance(App.getAppContext()).getAppDatabase();
        mHttpManager = HttpManager.getInstance();
    }

    private static class SingleHolder {
        private static final DataRepository sInstance = new DataRepository();
    }
}
