package net.cuiwei.diyview.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.cuiwei.diyview.R;

/**
 * 图片点击切换
 */
public class ImagesToggleFragment extends Fragment {
    int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };
    int current = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_images_toggle, container, false);
        LinearLayout root = view.findViewById(R.id.root);
        final ImageView img = new ImageView(getContext());
        root.addView(img);

        img.setImageResource(imgs[0]);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                img.setImageResource(imgs[++current % imgs.length]);
            }

        });
        return view;
    }
}