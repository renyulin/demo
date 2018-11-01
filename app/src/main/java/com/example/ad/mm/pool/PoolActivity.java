package com.example.ad.mm.pool;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.ad.mm.R;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void testClick(View view) {
        switch (view.getId()) {
            case R.id.test_btn1:
                b();
                break;
            case R.id.test_btn2:
                handler.sendEmptyMessageDelayed(0,500);
                break;
            case R.id.test_btn3:

                break;
        }
    }

    void a() {
        Map<String, String> map = new HashMap<>();
        map.containsKey("key");
        Set<String> set = new HashSet<>();
        set.contains("key");
        set.size();
        List<String> list = new ArrayList<>();
    }

    ThreadPoolExecutor executor;

    private void b() {
        executor = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
        handler.sendEmptyMessageDelayed(0,500);
    }

    class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int pool = executor.getPoolSize();
            System.out.println("线程池中线程数目：" + pool + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
            if (pool != 0) {
                handler.sendEmptyMessageDelayed(0,500);
            }
        }
    };

    private void c(int i){
        if (i!=0){
            i--;
            c(i);
        }
    }

    private void d(){
        Socket socket;
    }
}
