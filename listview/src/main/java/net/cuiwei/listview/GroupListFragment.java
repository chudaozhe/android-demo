package net.cuiwei.listview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GroupListFragment extends Fragment {
    private GroupListAdapter adapter = null;
    private ListView listView = null;
    private List<String> list = new ArrayList<String>();
    private List<String> listTag = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);
        setData();
        adapter = new GroupListAdapter(getContext(), list, listTag);
        listView = (ListView)view.findViewById(R.id.group_list);
        listView.setAdapter(adapter);
        return view;
    }
    public void setData(){
        list.add("A");
        listTag.add("A");
        for(int i=0;i<3;i++){
            list.add("阿凡达"+i);
        }
        list.add("B");
        listTag.add("B");
        for(int i=0;i<3;i++){
            list.add("比特风暴"+i);
        }
        list.add("C");
        listTag.add("C");
        for(int i=0;i<30;i++){
            list.add("查理风云"+i);
        }
    }
    private static class GroupListAdapter extends ArrayAdapter<String> {

        private List<String> listTag = null;
        public GroupListAdapter(Context context, List<String> objects, List<String> tags) {
            super(context, 0, objects);
            this.listTag = tags;
        }

        @Override
        public boolean isEnabled(int position) {
            if(listTag.contains(getItem(position))){
                return false;
            }
            return super.isEnabled(position);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(listTag.contains(getItem(position))){
                view = LayoutInflater.from(getContext()).inflate(R.layout.group_list_item_tag, null);
            }else{
                view = LayoutInflater.from(getContext()).inflate(R.layout.group_list_item, null);
            }
            TextView textView = (TextView) view.findViewById(R.id.group_list_item_text);
            textView.setText(getItem(position));
            return view;
        }
    }
}