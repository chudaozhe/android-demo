package net.cuiwei.layout;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //底部tab
        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.product).setOnClickListener(this);
        findViewById(R.id.news).setOnClickListener(this);
        findViewById(R.id.contact).setOnClickListener(this);

        //调起Linear
        findViewById(R.id.linear).setOnClickListener(this);

        //调起Table
        findViewById(R.id.table).setOnClickListener(this);

        //调起Frame
        findViewById(R.id.frame).setOnClickListener(this);

        //调起Grid
        findViewById(R.id.grid).setOnClickListener(this);

        //调起Text
        findViewById(R.id.text).setOnClickListener(this);

        //调起Spinner下拉框
        findViewById(R.id.spinner).setOnClickListener(this);

        //调起Picker
        findViewById(R.id.picker).setOnClickListener(this);

        //调起Notify
        findViewById(R.id.notify).setOnClickListener(this);

        //调起Dialog
        findViewById(R.id.dialog).setOnClickListener(this);

        //调起WebView
        findViewById(R.id.webview).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this, ContentActivity.class);
        String action="";
        switch (v.getId()){
            case R.id.linear:
                action="linear_layout";
                break;
            case R.id.frame:
                action="frame_layout";
                break;
            case R.id.grid:
                action="grid_layout";
                break;
            case R.id.table:
                action="table_layout";
                break;
            case R.id.webview:
                action="webview";
                break;
            case R.id.picker:
                action="picker";
                break;
            case R.id.notify:
                action="notify";
                break;
            case R.id.spinner:
                action="spinner";
                break;
            case R.id.dialog:
                action="dialog";
                break;
            case R.id.text:
                action="text";
                break;
            case R.id.home:
                Toast.makeText(MainActivity.this, "首页",Toast.LENGTH_SHORT).show();
                break;
            case R.id.product:
                Toast.makeText(MainActivity.this, "产品中心",Toast.LENGTH_SHORT).show();
                break;
            case R.id.news:
                Toast.makeText(MainActivity.this, "新闻中心",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(MainActivity.this, "联系我们",Toast.LENGTH_SHORT).show();
                break;
        }
        Integer[] positions={R.id.home, R.id.product, R.id.news, R.id.contact};
        if(!Arrays.asList(positions).contains(v.getId())){
            intent.setAction(action);
            startActivity(intent);
        }
    }
}
