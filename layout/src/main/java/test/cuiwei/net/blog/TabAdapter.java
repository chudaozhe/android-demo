package test.cuiwei.net.blog;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter
{


    public static final String[] TITLES = new String[] { "业界", "移动", "研发", "程序员杂志", "云计算" };


    public TabAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public Fragment getItem(int arg0)
    {
        MainFragment fragment = new MainFragment(arg0);
        return fragment;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return TITLES[position % TITLES.length];
    }


    @Override
    public int getCount()
    {
        return TITLES.length;
    }


}