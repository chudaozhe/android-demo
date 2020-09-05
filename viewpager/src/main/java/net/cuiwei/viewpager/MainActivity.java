package net.cuiwei.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.v1).setOnClickListener(this);
        findViewById(R.id.v2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.v1:
                Intent intent=new Intent(this, Viewpager1Activity.class);
                startActivity(intent);
                break;
            case R.id.v2:
                Intent intent2=new Intent(this, Viewpager2Activity.class);
                startActivity(intent2);
                break;
        }
    }
}