package net.cuiwei.viewpager.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Viewpager2Adapter extends PagerAdapter {
    private int[] ids;
    private Context context;
    public Viewpager2Adapter(int[] ids, Context context) {
        super();
        this.ids = ids;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        final int index=position%ids.length;
        imageView.setImageResource(ids[index]);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//背景不拉伸
        //imageView.setLayoutParams(new ViewGroup.LayoutParams(500,100));

        container.addView(imageView,0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("viewpage-position", String.valueOf(index));
            }
        });
        return imageView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}