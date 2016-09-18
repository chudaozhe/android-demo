package com.example.work.myapplication;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabTestActivity extends TabActivity {

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

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems1 =
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
                listItems1.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems1,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list1 = (ListView) findViewById(R.id.tab01);
        // 为ListView设置Adapter
        list1.setAdapter(simpleAdapter);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems2 =
                new ArrayList<Map<String, Object>>();
        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=2");
            JSONArray arr = new JSONArray(result);

            for (int i = 0; i < arr.length(); i++)
            {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.getJSONObject(i).getString("name"));
                listItem.put("desc", "参数：" + arr.getJSONObject(i).getString("args"));
                listItem.put("output", "返回值：" + arr.getJSONObject(i).getString("output"));
                listItem.put("remark", "备注：" + arr.getJSONObject(i).getString("remark"));
                listItems2.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter2 = new SimpleAdapter(this, listItems2,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list2 = (ListView) findViewById(R.id.tab02);
        // 为ListView设置Adapter
        list2.setAdapter(simpleAdapter2);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems3 =
                new ArrayList<Map<String, Object>>();
        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=3");
            JSONArray arr = new JSONArray(result);

            for (int i = 0; i < arr.length(); i++)
            {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.getJSONObject(i).getString("name"));
                listItem.put("desc", "参数：" + arr.getJSONObject(i).getString("args"));
                listItem.put("output", "返回值：" + arr.getJSONObject(i).getString("output"));
                listItem.put("remark", "备注：" + arr.getJSONObject(i).getString("remark"));
                listItems3.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter3 = new SimpleAdapter(this, listItems3,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list3 = (ListView) findViewById(R.id.tab03);
        // 为ListView设置Adapter
        list3.setAdapter(simpleAdapter3);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems4 =
                new ArrayList<Map<String, Object>>();
        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=4");
            JSONArray arr = new JSONArray(result);

            for (int i = 0; i < arr.length(); i++)
            {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.getJSONObject(i).getString("name"));
                listItem.put("desc", "参数：" + arr.getJSONObject(i).getString("args"));
                listItem.put("output", "返回值：" + arr.getJSONObject(i).getString("output"));
                listItem.put("remark", "备注：" + arr.getJSONObject(i).getString("remark"));
                listItems4.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter4 = new SimpleAdapter(this, listItems4,
                R.layout.simple_item,
                new String[] { "personName", "header" , "desc", "output", "remark"},
                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
        ListView list4 = (ListView) findViewById(R.id.tab04);
        // 为ListView设置Adapter
        list4.setAdapter(simpleAdapter4);




    }

}
