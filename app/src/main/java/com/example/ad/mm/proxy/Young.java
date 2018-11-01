package com.example.ad.mm.proxy;

import android.util.Log;

public class Young implements IForceUser, IProxy {
    private IForceUser proxy;
    private String nickName;
    private long startTime;
    private long endTime;
    private boolean isEnd;

    public Young(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public IForceUser getProxy() {
        this.proxy = new YoungProxy(this);
        return this.proxy;
    }

    @Override
    public void startPlay() {
        if (isProxy()) {
            isEnd = false;
            Log.e("dddddddd_Young", nickName + " startPlay");
            startTime = System.currentTimeMillis();
        } else {
            Log.e("dddddddd_Young", " 请使用指定的代理访问");
        }
    }

    @Override
    public void playing() {
        if (isProxy()) {
            isEnd = false;
            Log.e("dddddddd_Young", nickName + " playing");
        } else {
            Log.e("dddddddd_Young", " 请使用指定的代理访问");
        }
    }

    @Override
    public void endPlay() {
        if (isProxy()) {
            isEnd = true;
            endTime = System.currentTimeMillis();
            Log.e("dddddddd_Young", nickName + " endPlay");
        } else {
            Log.e("dddddddd_Young", " 请使用指定的代理访问");
        }
    }

    //校验是否是代理访问
    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String playTime() {
        if (isEnd) {
            return "玩了" + (endTime - startTime) / (1000 * 60) + "分钟";
        }
        endTime = System.currentTimeMillis();
        return "玩了" + (endTime - startTime) / (1000 * 60) + "分钟";
    }
}
