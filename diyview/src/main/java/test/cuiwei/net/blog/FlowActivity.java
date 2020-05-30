package test.cuiwei.net.blog;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);


//        MyViewGroup myViewGroup = new MyViewGroup(this);
        MyViewGroup myViewGroup = (MyViewGroup) findViewById(R.id.myview);

//        linearLayout.addView(myViewGroup);

        String[] str =  new String[]{
                "jj",
                "b",
                "jjjj",
                "sfdf",
                "看了司法局分手舒服舒服舒服",
                "jj",
                "b",
                "j",
                "sfdf",
                "iiwer",
                "jj",
                "b",
                "jjjj",
                "sfdf",
                "iiwer",
                "jj",
                "b",
                "jjjj",
                "sfdf",
                "iiwer"
        };
        for (int  i = 0; i < str.length; i++) {
            TextView tv = new TextView(this);
            tv.setTextColor(Color.BLUE);
            tv.setTextSize(26f);
            tv.setPadding(10,10,10,10);
            tv.setBackgroundResource(R.drawable.yuan_juxing);

            int left, top, right, bottom;
            left = top = right = bottom = 64;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(left, top, right, bottom);

            tv.setLayoutParams(layoutParams);

            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FlowActivity.this, "\""+finalI+"\"", Toast.LENGTH_SHORT).show();
                }
            });
            tv.setText(str[i]);
            myViewGroup.addView(tv);
        }

    }
}
