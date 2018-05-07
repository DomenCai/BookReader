package com.domencai.bookreader.utils;

import android.app.Activity;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

import com.domencai.bookreader.App;


/**
 * Created by Domen、on 2017/11/30.
 */

public class ScreenUtils {
    public static int getSystemBrightness() {
        int brightness = 0;
        try {
            brightness = Settings.System.getInt(App.getAppContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return brightness * 20 / 255;
    }

    public static void setBrightness(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = brightness;
        window.setAttributes(lp);
    }
}
