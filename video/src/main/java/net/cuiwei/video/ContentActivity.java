package net.cuiwei.video;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import net.cuiwei.video.fragment.Video1Fragment;
import net.cuiwei.video.fragment.Video2Fragment;
import net.cuiwei.video.fragment.Video3Fragment;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {
    public FragmentManager mManager;

    private ArrayList<FragmentTouchListener> mFragmentTouchListeners = new ArrayList<>();

    public interface FragmentTouchListener {
        boolean onTouchEvent(MotionEvent event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //fragment管理器
        mManager=getSupportFragmentManager();
        Intent intent=getIntent();
        String action=intent.getAction();
        if (action.equals("video1")){
            mManager.beginTransaction().replace(R.id.container,new Video1Fragment()).commit();
        }else if(action.equals("video2")){
            mManager.beginTransaction().replace(R.id.container,new Video2Fragment()).commit();
        }else if(action.equals("video3")){
            mManager.beginTransaction().replace(R.id.container,new Video3Fragment()).commit();
        }
    }

    /**
     * 事件分发，先于onTouchEvent（事件处理）
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        for (FragmentTouchListener listener : mFragmentTouchListeners) {
            listener.onTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }
    public void registerFragmentTouchListener(FragmentTouchListener listener) {
        mFragmentTouchListeners.add(listener);
    }
    public void unRegisterFragmentTouchListener(FragmentTouchListener listener) {
        mFragmentTouchListeners.remove(listener);
    }

}
