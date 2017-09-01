package xaircraft.interviewtest.touchListener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by chenyulong on 2017/9/1.
 */

public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        this(context,null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyLayout", "onTouchEvent: " + event.getAction());
        return super.onTouchEvent(event);
    }
}
