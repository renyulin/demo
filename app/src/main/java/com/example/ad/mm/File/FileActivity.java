package com.example.ad.mm.File;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ad.mm.R;

import java.io.File;

public class FileActivity extends Activity {
    private TextView test_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        test_tv = findViewById(R.id.test_tv);
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1);
    }

    public void testClick(View view) {
        switch (view.getId()) {
            case R.id.test_btn1:
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        search(new File("/sdcard/"));
                    }
                });
                thread.start();
                break;
            case R.id.test_btn2:
                handler.sendEmptyMessageDelayed(0, 1000);
                break;
            case R.id.test_btn3:
                handler.removeMessages(0);
                break;
        }
    }

    private void search(File fileold) {
        File[] files = fileold.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                Log.e("ssssssssssssssssssss", files[i].getName());
                paty.append(files[i].getPath()+"\n");

                search(files[i]);
            }
        }

    }

    StringBuilder paty = new StringBuilder();

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            test_tv.setText(paty.toString());
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };
}
