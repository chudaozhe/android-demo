package project.cuiwei.net.image;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ValueAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);

        /**
         * 数值变化
         */
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//        //持续时间300毫秒
//        valueAnimator.setDuration(300);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float c = (float) animation.getAnimatedValue();
//                Log.d("CWNUM", String.valueOf(c));
//            }
//        });
//        valueAnimator.start();

        TextView tv = (TextView) findViewById(R.id.tv);
//        //旋转
////        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "rotation", 0f, 360f);
//        //垂直缩放 指定倍数
////        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "scaleY", 1f, 3f, 1f);
//        //平移
//        float x = tv.getTranslationX();
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "translationX", x, -500f, x);
//        //透明度
////        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
//        objectAnimator.setDuration(5000);
//        objectAnimator.setRepeatCount(3);
//        objectAnimator.setRepeatMode(Animation.REVERSE);
//        objectAnimator.start();

        //组合动画
        //旋转
        ObjectAnimator rn = ObjectAnimator.ofFloat(tv, "rotation", 0f, 360f);
        //垂直缩放 指定倍数
        ObjectAnimator sy = ObjectAnimator.ofFloat(tv, "scaleY", 1f, 3f, 1f);
        //平移
        float x = tv.getTranslationX();
        ObjectAnimator tx = ObjectAnimator.ofFloat(tv, "translationX", x, -50f, x);
        //透明度
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        //先垂直缩放，再旋转同时淡入淡出
        animatorSet.play(rn).with(alpha).after(sy);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(ValueAnimationActivity.this, "动画结束了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
