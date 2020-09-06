package net.cuiwei.viewpager;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import net.cuiwei.viewpager.adapter.Viewpager2Adapter;
import net.cuiwei.viewpager.view.NoScrollViewPager;

public class Viewpager2Activity extends AppCompatActivity {
    private int[] ids = {R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4};//
    private NoScrollViewPager viewpager;
    //指示器
    private LinearLayout indicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewpager2);
        viewpager = findViewById(R.id.viewPager);
        indicators = findViewById(R.id.indicators);

        setIndicators();
        setViewpager();
        //1张图片时 隐藏指示器，并禁止滑动
        if (ids.length<2) {
            indicators.setVisibility(View.GONE);
        }else {
            viewpager.setNoScroll(false);
        }

    }

    /**
     * 设置viewpager
     */
    public void setViewpager(){
        //设置适配器
        viewpager.setAdapter(new Viewpager2Adapter(ids,this));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setImageBackground(position % ids.length);
            }
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //默认第一个张
        viewpager.setCurrentItem(0);
    }
    /**
     * 设置指示器
     */
    public void setIndicators(){
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(50,50);
            layout.setMargins(10, 0, 10, 0);
            imageView.setLayoutParams(layout);//图片宽高
            //imageView.setPadding(100, 0, 10, 0);
            if(i==0){
                imageView.setBackgroundResource(R.mipmap.white);
            }else {
                imageView.setBackgroundResource(R.mipmap.black);
            }
            indicators.addView(imageView);
        }
    }
    /**
     * 设置当前指示器
     */
    private void setImageBackground(int selectItems) {
        //Log.e("viewpage-count", indicators.getChildCount()+"");
        for (int i = 0; i < indicators.getChildCount(); i++) {
            ImageView imageView=(ImageView) indicators.getChildAt(i);
            //Log.e("viewpage-view", indicators.getChildAt(i).toString());
            if (i == selectItems) {
                imageView.setBackgroundResource(R.mipmap.white);
            } else {
                imageView.setBackgroundResource(R.mipmap.black);
            }
        }
    }
}

