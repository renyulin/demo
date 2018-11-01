package com.example.ad.mm.flipview;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public interface ImgaeLoadCompleteMonitor {

    /**
     * 图片加载张数
     */
    int imgNum = 5;

    /**
     * 是否加载完成
     */
//    boolean isComplete = false;

    /**
     * 加载完成调用的方法
     */
    void onComplete();

}
