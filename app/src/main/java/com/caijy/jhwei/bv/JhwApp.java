package com.caijy.jhwei.bv;

import android.app.Application;
import android.content.Context;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class JhwApp extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();

        mContext=getApplicationContext();
    }
}
