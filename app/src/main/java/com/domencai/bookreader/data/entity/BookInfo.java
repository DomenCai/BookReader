package com.domencai.bookreader.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domen、on 2018/5/7.
 */
public class BookInfo {


    @SerializedName("_id")
    public String mId;
    @SerializedName("lastChapter")
    public String mLastChapter;
    @SerializedName("link")
    public String mLink;
    @SerializedName("source")
    public String mSource;
    @SerializedName("name")
    public String mName;
    @SerializedName("isCharge")
    public boolean mIsCharge;
    @SerializedName("chaptersCount")
    public int mChaptersCount;
    @SerializedName("updated")
    public String mUpdated;
    @SerializedName("starting")
    public boolean mStarting;
    @SerializedName("host")
    public String mHost;
}
