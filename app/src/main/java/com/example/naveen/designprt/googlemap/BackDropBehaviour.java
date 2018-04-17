package com.example.naveen.designprt.googlemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.naveen.designprt.R;


public class BackDropBehaviour<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int mPeekHeight;
    private boolean init = false;
    private int mCollapsedY;
    private int mAnchorPointY;
    private int mCurrentChildY;

    public BackDropBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.BackdropBottomSheetBehavior_Params);
        setPeekHeight(a.getDimensionPixelSize(R.styleable.BackdropBottomSheetBehavior_Params_behavior_backdrop_peekHeight, 0));
        a.recycle();
    }

    private void setPeekHeight(int dimensionPixelSize) {
        mPeekHeight = dimensionPixelSize;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency) {

        if (!init) {
            initialize(child, dependency);
            return false;
        }
        child.setVisibility(View.VISIBLE);

        Log.w("BACKDROP2", "mCollapsedY" + "=====" + mCollapsedY);
        Log.w("BACKDROP2", "mAnchorPointY" + "=====" + mAnchorPointY);
        Log.w("BACKDROP2", "mCurrentChildY" + "=====" + mCurrentChildY);


        Log.w("BACKDROP222", "mCurrentChildY(IF condition)" + "=====" + (int) ((dependency.getY() - mAnchorPointY) * mCollapsedY / (mCollapsedY - mAnchorPointY)));

//        if ((mCurrentChildY = (int) ((dependency.getY() - mAnchorPointY) * mCollapsedY / (mCollapsedY - mAnchorPointY))) <= 0) {
//            child.setY(mCurrentChildY = 0);
//            Log.w("BACKDROP222333333", "mCurrentChildY(IF)" + "=====" + mCurrentChildY);
//        } else {
//            child.setY(mCurrentChildY);
//            Log.w("BACKDROP222444444", "mCurrentChildY(IF else)" + "=====" + mCurrentChildY);
//        }

        if ((mCurrentChildY = (int) (((dependency.getY() - mAnchorPointY) * 4))) <= 0) {
            child.setY(mCurrentChildY = 0);
            Log.w("BACKDROP222333333", "mCurrentChildY(IF)" + "=====" + mCurrentChildY);
        } else {
            child.setY(mCurrentChildY);
            Log.w("BACKDROP222444444", "mCurrentChildY(IF else)" + "=====" + mCurrentChildY);
        }
        return true;

    }

    private void initialize(V child, View dependency) {

        Log.w("BACKDROP", "dependency" + "=====" + dependency.getHeight());

        mCollapsedY = (dependency.getHeight() - (2* mPeekHeight));
        mAnchorPointY = child.getHeight();

        mCurrentChildY = (int) child.getY();

        Log.w("BACKDROP", "mCollapsedY" + "=====" + mCollapsedY);
        Log.w("BACKDROP", "mAnchorPointY" + "=====" + mAnchorPointY);
        Log.w("BACKDROP", "mCurrentChildY" + "=====" + mCurrentChildY);
//
//        if (mCurrentChildY == mAnchorPointY || mCurrentChildY == mAnchorPointY - 1 || mCurrentChildY == mAnchorPointY + 1)
//            child.setY(0);
//        else
        child.setVisibility(View.GONE);
        //    child.setY(mCurrentChildY);

        init = true;

    }

}
