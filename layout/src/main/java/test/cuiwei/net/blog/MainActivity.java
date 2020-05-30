package test.cuiwei.net.blog;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView home = (TextView) findViewById(R.id.home);
        TextView product = (TextView) findViewById(R.id.product);
        TextView news = (TextView) findViewById(R.id.news);
        TextView contact = (TextView) findViewById(R.id.contact);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "首页",Toast.LENGTH_SHORT).show();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "产品中心",Toast.LENGTH_SHORT).show();
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "新闻中心", Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "联系我们",Toast.LENGTH_SHORT).show();
            }
        });


        //调起Linear
        Button linear = (Button) findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd = new Intent();
                intentd.setClass(MainActivity.this, LinearActivity.class);
                startActivity(intentd);
            }
        });

        //调起Table
        Button table = (Button) findViewById(R.id.table);
        table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentd = new Intent();
                intentd.setClass(MainActivity.this, TableActivity.class);
                startActivity(intentd);
            }
        });

        //调起Frame
        Button frame = (Button) findViewById(R.id.frame);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FrameActivity.class);
                startActivity(intent);
            }
        });

        //调起Grid
        Button grid = (Button) findViewById(R.id.grid);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });

        //调起Text
        Button text = (Button) findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TextActivity.class);
                startActivity(intent);
            }
        });

        //调起Spinner
        Button spinner = (Button) findViewById(R.id.spinner);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        //调起Dialog
        Button dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        //调起WebView
        Button webview = (Button) findViewById(R.id.webview);
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
        //调起Volley
        Button volley = (Button) findViewById(R.id.volley);
        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolleyActivity.class);
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加菜单
        //参数 groupid,itemid,order,string
        //order 小的排前面
        menu.add(0,0,100,R.string.action_settings);
        menu.add(0,1,1000,R.string.action_settings2);
        menu.add(0,2,2000,R.string.action_settings3);
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
//        if (id == R.id.action_settings) {
//            Toast.makeText(MainActivity.this, "jjj", Toast.LENGTH_SHORT)
//                    .show();
//            return true;
//        }

        switch (id) {
            case 0:
                Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT)
                        .show();
                break;
            case 1:
                Toast.makeText(MainActivity.this, "意见反馈", Toast.LENGTH_SHORT)
                        .show();
                break;
            case 2:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT)
                        .show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
