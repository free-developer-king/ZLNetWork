# ZLNetWork
a simple network framework that contains volley,okhttp,nohttp.

#基于整合了volley,okhttp,nohttp的一个网络框架。
##简单封装了一下volley,okhttp,nohttp
###1.你可以在volley,okhttp,nohttp之间无缝切换
###2.可以把对象解析，集合解析成你要的数据.


#发起一个请求 demo

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
