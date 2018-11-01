package com.example.ad.mm.test;

public abstract class AbstractHumanFactory {
    public abstract <T extends Test.A> T createHuman(Class<T> c);
}
