package com.king_mi.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.king_mi.okhttp.net.network.ZLRequest;
import com.king_mi.okhttp.net.network.ZLRequestParams;
import com.king_mi.okhttp.net.network.ZLResponse;
import com.king_mi.okhttp.net.network.ZLResponseCallback;


public class MainActivity extends Activity implements View.OnClickListener, ZLResponseCallback {

    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tv_content);

        findViewById(R.id.btn_volley).setOnClickListener(this);
        findViewById(R.id.btn_okhttp).setOnClickListener(this);
        findViewById(R.id.btn_nohttp).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        ZLRequestParams params = new ZLRequestParams();
        params.mContext = this;
        params.requestUrl = "http://www.baidu.com";
        params.callback = this;

        switch (v.getId()) {
            case R.id.btn_volley:
                params.libType = ZLRequestParams.NetWorkLibType.volley;
                break;
            case R.id.btn_okhttp:
                params.libType = ZLRequestParams.NetWorkLibType.okhttp;
                break;
            case R.id.btn_nohttp:
                params.libType = ZLRequestParams.NetWorkLibType.nohttp;
                break;
        }
        ZLRequest.getInstance().sendRequest(params);
    }

    @Override
    public void successResponse(ZLResponse response) {
        tvContent.setText(response.getResposeStr());
    }

    @Override
    public void errorResponse(String errorMsg) {

    }
}
