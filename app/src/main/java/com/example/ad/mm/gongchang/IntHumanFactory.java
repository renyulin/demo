package com.example.ad.mm.gongchang;

public interface IntHumanFactory {
    public <T extends Human> T createHuman(Class<T> c);
}
