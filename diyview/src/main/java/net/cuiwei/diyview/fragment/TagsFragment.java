package net.cuiwei.diyview.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.cuiwei.diyview.R;
import net.cuiwei.diyview.view.TagsLayout;

public class TagsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tags, container, false);
        TagsLayout tagsLayout = view.findViewById(R.id.tags);

        String[] str =  new String[]{"jj","b","jjjj","sfdf","看了司法局分手舒服舒服舒服","jj","b","j","sfdf","iiwer","jj","b","jjjj","sfdf","iiwer","jj","b","jjjj","sfdf","iiwer"};

        for (int  i = 0; i < str.length; i++) {
            TextView tv = new TextView(getContext());
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(26f);
            tv.setPadding(10,10,10,10);
            tv.setBackgroundResource(R.drawable.yuan_juxing);

            int left, top, right, bottom;
            left = top = right = bottom = 64;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(left, top, right, bottom);

            tv.setLayoutParams(layoutParams);

            int id = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("TagsFragment-id:", String.valueOf(id));
//                    Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
                }
            });
            tv.setText(str[i]);
            tagsLayout.addView(tv);
        }
        return view;
    }
}