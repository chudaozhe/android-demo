package net.cuiwei.layout.fragment.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import net.cuiwei.layout.R;


public class DemoFragment extends Fragment {
    private static final String[] data = new String[] {
            "first", "second", "third", "fourth", "fifth", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //demo1: ScrollView/ListView填充剩余屏幕
        View view= inflater.inflate(R.layout.fragment_demo1, container, false);
        ListView lv = (ListView) view.findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        return view;
    }
}