package com.example.naveen.designprt.googlemap;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

import com.example.naveen.designprt.R;


public class MergedAppBar extends AppBarLayout.ScrollingViewBehavior {

    private Context context;

    private ValueAnimator mAppBarYValueAnimator;
    private boolean mVisible = true;

    private int nestedScrollViewHeight = 0;

    private int appBarHeight = 0;

    private boolean isToolbarhide = false;

    public MergedAppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        return super.onDependentViewChanged(parent, child, dependency);

        if (nestedScrollViewHeight == 0) {
            setHeight((int) dependency.getY());
        }

        if (appBarHeight == 0) {
            setAppBarHeight(child.getHeight());
        }

        if (nestedScrollViewHeight >= dependency.getY() + appBarHeight) {
            showToolbarAnim(child);
            // child.setVisibility(View.GONE);
        } else {

            hideToolbarAnim(child);
            // child.setVisibility(View.VISIBLE);
        }
        return false;
    }

    private void setHeight(int height) {
        nestedScrollViewHeight = height;
    }


    private void setAppBarHeight(int height) {
        appBarHeight = height;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void hideToolbarAnim(View view) {
        view.animate().alpha(1).setDuration(1).translationY(-appBarHeight).setInterpolator(new DecelerateInterpolator());
          setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        // isToolbarhide=true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showToolbarAnim(View view) {
          view.setVisibility(View.VISIBLE);
          view.animate().alpha(1).setDuration(1).translationY(0).setInterpolator(new DecelerateInterpolator());
          setStatusBarColor(ContextCompat.getColor(context, R.color.trans_parent_light));
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void setStatusBarBackgroundVisible(boolean visible) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (visible) {
                Window window = ((Activity) context).getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            } else {
                Window window = ((Activity) context).getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(ContextCompat.getColor(context, android.R.color.transparent));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setStatusBarColor(int color) {
        Window window = ((Activity) context).getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }

}
