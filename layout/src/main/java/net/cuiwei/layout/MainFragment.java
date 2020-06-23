package net.cuiwei.layout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.cuiwei.layout.R;

public class MainFragment extends Fragment
{


    private int newsType = 0;


    public MainFragment(int newsType)
    {
        this.newsType = newsType;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab_item_fragment_main, null);
        TextView tip = (TextView) view.findViewById(R.id.id_tip);
        tip.setText(TabAdapter.TITLES[newsType]);
        return view;
    }


}