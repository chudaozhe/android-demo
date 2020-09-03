package net.cuiwei.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import net.cuiwei.video.util.AssetsUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.video1).setOnClickListener(this);

        //AssetsUtil
//        String[] files= AssetsUtil.getFilesFromAssets(MainActivity.this, "");
//        for (String str : files) {
//            Log.e("fiels", "assets files -- " + str);
//        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video1:
                Intent intent=new Intent(this, ContentActivity.class);
                intent.setAction("video1");
                startActivity(intent);
                break;

        }
    }
}
