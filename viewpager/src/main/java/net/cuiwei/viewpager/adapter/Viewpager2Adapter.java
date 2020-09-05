package net.cuiwei.viewpager.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Viewpager2Adapter extends PagerAdapter {
    private List<ImageView> list;
    private Context context;
    public Viewpager2Adapter(List<ImageView> list, Context context) {
        super();
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView = list.get(position%list.size());
        container.addView(imageView,0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("viewpage-position", String.valueOf(position%list.size()));
            }
        });
        return imageView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView(list.get(position%list.size()));
    }
}