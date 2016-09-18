package project.cuiwei.net.restest;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by home on 2016/8/26.
 */
public class MyAnimationView extends View {
    public MyAnimationView(PropertyActivity propertyActivity) {
        super(propertyActivity);
        //加载动画资源
        ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(propertyActivity, R.animator.color_anim);
        colorAnim.setEvaluator(new ArgbEvaluator());
        //对view本身应用属性动画
        colorAnim.setTarget(this);
        //开始动画
        colorAnim.start();
    }
}
