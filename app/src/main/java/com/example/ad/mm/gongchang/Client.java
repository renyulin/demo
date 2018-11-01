package com.example.ad.mm.gongchang;

public class Client {

    public static void createMan() {
        IntHumanFactory humanFactory = new HumanFactory();
        Human human = humanFactory.createHuman(YellowMan.class);
        human.getColor();
        human.getName();

        Human whiteHuman = SHumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.getName();
    }
}
