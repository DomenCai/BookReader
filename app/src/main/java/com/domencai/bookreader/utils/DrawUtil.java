package com.domencai.bookreader.utils;

import android.util.DisplayMetrics;

import com.domencai.bookreader.App;

/**
 * Created by Domen、on 2017/9/15.
 */

public class DrawUtil {

    private static float sDensity = 1.0f;
    private static float sScaledDensity = 1.0f;

    @SuppressWarnings("WeakerAccess")
    public static int sWidthPixels;
    @SuppressWarnings("WeakerAccess")
    public static int sHeightPixels;

    static {
        DisplayMetrics outMetrics =  App.getAppContext().getResources().getDisplayMetrics();
        sWidthPixels = outMetrics.widthPixels;
        sHeightPixels = outMetrics.heightPixels;
        sDensity = outMetrics.density;
        sScaledDensity = outMetrics.scaledDensity;
    }

    /**
     * dip/dp转像素
     * @param dipValue dip或 dp大小
     * @return 像素值
     */
    @SuppressWarnings("unused")
    public static int dip2px(float dipValue) {
        return (int) (dipValue * sDensity + 0.5f);
    }

    /**
     * 像素转dip/dp
     * @param pxValue 像素大小
     * @return dip值
     */
    @SuppressWarnings("unused")
    public static int px2dip(float pxValue) {
        return (int) (pxValue / sDensity + 0.5f);
    }

    /**
     * sp 转 px
     * @param spValue sp大小
     * @return 像素值
     */
    @SuppressWarnings("unused")
    public static int sp2px(float spValue) {
        return (int) (spValue * sScaledDensity + 0.5f);
    }

    /**
     * px转sp
     * @param pxValue 像素大小
     * @return sp值
     */
    @SuppressWarnings("unused")
    public static int px2sp(float pxValue) {
        return (int) (pxValue / sScaledDensity + 0.5f);
    }
}
