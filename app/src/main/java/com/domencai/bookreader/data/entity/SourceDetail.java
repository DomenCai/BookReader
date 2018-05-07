package com.domencai.bookreader.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Domen、on 2018/5/7.
 */
public class SourceDetail {

    @SerializedName("_id")
    public String mId;
    @SerializedName("link")
    public String mLink;
    @SerializedName("source")
    public String mSource;
    @SerializedName("name")
    public String mName;
    @SerializedName("book")
    public String mBook;
    @SerializedName("chaptersCount1")
    public int mChaptersCount1;
    @SerializedName("lastChapter1")
    public String mLastChapter1;
    @SerializedName("updated")
    public String mUpdated;
    @SerializedName("host")
    public String mHost;
    @SerializedName("chapters")
    public List<ChaptersBean> mChapters;

    public static class ChaptersBean {

        @SerializedName("title")
        public String mTitle;
        @SerializedName("link")
        public String mLink;
    }
}
