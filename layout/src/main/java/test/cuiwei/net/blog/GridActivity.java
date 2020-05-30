package test.cuiwei.net.blog;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
