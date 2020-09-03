package net.cuiwei.video;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.video1).setOnClickListener(this);
        findViewById(R.id.video2).setOnClickListener(this);

        //AssetsUtil
//        String[] files= AssetsUtil.getFilesFromAssets(MainActivity.this, "");
//        for (String str : files) {
//            Log.e("fiels", "assets files -- " + str);
//        }

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, ContentActivity.class);
        String action="video1";
        switch (v.getId()){
            case R.id.video1:
                break;
            case R.id.video2:
                action="video2";
                break;
        }
        intent.setAction(action);
        startActivity(intent);
    }
}
