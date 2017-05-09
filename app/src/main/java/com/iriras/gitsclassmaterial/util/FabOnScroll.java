package com.iriras.gitsclassmaterial.util;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by irfan on 09/05/17.
 */

public class FabOnScroll extends FloatingActionButton.Behavior {
    public FabOnScroll() {
        super();
    }

    public FabOnScroll(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, FloatingActionButton child, MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            child.show();
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            child.hide();
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }
}
