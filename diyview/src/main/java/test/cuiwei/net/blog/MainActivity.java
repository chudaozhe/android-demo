package test.cuiwei.net.blog;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };
    int current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView) findViewById(R.id.diyfont);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/iconfont.ttf");
        textView.setTypeface(typeface);

        TextView tv = (TextView) findViewById(R.id.iconfont);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/iconfont.ttf");
        tv.setTypeface(tf);

        LinearLayout line = (LinearLayout) findViewById(R.id.line1);
        final ImageView img = new ImageView((this));
        line.addView(img);
        img.setImageResource(imgs[0]);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                img.setImageResource(imgs[++current % imgs.length]);

            }

        });
    }

    /**
     * 设置btn事件
     * @param v
     */
    public void btnFun(View v)
    {
        TextView tv = (TextView) findViewById(R.id.txt);
        tv.setText("你点我了");
    }
    public void Flow(View v){
        Intent intent = new Intent(MainActivity.this, FlowActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
