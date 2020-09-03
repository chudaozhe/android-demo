package net.cuiwei.video;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import net.cuiwei.video.fragment.Video1Fragment;

public class ContentActivity extends AppCompatActivity {
    public FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //fragment管理器
        mManager=getSupportFragmentManager();
        Intent intent=getIntent();
        String action=intent.getAction();
        //System.out.println("action:"+action);
        if (action.equals("video1")){
            mManager.beginTransaction().replace(R.id.container,new Video1Fragment()).commit();
        }
    }
}
