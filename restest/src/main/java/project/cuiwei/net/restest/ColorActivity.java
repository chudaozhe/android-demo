package project.cuiwei.net.restest;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {

    int[] textIds= new int[]{
            R.string.c1,
            R.string.c2,
            R.string.c3,
            R.string.c4,
            R.string.c5,
            R.string.c6,
            R.string.c7,
            R.string.c8,
            R.string.c9,
    };

    int[] colorIds= new int[]{
            R.color.c1,
            R.color.c2,
            R.color.c3,
            R.color.c4,
            R.color.c5,
            R.color.c6,
            R.color.c7,
            R.color.c8,
            R.color.c9,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return textIds.length;
            }

            @Override
            public Object getItem(int position) {
                return getResources().getText(textIds[position]);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(ColorActivity.this);
                Resources res = getResources();
                text.setWidth((int) res.getDimension(R.dimen.cell_width));
                text.setHeight((int) res.getDimension(R.dimen.cell_height));
                //设置文本框字符串
                text.setText(textIds[position]);
                text.setBackgroundResource(colorIds[position]);
//                text.setTextSize(20);
                text.setTextSize(getResources().getInteger(R.integer.font_size));
                //设置文字居中
                text.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//                text.setTextColor(0xFF0000FF);
                text.setTextColor(Color.WHITE);
//                text.setTextColor(res.getColor(R.color.white));

                return text;
            }
        };
        GridView grid = (GridView) findViewById(R.id.grid01);
        //为GridView设置Adapter
        assert grid != null;
        grid.setAdapter(ba);
    }
}
