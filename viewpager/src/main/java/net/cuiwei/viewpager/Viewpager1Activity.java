package net.cuiwei.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import net.cuiwei.viewpager.adapter.Viewpager1Adapter;
import net.cuiwei.viewpager.fragment.Tab1Fragment;
import net.cuiwei.viewpager.fragment.Tab2Fragment;
import net.cuiwei.viewpager.fragment.Tab3Fragment;

import java.util.ArrayList;
import java.util.List;

public class Viewpager1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager1);

        //构造适配器
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new Tab1Fragment());
        fragments.add(new Tab2Fragment());
        fragments.add(new Tab3Fragment());
        Viewpager1Adapter adapter = new Viewpager1Adapter(getSupportFragmentManager(), fragments);

        //设定适配器
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager1);
        vp.setAdapter(adapter);
    }
}