package com.example.work.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagsActivity extends AppCompatActivity {
    private String[] tags = {"科技", "文学", "小说"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        TextView tv = new TextView(this);
        tv.setText("tvv");
        tv.setTextColor(Color.RED);
        linearLayout.addView(tv);
        linearLayout.removeView(tv);
        linearLayout.addView(tv);

        List items= new ArrayList();
        for (int i=0; i<tags.length; i++){
            Map item = new HashMap();
            item.put("tag", tags[i]);
            items.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items,R.layout.tag_item,
                new String[] {"tag"},
                new int[]{R.id.tag});
        ListView tags=(ListView) findViewById(R.id.tags);
        tags.setAdapter(simpleAdapter);
    }
}
