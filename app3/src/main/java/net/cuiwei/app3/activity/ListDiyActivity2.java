package net.cuiwei.app3.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import net.cuiwei.app3.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDiyActivity2 extends AppCompatActivity {

    private String[] title={"标题1", "标题2", "标题3", "标题4"};
    private String[] descs={"描述1", "描述2", "描述3", "描述4"};
    private int imgs[]={R.drawable.icon144, R.drawable.icon144, R.drawable.icon144, R.drawable.icon144};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        List listItems = new ArrayList();

        for (int i=0; i<title.length; i++){
            Map listItem = new HashMap();
            listItem.put("header", imgs[i]);
            listItem.put("header2", imgs[i]);
            listItem.put("title", title[i]);
            listItem.put("desc", descs[i]);
            listItems.add(listItem);
        }
       System.out.println("cw:"+listItems.toString());
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.article_item,
                new String[] {"header", "header2", "title", "desc"},
                new int[] {R.id.header,R.id.header2, R.id.title, R.id.desc});
        ListView list = (ListView) findViewById(R.id.list);
        //为listview 设置adapter
        list.setAdapter(simpleAdapter);

    }
}
