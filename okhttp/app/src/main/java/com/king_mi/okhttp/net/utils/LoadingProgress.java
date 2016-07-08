package com.king_mi.okhttp.net.utils;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * 功能: 进度工具类
 * 作者: by 刘增龙 on 2016/5/18 16:16.
 * 邮箱:hg_liuzl@qq.com
 */
public class LoadingProgress {

    private ProgressDialog loadingDialog;

    private Context mContext;

    private static LoadingProgress ourInstance = new LoadingProgress();

    public static LoadingProgress getInstance() {
        return ourInstance;
    }

    private LoadingProgress() {
    }

    public void show(Context Context) {
        this.mContext = Context;
        show(mContext, "正在加载...");
    }

    /**
     * 得到自定义的progressDialog
     * @param msg
     * @return
     */
    public void show(Context mContext, String msg) {
        if (null != mContext) {
            loadingDialog = new ProgressDialog(mContext, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            loadingDialog.setMessage(msg);
            loadingDialog.show();
        }
    }

    public void dismiss() {
        loadingDialog.dismiss();
    }
}
