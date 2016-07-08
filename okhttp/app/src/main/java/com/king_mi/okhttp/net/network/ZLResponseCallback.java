package com.king_mi.okhttp.net.network;

import okhttp3.Call;
import okhttp3.Callback;

/**
 * 功能:请求的回调
 * 作者: by 刘增龙 on 2016/4/11 09:30.
 * 邮箱:hg_liuzl@qq.com
 */
public interface ZLResponseCallback{     //这里继承Okhttp中的Call方法 ，实现无缝对接


     /**
      * 成功处理
      * **/
     void successResponse(ZLResponse response);

     /**
      * 错误处理，一般的时候不需要处理，当进度条需要 自己来控制的时候可以来处理
      * @param error
      */
     void errorResponse(String errorMsg);

}
