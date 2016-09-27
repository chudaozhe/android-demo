package project.cuiwei.net.image;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//逐帧动画
public class AnimationActivity extends AppCompatActivity {
    ImageView img=null;
    AnimationDrawable anim=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        img = (ImageView) findViewById(R.id.anim);
        anim = (AnimationDrawable) img.getBackground();
    }

    public void End(View view) {
        anim.stop();
    }

    public void Start(View view) {
        anim.start();
    }
}