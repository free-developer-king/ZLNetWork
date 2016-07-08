package com.king_mi.okhttp;

import android.app.Application;

import com.king_mi.okhttp.net.net_volley.ZLVolleyRequest;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by liuzenglong on 2016/7/8.
 */
public class ZLApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ZLVolleyRequest.init(getApplicationContext());
        NoHttp.initialize(this);
    }
}
