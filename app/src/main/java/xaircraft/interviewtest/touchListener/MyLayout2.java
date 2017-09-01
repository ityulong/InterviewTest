package xaircraft.interviewtest.touchListener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by chenyulong on 2017/9/1.
 */

public class MyLayout2 extends LinearLayout {
    public MyLayout2(Context context) {
        this(context,null);
    }

    public MyLayout2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyLayout2", "onTouchEvent: ");
        return super.onTouchEvent(event);
    }



}
