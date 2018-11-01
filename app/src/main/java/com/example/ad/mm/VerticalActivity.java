package com.example.ad.mm;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ad.mm.flipview.FlipView;
import com.example.ad.mm.vp.VerticalAdapter;
import com.example.ad.mm.vp.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class VerticalActivity extends Activity {
    private VerticalViewPager mVerticalViewPager;
    private VerticalAdapter mVerticalAdapter;
    private List<View> mViews = new ArrayList<>();
    private int mCurrentPosition;
    private int mPlayingPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        init();
    }

    private void init() {
        mVerticalViewPager = findViewById(R.id.vertical_vp);
        for (int i = 0; i < 50; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_vp, null);
            RelativeLayout item_vp_h_head = view.findViewById(R.id.item_vp_h_head);
            ImageView item_vp_avatar = view.findViewById(R.id.item_vp_avatar);
            TextView item_vp_name = view.findViewById(R.id.item_vp_name);
            TextView item_vp_date = view.findViewById(R.id.item_vp_date);
            ImageView item_vp_dismiss = view.findViewById(R.id.item_vp_dismiss);
            RelativeLayout item_vp_play_rl = view.findViewById(R.id.item_vp_play_rl);
            ImageView item_vp_default = view.findViewById(R.id.item_vp_default);//占位图
            FlipView item_vp_play_flip = view.findViewById(R.id.item_vp_play_flip);
            TextView item_vp_title_rl = view.findViewById(R.id.item_vp_title_rl);
            ImageView item_vp_title_back = view.findViewById(R.id.item_vp_title_back);
            TextView item_vp_title_tv = view.findViewById(R.id.item_vp_title_tv);
            RelativeLayout item_vp_controller_rl = view.findViewById(R.id.item_vp_controller_rl);
            ImageView item_vp_controller_play = view.findViewById(R.id.item_vp_controller_play);
            ImageView item_vp_controller_next = view.findViewById(R.id.item_vp_controller_next);
            SeekBar item_vp_controller_bar = view.findViewById(R.id.item_vp_controller_bar);
            ImageView item_vp_controller_vh = view.findViewById(R.id.item_vp_controller_vh);
            TextView item_vp_controller_time = view.findViewById(R.id.item_vp_controller_time);
            ImageView item_vp_center_play = view.findViewById(R.id.item_vp_center_play);
            ImageView item_vp_like = view.findViewById(R.id.item_vp_like);
            TextView item_vp_like_add = view.findViewById(R.id.item_vp_like_add);
            ImageView item_vp_share = view.findViewById(R.id.item_vp_share);
            mViews.add(view);
        }

        mVerticalAdapter = new VerticalAdapter(mViews);
        mVerticalViewPager.setAdapter(mVerticalAdapter);

        mVerticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.e("sssssssssssss", "mCurrentId == " + position + ", positionOffset == " + positionOffset +
//                        ", positionOffsetPixels == " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("sssssssssssss", "position: " + position);
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("sssssssssssss", "onPageScrollStateChanged: " + state);
                if (mPlayingPosition == mCurrentPosition) return;
                if (state == VerticalViewPager.SCROLL_STATE_IDLE) {
//                    ViewParent parent = mIjkVideoView.getParent();
//                    if (parent != null && parent instanceof FrameLayout) {
//                        ((FrameLayout) parent).removeView(mIjkVideoView);
//                    }
//                    startPlay();
                }
            }
        });
        //自动播放第一条
        mVerticalViewPager.post(new Runnable() {
            @Override
            public void run() {
                startPlay();
            }
        });
    }

    private void startPlay() {
//        View view = mViews.get(mCurrentPosition);
//        FrameLayout frameLayout = view.findViewById(R.id.container);
//        ImageView imageView = view.findViewById(R.id.thumb);
//        frameLayout.addView(mIjkVideoView);
//        mIjkVideoView.setUrl(mVideoList.get(mCurrentPosition).getUrl());
//        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
//        mIjkVideoView.start();
//        mPlayingPosition = mCurrentPosition;
    }

    /**
     * 把状态栏设成透明
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = this.getWindow().getDecorView();
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                    return defaultInsets.replaceSystemWindowInsets(
                            defaultInsets.getSystemWindowInsetLeft(),
                            0,
                            defaultInsets.getSystemWindowInsetRight(),
                            defaultInsets.getSystemWindowInsetBottom());
                }
            });
            ViewCompat.requestApplyInsets(decorView);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        }
    }

    private String[] pics = new String[]{
            "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=com.github.castorflex.verticalviewpager&step_word=&hs=0&pn=27&spn=0&di=135361204111&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=4100010990%2C2314868451&os=998545185%2C2293845807&simid=0%2C0&adpicid=0&lpn=0&ln=1313&fr=&fmq=1528687013648_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Faliyunzixunbucket.oss-cn-beijing.aliyuncs.com%2Fjpg%2F4196ee45272a8358b77c5af4ba5a98fb.jpg%3Fx-oss-process%3Dimage%2Fresize%2Cp_100%2Fauto-orient%2C1%2Fquality%2Cq_90%2Fformat%2Cjpg%2Fwatermark%2Cimage_eXVuY2VzaGk%3D%2Ct_100&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bwsty7g_z%26e3Bv54AzdH3F3tw5vijg2AzdH3Fba9dc_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0&islist=&querylist="
            , "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=com.github.castorflex.verticalviewpager&step_word=&hs=0&pn=86&spn=0&di=73294176231&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2410901516%2C53165842&os=2266511608%2C1570935412&simid=3139332880%2C3793818613&adpicid=0&lpn=0&ln=1313&fr=&fmq=1528687013648_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimage.lxway.com%2Fthumb%2F280x220%2Fc%2Ff7%2Fcf7615d108f7d36ecb558536e46c401e.gif&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bsxowy_z%26e3Bv54AzdH3Fd0mabb0_z%26e3Bip4s&gsm=1e&rpstart=0&rpnum=0&islist=&querylist="
            , ""
    };
}
