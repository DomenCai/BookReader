package com.domencai.bookreader.data.remote;

import com.domencai.bookreader.BuildConfig;
import com.domencai.bookreader.data.entity.BookInfo;
import com.domencai.bookreader.data.entity.SourceDetail;
import com.domencai.bookreader.data.remote.api.BookApi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Domen、on 2018/5/7.
 */
public class HttpManager {
    private static final String API_BASE_URL = "http://api.zhuishushenqi.com";
    public static final String IMG_URL = "http://statics.zhuishushenqi.com";
    private BookApi mBookApi;

    /**
     * 基本请求参数集合
     */
    private HttpManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG
                                  ? HttpLoggingInterceptor.Level.BODY
                                  : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mBookApi = retrofit.create(BookApi.class);
    }

    public static HttpManager getInstance() {
        return new HttpManager();
    }

    Observable<List<BookInfo>> getAllSourceInfo(String bookId) {
        return mBookApi.getAllSourceInfo(bookId);
    }

    Observable<SourceDetail> getChaptersBySourceId(String sourceId) {
        return mBookApi.getChaptersBySourceId(sourceId);
    }
}
