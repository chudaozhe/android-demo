package com.example.work.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDiyActivity extends AppCompatActivity {
    private String[] names = new String[]
            { "虎头", "弄玉", "李清照", "李白"};
    private String[] descs = new String[]
            { "可爱的小孩", "一个擅长音乐的女孩"
                    , "一个擅长文学的女性", "浪漫主义诗人"};
    private int[] imageIds = new int[]
            { R.drawable.img1 , R.drawable.img1
                    , R.drawable.img1 , R.drawable.img1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_diy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=1");
            JSONArray arr = new JSONArray(result);

            for (int i = 0; i < arr.length(); i++)
            {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.getJSONObject(i).getString("name"));
                listItem.put("desc", "参数：" + arr.getJSONObject(i).getString("args"));
                listItem.put("output", "返回值：" + arr.getJSONObject(i).getString("output"));
                listItem.put("remark", "备注：" + arr.getJSONObject(i).getString("remark"));
                listItems.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list = (ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
