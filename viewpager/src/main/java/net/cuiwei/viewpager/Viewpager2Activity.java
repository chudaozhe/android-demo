package net.cuiwei.viewpager;

import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import net.cuiwei.viewpager.adapter.Viewpager2Adapter;

import java.util.ArrayList;
import java.util.List;

public class Viewpager2Activity extends AppCompatActivity {
    //装图片id的数组
    private int[]bitmaps = {R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4};
    private ViewPager viewpager;
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
    }

    /**
     * 设置viewpager
     */
    public void setViewpager(){
        List<ImageView> images = new ArrayList<ImageView>();
        for (int i = 0; i < bitmaps.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(bitmaps[i]);
            //imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//背景不拉伸
            //imageView.setLayoutParams(new ViewGroup.LayoutParams(500,100));
            imageView.setTag(bitmaps[i]);
            images.add(imageView);
        }

        //设置适配器
        viewpager.setAdapter(new Viewpager2Adapter(images,this));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            public void onPageSelected(int arg0) {
                setImageBackground(arg0 % bitmaps.length);
            }
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        viewpager.setCurrentItem((bitmaps.length) * 100);
    }
    /**
     * 设置指示器
     */
    public void setIndicators(){
        for (int i = 0; i < bitmaps.length; i++) {
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

