package com.example.work.myapplication.activity;

import android.os.Bundle;

import com.example.work.myapplication.R;
import com.example.work.myapplication.bean.Manual;
import com.example.work.myapplication.listener.OnManualListListener;
import com.example.work.myapplication.model.ManualModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity implements OnManualListListener {
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.newlist);

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
                setData();
                sr.setRefreshing(false);
            }
        });

        setData();

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
    public void setData(){
//        String [] data = {"第一条","第二条", "第三条"};
        try {
            ManualModel jokeModel = new ManualModel();
            jokeModel.list(1, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(ArrayList<Manual> arr) {
        //绑定数据
        ArrayList<String> data = new ArrayList<String>();
        for(int i=0; i<arr.size(); i++) {
            Manual item=arr.get(i);
            data.add(item.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.news_item, data);
        this.listView.setAdapter(adapter);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "出错来哦！", Toast.LENGTH_SHORT).show();
    }
}
