package net.cuiwei.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by home on 2016/8/29.
 */
public class MyView extends View{
    private Bitmap bitmap = null;

    public MyView(Context context, AttributeSet set){
        super(context, set);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //关闭硬件加速以支持 阴影
        setLayerType( LAYER_TYPE_SOFTWARE , null);
        //背景
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        //去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        //STROKE空心,FILL实心
        paint.setStyle(Paint.Style.STROKE);
        //线条宽
        paint.setStrokeWidth((float) 1.1);
        //阴影,必须是实心
//        paint.setShadowLayer(15,10,10, Color.BLACK);
        //300*100矩形
        canvas.drawRect(10, 10, 310, 110, paint);

        /**
         * 圆形
         */
        Paint paint3 = new Paint();
        //阴影
        paint3.setColor(Color.RED);
        //阴影
        paint3.setShadowLayer(15,10,10, Color.BLACK);
        int viewWidth = this.getWidth();
        //.drawCircle()在指定点绘制圆
//        canvas.drawCircle(viewWidth /10 +10, viewWidth / 10 +10, viewWidth /10, paint3);

    }
}
