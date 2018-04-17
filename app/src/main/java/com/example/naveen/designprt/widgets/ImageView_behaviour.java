package com.example.naveen.designprt.widgets;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class ImageView_behaviour<V extends View> extends CoordinatorLayout.Behavior<V> {

    public ImageView_behaviour(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency) {
        CoordinatorLayout.LayoutParams layoutParams=(CoordinatorLayout.LayoutParams)child.getLayoutParams();
        layoutParams.height=100;
        layoutParams.width=100;
        child.setLayoutParams(layoutParams);
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
