package com.example.ad.mm;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Button;


/**
 * https://www.jianshu.com/p/d993ad653293 实现置顶功能
 * https://www.jianshu.com/p/f579999723ca 滑动速度改变
 * https://github.com/JakePrim/VideoFeed  qq空间视频播放
 */
public class MainActivity extends AppCompatActivity implements MainAdapter.CallBack, View.OnClickListener {
    private RecyclerView mainRecycler;
    private Button mainBtn;
    private Slayoutmanager slayoutmanager;
    private MainAdapter adapter;
    private boolean isSlide = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRecycler = findViewById(R.id.mainRecycler);
        slayoutmanager = new Slayoutmanager(this,LinearLayoutManager.HORIZONTAL,false);
        slayoutmanager.setSlideTime(0.1f);
        mainRecycler.setLayoutManager(slayoutmanager);
        adapter = new MainAdapter(this, this);
        mainRecycler.setAdapter(adapter);
        mainBtn = findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(this);
        String s = String.format("so.%s", "token");

        Log.e("ssssssssssssssssss", Math.random(  ) + "");
    }

    private long time = 0;
    private float instance = 0;
    private int eventStatus = 0;//0初始状态 1按下 2抬起 3运行
    VelocityTracker mVelocityTracker;

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int index = ev.getActionIndex();
//        int action = ev.getActionMasked();
//        int pointerId = ev.getPointerId(index);
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                mVelocityTracker.addMovement(ev);
//                // When you want to determine the velocity, call
//                // computeCurrentVelocity(). Then call getXVelocity()
//                // and getYVelocity() to retrieve the velocity for each pointer ID.
//                mVelocityTracker.computeCurrentVelocity(1000);
//                // Log velocity of pixels per second
//                // Best practice to use VelocityTrackerCompat where possible.
//                Log.d("", "X velocity: " +
//                        VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId));
//                Log.e("xxxxxxxxxxxxxxxx", "Yvelocity: " +
//                        VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId));
//                float speed = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId);
//                if (Math.abs(speed) > 500) {
//
//                }
////                //向上正数  向下负数
////                long speed = (long) ((ev.getY() - instance) / (SystemClock.uptimeMillis() - time));
////                Log.e("sssssssssssssssss", "speed:" + speed);
////                if (eventStatus == 3) {
////                    return true;
////                }
////                if (Math.abs(speed) > 1) {
////                    if (speed > 0) {
////                        eventStatus = 3;
////                        int lastVisibleItem = slayoutmanager.findLastVisibleItemPosition() - 1;
////                        if (lastVisibleItem <= 0) {
////                            lastVisibleItem = 0;
////                        }
////                        mainRecycler.smoothScrollToPosition(lastVisibleItem);
////                    } else if (speed < 0) {
////                        eventStatus = 3;
////                        int firstVisibleItem = slayoutmanager.findFirstVisibleItemPosition() + 1;
////                        if (firstVisibleItem >= adapter.getItemCount()) {
////                            firstVisibleItem = adapter.getItemCount() - 1;
////                        }
////                        mainRecycler.smoothScrollToPosition(firstVisibleItem);
////                    }
////                    return true;
////                }
//                break;
//            case MotionEvent.ACTION_DOWN://按下
//                if (mVelocityTracker == null) {
//                    // Retrieve a new VelocityTracker object to watch the velocity of a motion.
//                    mVelocityTracker = VelocityTracker.obtain();
//                } else {
//                    // Reset the velocity tracker back to its initial state.
//                    mVelocityTracker.clear();
//                }
//                // Add a user's movement to the tracker.
//                mVelocityTracker.addMovement(ev);
////                eventStatus = 1;
////                instance = (float) ev.getY();
////                time = SystemClock.uptimeMillis();
//                break;
//            case MotionEvent.ACTION_UP://抬起
//                eventStatus = 0;
//                // Return a VelocityTracker object back to be re-used by others.
//                if (mVelocityTracker != null) {
//                    mVelocityTracker.recycle();
//                    mVelocityTracker = null;
//                }
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }

//    private void fast(int dy) {
////        mainRecycler.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(),
////                SystemClock.uptimeMillis(), MotionEvent.ACTION_CANCEL, 0, 0, 0));
//        if (dy > 0) {
//            int firstVisibleItem = slayoutmanager.findFirstVisibleItemPosition() + 1;
//            if (firstVisibleItem >= adapter.getItemCount()) {
//                firstVisibleItem = adapter.getItemCount() - 1;
//            }
//            mainRecycler.smoothScrollToPosition(firstVisibleItem);
//        } else {
//            int lastVisibleItem = slayoutmanager.findLastVisibleItemPosition() - 1;
//            if (lastVisibleItem <= 0) {
//                lastVisibleItem = 0;
//            }
//            mainRecycler.smoothScrollToPosition(lastVisibleItem);
//        }
//    }


    //    The RecyclerView is not currently scrolling.
//      当前的recycleView不滑动(滑动已经停止时)
//    public static final int SCROLL_STATE_IDLE = 0;
//     *
//      *  * The RecyclerView is currently being dragged by outside input such as user touch input.
//      *  * 当前的recycleView被拖动滑动
//      *  */
//    public static final int SCROLL_STATE_DRAGGING = 1;
//      *  * The RecyclerView is currently animating to a final position while not under
//      *  * outside control.
//      *  * 当前的recycleView在滚动到某个位置的动画过程,但没有被触摸滚动.调用 scrollToPosition(int) 应该会触发这个状态
//      *  */
//    public static final int SCROLL_STATE_SETTLING = 2;
    @Override
    public void click(int position) {
        mainRecycler.smoothScrollToPosition(position + 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainBtn:
//                getCurrentViewIndex();
                break;
        }
    }

    /**
     * 如果滑行未到一半，则返回原来的
     * 快速滑动，快速切换
     */
    public int getCurrentViewIndex() {
        int firstVisibleItem = slayoutmanager.findFirstVisibleItemPosition();
        int lastVisibleItem = slayoutmanager.findLastVisibleItemPosition();
        int currentIndex = firstVisibleItem;
        int lastHeight = 0;
        for (int i = firstVisibleItem; i <= lastVisibleItem; i++) {
            View view = slayoutmanager.getChildAt(i - firstVisibleItem);
            if (null == view) {
                continue;
            }

            int[] location = new int[2];
            view.getLocationOnScreen(location);

            Rect localRect = new Rect();
            view.getLocalVisibleRect(localRect);

            int showHeight = localRect.bottom - localRect.top;
            if (showHeight > lastHeight) {
                currentIndex = i;
                lastHeight = showHeight;
            }
        }

        if (currentIndex < 0) {
            currentIndex = 0;
        }

        return currentIndex;
    }
}

