package com.example.ad.mm;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class Slayoutmanager extends LinearLayoutManager {
    private float slideTime = 0.3f;
    private Context contxt;

    public Slayoutmanager(Context context) {
        super(context);
    }

    public Slayoutmanager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.contxt = context;
    }

    public void setSlideTime(float slideTime) {
        this.slideTime = slideTime;
    }
    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return true && super.canScrollHorizontally();
    }
    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state,
                                       int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(
                recyclerView.getContext()) {
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return Slayoutmanager.this
                        .computeScrollVectorForPosition(targetPosition);
            }

            // This returns the milliseconds it takes to
// scroll one pixel.
            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
//                return MILLISECONDS_PER_INCH / displayMetrics.density;
                return slideTime;
// 返回滑动一个pixel需要多少毫秒
            }


            @Override
            protected void onTargetFound(View targetView, RecyclerView.State state,
                                         RecyclerView.SmoothScroller.Action action) {
                if (getLayoutManager() == null) {
                    return;
                }
                int dx = calculateDxToMakeVisible(targetView, getHorizontalSnapPreference());
                int dy = calculateDyToMakeVisible(targetView, getVerticalSnapPreference());
                if (dx > 0) {
                    dx = dx - getLayoutManager().getLeftDecorationWidth(targetView);
                } else {
                    dx = dx + getLayoutManager().getRightDecorationWidth(targetView);
                }
                if (dy > 0) {
                    dy = dy - getLayoutManager().getTopDecorationHeight(targetView);
                } else {
                    dy = dy + getLayoutManager().getBottomDecorationHeight(targetView);
                }
                final int distance = (int) Math.sqrt(dx * dx + dy * dy);
                final int time = calculateTimeForDeceleration(distance);
                if (time > 0) {// new AccelerateInterpolator()
                    action.update(-dx, -dy, time, new DecelerateInterpolator());
                }
            }

        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }
}