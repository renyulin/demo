package com.example.ad.mm.gongchang;

public class SHumanFactory {
    public static <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
        }
        return (T) human;
    }
}
