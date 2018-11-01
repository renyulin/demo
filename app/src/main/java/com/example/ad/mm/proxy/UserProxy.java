package com.example.ad.mm.proxy;

public class UserProxy implements IUser {
    private IUser child;

    public UserProxy(String nickName) {
        child = new Child(this, nickName);
    }

    @Override
    public void startPlay() {
        child.startPlay();
    }

    @Override
    public void playing() {
        child.playing();
    }

    @Override
    public void endPlay() {
        child.endPlay();
    }
}
