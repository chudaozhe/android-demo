package net.cuiwei.layout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import net.cuiwei.layout.R;

public class GridActivity extends AppCompatActivity {

    private String[] strs = new String[] {
            "7","8","9","/",
            "4","5","6","x",
            "1","2","3","-",
            ".","0","=","+",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridLayout gridlayout = (GridLayout) findViewById(R.id.grid);
        for (int i=0; i<strs.length; i++){
            Button btn = new Button(this);
            btn.setText(strs[i]);
            btn.setTextSize(40);
            btn.setPadding(5, 35, 5, 35);
            //指定该组件所在行
            GridLayout.Spec rowSpace = GridLayout.spec(i/4 + 2);
            //指定该组件所在列
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpace, columnSpec);
            //指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridlayout.addView(btn, params);

        }

    }

}