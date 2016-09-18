package project.cuiwei.net.restest;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ArrayActivity extends AppCompatActivity {

    String[] texts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        texts=getResources().getStringArray(R.array.text_arr);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return texts.length;
            }

            @Override
            public Object getItem(int position) {
                return texts[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(ArrayActivity.this);
                Resources res = getResources();
                text.setWidth((int) res.getDimension(R.dimen.cell_width));
                text.setHeight((int) res.getDimension(R.dimen.cell_height));
                text.setText(texts[position]);
                TypedArray bg = res.obtainTypedArray(R.array.color_arr);
                text.setBackground(bg.getDrawable(position));
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
        GridView grid = (GridView) findViewById(R.id.grid02);
        grid.setAdapter(ba);
    }
}
