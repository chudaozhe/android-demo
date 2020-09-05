package net.cuiwei.viewpager;

import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import net.cuiwei.viewpager.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class Viewpager2Activity extends AppCompatActivity {
    //装图片id的数组
    private int[]bitmaps = {R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4};
    private ViewPager viewpager;
    private List<ImageView> list;//装ImageView的集合
    private ImageView imageView;
    private ImageView[] tips;//装点点的集合
    private LinearLayout indicators ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_viewpager2);
        viewpager = findViewById(R.id.viewPager);
        indicators = findViewById(R.id.indicators);

        //将imageView图片资源存在集合中
        list = new ArrayList<ImageView>();
        for (int i = 0; i < bitmaps.length; i++) {
            imageView = new ImageView(Viewpager2Activity.this);
            imageView.setImageResource(bitmaps[i]);
            //imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//背景不拉伸
            //imageView.setLayoutParams(new ViewGroup.LayoutParams(500,100));
            //为imageView设置tag，将id传入，方便页面跳转时，发送图片的资源id
            imageView.setTag(bitmaps[i]);
            list.add(imageView);
        }

        //将点点装入到结集合中
        tips = new ImageView[bitmaps.length];
        for (int i = 0; i < bitmaps.length; i++) {
            imageView = new ImageView(Viewpager2Activity.this);
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(50,50);
            layout.setMargins(10, 0, 10, 0);
            imageView.setLayoutParams(layout);//图片宽高
            //imageView.setPadding(100, 0, 10, 0);
            tips[i]=imageView;
            if(i==0){
                tips[i].setBackgroundResource(R.mipmap.white);
            }else {
                tips[i].setBackgroundResource(R.mipmap.black);
            }
            indicators.addView(imageView);
        }

        //设置适配器
        viewpager.setAdapter(new MyAdapter(list,this));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            public void onPageSelected(int arg0) {
                setImageBackground(arg0 % bitmaps.length);
            }
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        // 第一次初始化界面时，显示的界面
        // 设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
        viewpager.setCurrentItem((bitmaps.length) * 100);
    }
    /**
     * 设置选中的tip的背景 ，选中哪个图片，哪个图片的点点就变成白的
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.mipmap.white);
            } else {
                tips[i].setBackgroundResource(R.mipmap.black);
            }
        }
    }
}

