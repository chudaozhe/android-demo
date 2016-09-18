package com.example.work.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView list = (ListView) findViewById(R.id.newlist);

        //定义刷新小圈的颜色
        final SwipeRefreshLayout sr = (SwipeRefreshLayout) findViewById(R.id.sr);
        sr.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //重新请求
                setData(list);
                sr.setRefreshing(false);
            }
        });

        //绑定数据
        setData(list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    //绑定数据
    public void setData(ListView list){
//        String [] data = {"第一条","第二条", "第三条"};
        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=1");
            Log.d("TAG", "cwcom in");
            JSONArray arr = new JSONArray(result);
            ArrayList data = new ArrayList();
            for(int i=0; i<arr.length(); i++)
            {
                data.add(arr.getJSONObject(i).getString("name"));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.news_item, data);
            list.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
