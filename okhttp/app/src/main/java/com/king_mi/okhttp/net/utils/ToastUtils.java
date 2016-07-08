package com.king_mi.okhttp.net.utils;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
* toast 工具类
* author liuzl
* created at 2016/7/7 14:59
**/
public class ToastUtils {

	public static void show(Context context,String text){
		 Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
	
	public static void show(Context context,int text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	
	public static void show(Context context,String text,int gravity){
		Toast tr = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		tr.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		tr.show();
	}
}
