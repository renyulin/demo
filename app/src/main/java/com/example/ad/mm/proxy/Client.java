package com.example.ad.mm.proxy;

public class Client {
    public static void dayOfChild() {
        IUser child = new UserProxy("yoyo");
        child.startPlay();
        child.playing();
        child.endPlay();
    }

    public static void dayOfYoung() {//强制
        IForceUser young = new Young("dayoyo");
        IForceUser proxy = young.getProxy();
        proxy.startPlay();
        proxy.playing();
        proxy.endPlay();
    }
}
