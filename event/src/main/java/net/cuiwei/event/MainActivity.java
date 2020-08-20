package net.cuiwei.event;

import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://0
                Log.e("TAG", "onTouchEvent 按住");
                break;
            case MotionEvent.ACTION_UP://1
                Log.e("TAG", "onTouchEvent onTouch抬起");
                break;
            case MotionEvent.ACTION_MOVE://2
                Log.e("TAG", "onTouchEvent 移动");
                break;
        }
        return super.onTouchEvent(event);
    }
}
