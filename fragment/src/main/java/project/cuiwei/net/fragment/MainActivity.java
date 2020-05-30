package project.cuiwei.net.fragment;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NewsShowFragment news_show = new NewsShowFragment();
//        FragmentTransaction t = getFragmentManager().beginTransaction();
//
//        Fragment container = getFragmentManager().findFragmentById(R.id.container);
//        //首先向空容器container添加news_show fragment
//        t.add(R.id.container, news_show);
//
//        //把整个container容器换成newsList fragment
//        t.replace(R.id.container, new NewsListFragment());
//        t.remove(news_show);
//        t.addToBackStack(null);
//        t.commit();

        Button news_list = (Button)findViewById(R.id.news_list);
        Button news_show = (Button)findViewById(R.id.news_show);

        news_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                NewsListFragment news_list = new NewsListFragment();
                transaction.add(R.id.container, news_list);
                transaction.commit();
            }
        });


        news_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                NewsShowFragment news_show = new NewsShowFragment();
                transaction.add(R.id.container, news_show);
                transaction.commit();
            }
        });
    }
}
