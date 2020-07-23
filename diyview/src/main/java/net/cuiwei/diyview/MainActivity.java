package net.cuiwei.diyview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tags).setOnClickListener(this);
        findViewById(R.id.images_toggle).setOnClickListener(this);
        findViewById(R.id.grid).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ContentActivity.class);
        switch (v.getId()){
            case R.id.tags:
                intent.setAction("tags");
                break;
            case R.id.images_toggle:
                intent.setAction("images_toggle");
                break;
            case R.id.grid:
                intent.setAction("grid");
                break;
        }
        startActivity(intent);
    }
}
