package project.cuiwei.net.materialtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SamplePagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"Item One", "Item Two", "Item Three", "Item Four", "Item Five", "Item Six", "Item Seven", "Item Eight",
            "Item Nine", "Item Ten", "Item Eleven"};

    private final ArrayList<String> mTitles;

    public SamplePagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        mTitles = new ArrayList<>();
        for (int i = 0; i < numberOfTabs; i++) {
            mTitles.add(TITLES[i]);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public Fragment getItem(int position) {
        return SampleFragment.newInstance(position);
    }
}
