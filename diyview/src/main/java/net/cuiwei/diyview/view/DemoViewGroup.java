package net.cuiwei.diyview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class DemoViewGroup extends ViewGroup {
    public DemoViewGroup(Context context) {
        super(context);
    }

    public DemoViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DemoViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.layout(i * getWidth(), t, (i + 1) * getWidth(), b);
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }
    /**
     * 切换页面
     * @param index
     */
    public void scrollPage(int index){
        Log.e("scrollPage", String.valueOf(index*getWidth()));
        scrollTo(index*getWidth(), 0);
    }
}
