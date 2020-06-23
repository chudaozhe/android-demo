package net.cuiwei.app3.activity;

import android.os.Bundle;

import net.cuiwei.app3.R;

import net.cuiwei.app3.model.ManualModel;
import net.cuiwei.app3.bean.Manual;
import net.cuiwei.app3.listener.OnManualListListener;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
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
