package net.cuiwei.diyview.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import net.cuiwei.diyview.R;
import net.cuiwei.diyview.view.DemoViewGroup;

public class DemoFragment extends Fragment {
    private DemoViewGroup demoViewGroup;
    private RadioGroup radioGroup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_demo, container, false);
        demoViewGroup = view.findViewById(R.id.demoView);
        radioGroup = view.findViewById(R.id.rg);

        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.demo_view1, null);
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.demo_view2, null);
        View view3 = LayoutInflater.from(getContext()).inflate(R.layout.demo_view3, null);
        demoViewGroup.addView(view1);
        demoViewGroup.addView(view2);
        demoViewGroup.addView(view3);

        for (int i = 0; i < 3; i++) {
            RadioButton radioButton = new RadioButton(getContext());
            if (i == 0) {
                radioButton.setChecked(true);
            }
            radioButton.setId(i);
            radioGroup.addView(radioButton);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                demoViewGroup.scrollPage(checkedId);
            }
        });

        return view;
    }

}