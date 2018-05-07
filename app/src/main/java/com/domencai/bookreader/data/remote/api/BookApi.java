package com.domencai.bookreader.data.remote.api;

import com.domencai.bookreader.data.entity.BookInfo;
import com.domencai.bookreader.data.entity.SourceDetail;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Domen、on 2018/5/7.
 */
public interface BookApi {

    /**
     * 获取所有章节的信息
     */
    @GET("/mix-atoc/{bookId}")
    Observable<SourceDetail> getChaptersByBookId(@Path("bookId") String bookId);

    /**
     * 获取小说正版源与盗版源
     */
    @GET("/atoc?view=summary")
    Observable<List<BookInfo>> getAllSourceInfo(@Query("book") String bookId);

    /**
     * 通过源id获取所有章节的信息
     */
    @GET("/atoc/{sourceId}?view=chapters")
    Observable<SourceDetail> getChaptersBySourceId(@Path("sourceId") String sourceId);
}
