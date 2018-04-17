package com.example.naveen.designprt.widgets;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollViewListener extends ScrollView{
    public ScrollViewListener(Context context) {
        super(context);
    }
    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }

    private OnScrollChangedListener mOnScrollChangedListener;

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public ScrollViewListener(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ScrollViewListener(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}

