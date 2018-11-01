package com.example.ad.mm.proxy;

public class YoungProxy implements IForceUser {
    private IForceUser iForceUser;

    public YoungProxy(IForceUser iForceUser) {
        this.iForceUser = iForceUser;
    }

    @Override
    public IForceUser getProxy() {
        return this;
    }

    @Override
    public void startPlay() {
        iForceUser.startPlay();
    }

    @Override
    public void playing() {
        iForceUser.playing();
    }

    @Override
    public void endPlay() {
        iForceUser.endPlay();
    }
}
