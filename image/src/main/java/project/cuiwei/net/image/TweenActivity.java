package project.cuiwei.net.image;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class TweenActivity extends AppCompatActivity {
    ImageView flower=null;
    Animation anim=null;
    Handler handler=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        flower= (ImageView) findViewById(R.id.flower);
        //加载一个动画资源
        anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        //动画结束是保留结束状态
        anim.setFillAfter(true);
        final Animation back = AnimationUtils.loadAnimation(this, R.anim.back);
        back.setFillAfter(true);

        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                if (msg.what == 0x123)
                {
                    flower.startAnimation(back);
                }
            }
        };
    }

    public void Play(View view) {
        flower.startAnimation(anim);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 3500);

    }
}
