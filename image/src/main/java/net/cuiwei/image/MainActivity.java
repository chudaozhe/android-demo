package net.cuiwei.image;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Bitmap(View view) {
        Intent intent = new Intent(MainActivity.this, BitmapActivity.class);
        startActivity(intent);
    }

    /**
   *逐帧动画
    * @param view
     */
    public void Animation(View view) {
        Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
        startActivity(intent);
    }

    //补间动画
    public void Tween(View view) {
        Intent intent = new Intent(MainActivity.this, TweenActivity.class);
        startActivity(intent);
    }

    //属性动画
    public void ValueAnimation(View view) {
        Intent intent = new Intent(MainActivity.this, ValueAnimationActivity.class);
        startActivity(intent);
    }
}
