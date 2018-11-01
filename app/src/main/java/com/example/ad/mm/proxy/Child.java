package com.example.ad.mm.proxy;

import android.util.Log;

public class Child implements IUser {
    private String nickName;

    public Child(IUser user, String nickName) {
        if (user != null) {
            this.nickName = nickName;
        } else {
            Log.e("dddddddd_Child", " no this child");
        }
    }

    @Override
    public void startPlay() {
        Log.e("dddddddd_Child", nickName + " startPlay");
    }

    @Override
    public void playing() {
        Log.e("dddddddd_Child", nickName + " playing");
    }

    @Override
    public void endPlay() {
        Log.e("dddddddd_Child", nickName + " endPlay");
    }
}
