package com.example.ad.mm.gongchang;

import android.util.Log;

public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        Log.e("Human_Color", "YellowMan");
    }

    @Override
    public void getName() {
        Log.e("Human_Name", "no name !");
    }
}
