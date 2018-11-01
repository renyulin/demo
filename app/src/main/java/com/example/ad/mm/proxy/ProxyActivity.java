package com.example.ad.mm.proxy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.ad.mm.R;

public class ProxyActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void testClick(View view) {
        switch (view.getId()) {
            case R.id.test_btn1:
                Client.dayOfChild();
                break;
            case R.id.test_btn2:
                Client.dayOfYoung();
                break;
            case R.id.test_btn3:
                Message message = new Message();
                message.what = 0;
                message.obj = "sdfddddddddddddddddddddddddddd";
                handler.removeMessages(0);
                handler.sendMessageDelayed(message, 2000);
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Log.e("sdsfsfsfs", msg.obj + "");
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
