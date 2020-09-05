package net.cuiwei.diyview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.cuiwei.diyview.R;

import static android.view.View.MeasureSpec.EXACTLY;

public class GridLayout extends ViewGroup {
    int margin = 2;// 每个格子的水平和垂直间隔
    int colums = 3;//几列
    private int mMaxChildWidth = 0;
    private int mMaxChildHeight = 0;
    int count = 0;
    public Context context;

    public GridLayout(Context context) {
        super(context);
        this.context=context;
        init2();
    }
    public GridLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context=context;
        init2();
    }
    /**
     * 父视图问子视图你想要多大空间
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("onMeasure", "widthMeasureSpec="+widthMeasureSpec+" heightMeasureSpec="+heightMeasureSpec);
        mMaxChildWidth = 0;
        mMaxChildHeight = 0;

        int modeW = 0, modeH = 0;
        if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED) modeW = MeasureSpec.UNSPECIFIED;
        if (MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.UNSPECIFIED) modeH = MeasureSpec.UNSPECIFIED;

        final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), modeW);
        final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), modeH);

        count = getChildCount();
        if (count == 0) {
            super.onMeasure(childWidthMeasureSpec, childHeightMeasureSpec);
            return;
        }
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            mMaxChildWidth = Math.max(mMaxChildWidth, child.getMeasuredWidth());
            mMaxChildHeight = Math.max(mMaxChildHeight, child.getMeasuredHeight());
        }
        //子视图告诉父视图具体大小
        setMeasuredDimension(resolveSize(mMaxChildWidth, widthMeasureSpec), resolveSize(mMaxChildHeight, heightMeasureSpec));
    }

    @Override
    /**
     * l, t, r, b 父view左 上 右 下的位置，默认左上角，也就是 changed=true l=0 t=0 r=1440 b=2800
     */
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("onLayout", "changed="+changed+" l="+l+" t="+t+" r="+r+" b="+b);
        Log.e("onLayout", "count="+count+" colums="+colums);
        int width = r - l;// 布局区域宽度
        int height = b - t;// 布局区域高度
        //count=10, colums=3;
        int rows= (int) Math.ceil((float)count/colums);//行数, 向上取整(注：其中一个转为浮点数
        Log.e("onLayout", "float rows:"+rows);
        if (count == 0) return;
        //int colums2=(int)colums;
        int gridW = (width - margin * (colums - 1)) / colums;// 格子宽度
        //int gridH = (height - margin * rows) / rows;// 格子高度
        int gridH=gridW;
        Log.e("onLayout", "gridW="+gridW+" gridH="+gridH);
        //gridH=400;
        int left = 0;
        int top = margin;

        for (int i = 0; i < rows; i++) {// 遍历行
            for (int j = 0; j < colums; j++) {// 遍历每一行的元素
                View child = this.getChildAt(i * colums + j);//每个格子的下标（从0开始
                if (child == null) return;
                left = j * gridW + j * margin;//每个格子左边距离
                Log.e("onLayout", "getMeasuredWidth="+child.getMeasuredWidth()+" getMeasuredHeight="+child.getMeasuredHeight());
                // 如果当前布局宽度和测量宽度不一样，就直接用当前布局的宽度重新测量
                if (gridW != child.getMeasuredWidth() || gridH != child.getMeasuredHeight()) {
                    child.measure(MeasureSpec.makeMeasureSpec(gridW, EXACTLY), MeasureSpec.makeMeasureSpec(gridH, EXACTLY));
                }
                //用于当前ViewGroup中的子控件的布局, 一个格子四个边 的位置
                child.layout(left, top, left + gridW, top + gridH);
                Log.e("onLayout(layout(l,t,r,b))", "left="+left+" top="+top+" right="+left+gridW+" bottom="+top+gridH);
            }
            top += gridH + margin;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private void init(){
        for (int i=0; i<9; i++){
            ImageView imageView=new ImageView(getContext());
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
            this.addView(imageView);
            this.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    public void init2() {
        for (int i = 0; i < 9; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.publish_grid_item, null);
            ImageView imageView = view.findViewById(R.id.iv);
            ImageView play = view.findViewById(R.id.play);
            imageView.setBackgroundResource(R.mipmap.ic_launcher);//srcs[index]
//            Glide.with(context).load("https://cw-test.oss-cn-hangzhou.aliyuncs.com/"+imgs[index]+"?x-oss-process=image/resize,w_202,h_202,m_fill").into(imageView);
            this.addView(view);
        }
    }
}
