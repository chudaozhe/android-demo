package net.cuiwei.recyclerviewgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.cuiwei.recyclerviewgroup.adapter.TopicAdapter;
import net.cuiwei.recyclerviewgroup.bean.Topic;
import net.cuiwei.recyclerviewgroup.bean.Topics;
import net.cuiwei.recyclerviewgroup.listener.OnListListener;
import net.cuiwei.recyclerviewgroup.model.TopicModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnListListener<Topics> {
    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=findViewById(R.id.recyclerview);
        TopicModel model=new TopicModel();
        model.list(this);
    }

    @Override
    public void onSuccess(ArrayList<Topics> list) {
        List<Object> items = new ArrayList<>();
        //数据获取之后  将数据循环遍历，放进items集合中，至于服务器返回什么格式的数据，我想看下实体类就应该明白了
        for (int i=0; i < list.size(); i++){
            items.add(list.get(i));
            for(int k = 0; k < list.get(i).getTopic().size(); k ++){
                items.add(list.get(i).getTopic().get(k));
            }
        }
        //实例化适配器将遍历好的数据放进适配器中
        TopicAdapter adapter = new TopicAdapter(this ,items);
        //new一个布局管理器，这里是用GridLayoutManager，要区分3列
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 3);//多少列，如果数据项只需要1列，这里写1，下面return 也返回1即可实现
        //下面这个方法很重要，根据position获取当前这条数据是标题还是数据项，来设置他的跨列
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //适配器中有这么一个方法，根据position获取当前这条数据是标题还是数据项，来设置他的跨列
                switch (adapter.getItemViewType(position)){
                    case TopicAdapter.SITES://标题的话跨多少列 这个值要跟整个列数相等 如果大于会出错，小于布局会乱
                        return 3;
                    case TopicAdapter.SITE://数据项
                        return 1;//不跨列，就是分成三列显示
                    default:
                        return -1;
                }
            }
        });
        recyclerview.setLayoutManager(gridLayoutManager);
//        sitesRecycleView.addItemDecoration(new DividerItemDecoration(getActivity() , GridLayoutManager.VERTICAL));
        recyclerview.setAdapter(adapter);

        //item的点击事件，这里实现，进行具体的操作
        adapter.setOnItemClickListener(new TopicAdapter.OnItemClickListener() {
            @Override
            public void onClick(View itemview, int position) {
                switch (adapter.getItemViewType(position)){
                    case TopicAdapter.SITE:
                        Toast.makeText(MainActivity.this, ((Topic) items.get(position)).getName(), Toast.LENGTH_SHORT).show();//items.get(position)).getName()
//                        Intent intent = new Intent(this , WebViewActivity.class);
//                        intent.putExtra("url" , ((Sites.Site) items.get(position)).getUrl());
//                        startActivity(intent);
                        break;
                    case TopicAdapter.SITES:
                        Toast.makeText(MainActivity.this, ((Topics) items.get(position)).getTitle(), Toast.LENGTH_SHORT).show();//((Topics) items.get(position)).getTitle()
                        break;
                }
            }
        });
       System.out.println(list);

    }


    @Override
    public void onError() {

    }
}
