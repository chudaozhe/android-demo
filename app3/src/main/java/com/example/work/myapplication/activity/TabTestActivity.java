package com.example.work.myapplication.activity;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.work.myapplication.R;
import com.example.work.myapplication.bean.Manual;
import com.example.work.myapplication.listener.OnManualListListener;
import com.example.work.myapplication.model.ManualModel;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabTestActivity extends TabActivity implements OnManualListListener {

    public SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        // 获取该Activity里面的TabHost组件
        TabHost tabHost = getTabHost();
        // 创建第一个Tab页
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")

                .setIndicator("File") // 设置标题
                .setContent(R.id.tab01); //设置内容
        // 添加第一个标签页
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                // 在标签标题上放置图标
                .setIndicator("Array", getResources()
                        .getDrawable(R.drawable.img1))
                .setContent(R.id.tab02);
        // 添加第二个标签页
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("String")
                .setContent(R.id.tab03);
        // 添加第三个标签页
        tabHost.addTab(tab3);
        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4")
                .setIndicator("Mysql")
                .setContent(R.id.tab04);
        // 添加第三个标签页
        tabHost.addTab(tab4);


        //获取导航按钮控件
        TabWidget mTabWidget = tabHost.getTabWidget();

        for(int i=0;i<mTabWidget.getChildCount();i++){
            //换字体颜色
            TextView tv = (TextView)
                    mTabWidget.getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.rgb(255, 255, 255));
//            tv.setBackgroundColor(Color.argb(150, 22, 70, 150));
            tv.setTextSize(16);
            //设置背景图
            mTabWidget.getChildAt(i).setBackgroundResource(
                    R.drawable.tabwidget_selector);
        }
        ManualModel jokeModel = new ManualModel();
        jokeModel.list(1, this);
    }

    @Override
    public void onSuccess(ArrayList<Manual> arr) {
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems1 = new ArrayList<Map<String, Object>>();
        try {
            for (int i = 0; i < arr.size(); i++) {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.get(i).getName());
                listItem.put("desc", "参数：" + arr.get(i).getArgs());
                listItem.put("output", "返回值：" + arr.get(i).getOutput());
                listItem.put("remark", "备注：" + arr.get(i).getRemark());
                listItems1.add(listItem);
            }
            System.out.println(listItems1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 创建一个SimpleAdapter
        this.simpleAdapter = new SimpleAdapter(this, listItems1,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list1 = (ListView) findViewById(R.id.tab01);
        // 为ListView设置Adapter
        list1.setAdapter(simpleAdapter);
//方法太笨
//        ListView list2 = (ListView) findViewById(R.id.tab02);
//        list2.setAdapter(simpleAdapter2);
//        ListView list3 = (ListView) findViewById(R.id.tab03);
//        list3.setAdapter(simpleAdapter3);
//        ListView list4 = (ListView) findViewById(R.id.tab04);
//        list4.setAdapter(simpleAdapter4);
    }

    @Override
    public void onError() {

    }
}
