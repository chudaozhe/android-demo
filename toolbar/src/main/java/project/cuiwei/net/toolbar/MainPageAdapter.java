package project.cuiwei.net.toolbar;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends FragmentStatePagerAdapter {

    private int[] imageResId = {
            R.drawable.ok,
            R.drawable.ok,
    }; //要放在Tabs上的圖s
    private String[] titles = {
            "test1",
            "test2",
    };
    private List<String> titleList = new ArrayList<String>();// 每个页面的Title数据

    private Context context;
    List<Fragment> fragments; //切換頁面的Fragments

    public MainPageAdapter(FragmentManager fm , List<Fragment> f, Context context) {
        super(fm);
        this.context=context;
        fragments=f;
    }

    @Override
    public int getCount() { //頁卡數量
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) { //回傳Frament頁卡
        return fragments.get(position); //從上方List<Fragment> fragments取得
    }

    @Override
    public CharSequence getPageTitle(int position) { //在此回傳Tab title string

        titleList.add("Test1");
        titleList.add("Test2");
        //目前TabLayout還沒有提供直接的方法放icon到Tab上，必須自行在getPageTitle實作
        return  titleList.get(position);

//        Drawable image = context.getResources().getDrawable(imageResId[position]); //設定Tabs圖片
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
    }
}
