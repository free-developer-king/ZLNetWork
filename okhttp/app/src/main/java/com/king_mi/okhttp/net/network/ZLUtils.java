package com.king_mi.okhttp.net.network;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络框架需要用到的工具类
 */
public class ZLUtils {


    /**
     * 功能：判断当前网络是否可用
     * 作者:刘增龙
     * create at :2016/4/11 15:44
     **/
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context
                    .CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //获取APP友盟渠道UMENG_CHANNEL
    public static String getMetaValue(Context context) {
        Bundle metaData = null;
        String apiKey = null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai) {
                metaData = ai.metaData;
            }
            if (null != metaData) {
                //api_key 字符串要跟manifest配置文件里定义key对应
                apiKey = metaData.getString("UMENG_CHANNEL");
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return apiKey;
    }

    /**
     * 功能：通用请求参数
     * 作者:刘增龙
     * create at :2016/4/11 10:07
     **/
    public static Map<String, String> commonParams(Context context) {
        Map<String, String> body = new HashMap<>();
        body.put("appDeviceInfo", getImei(context));//	device_info	设备信息		Y	Android：imei或Ios: udid
        body.put("appSystem", "Android");  //	os	终端系统		Y	Android或Ios
        body.put("appChannel", getMetaValue(context)); //	app_channel	APP所属渠道		Y  // Ios渠道一般是appstore，Android渠道:360，baidu,tencent,xiaomi
        body.put("appVersion", getVersionName(context)); //	appVersion	APP版本号		Y	app版本号
        // body.put("appToken", BGApp.getInstance().getAppToken());//app需要的令牌
        return body;
    }

    /**
     * 获取设备的imei号
     * author liuzl
     * created at 2016/7/7 14:46
     **/
    public static String getImei(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 获取版本名称
     * author liuzl
     * created at 2016/7/7 14:46
     **/
    public static String getVersionName(Context app) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 数组转换成map
     *
     * @param keys   键
     * @param values 值
     * @return 注意键与值的长度要相等
     */
    public static Map<String, String> arrayToMap(String[] keys, String[] values) {
        Map<String, String> maps = new HashMap<>();
        if (keys.length == 0 || values.length == 0) {
            return maps;
        }
        for (int i = 0; i < keys.length; i++) {
            maps.put(keys[i], values[i]);
        }
        return maps;
    }
}
