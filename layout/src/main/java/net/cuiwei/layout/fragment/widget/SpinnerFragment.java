package net.cuiwei.layout.fragment.widget;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.layout.R;

public class SpinnerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_spinner, container, false);
        Spinner spinner = view.findViewById(R.id.spinner2);
        String[] arr = {"第三个", "第四个", "第五个"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, arr);
        spinner.setAdapter(adapter);
        return view;
    }
}