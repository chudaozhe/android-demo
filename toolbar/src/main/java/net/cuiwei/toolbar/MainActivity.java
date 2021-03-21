package net.cuiwei.toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int screenHeight=DisplayUtil.getScreenHeight(this);
        int screenWidth=DisplayUtil.getScreenWidth(this);
        int statusHeight=DisplayUtil.getStatusHeight(this);
        int navigationBarHeight=DisplayUtil.getNavigationBarHeight(this);
        boolean checkDeviceHasNavigationBar=DisplayUtil.checkDeviceHasNavigationBar(this);
        Log.e("screen-statusHeight", String.valueOf(statusHeight));
        Log.e("screen-navigationBarHeight", String.valueOf(navigationBarHeight));
        Log.e("screen-checkDeviceHasNavigationBar", String.valueOf(checkDeviceHasNavigationBar));
        Log.e("screen-height", String.valueOf(screenHeight));
        Log.e("screen-width", String.valueOf(screenWidth));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        View view = findViewById(R.id.view);
        view.setBackgroundResource(R.color.colorAccent);
        view.getLayoutParams().height=370;

        setSupportActionBar(toolbar);//toolbar仅仅是个viewGroup, 这里用作actionBar
        getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏标题

        //toolbar.setTitle("首页");
        //toolbar.setSubtitle("小标题");
        //toolbar.setTitleTextColor(Color.YELLOW);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher); //加载返回图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {   //为图标设置监听器
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加菜单
        //参数 groupid,itemid,order,string
        //order 小的排前面

        //menu.add(0,0,100,R.string.action_settings);
        //menu.add(0,1,1000,R.string.app_name);
        //menu.add(0,2,2000,R.string.hello_blank_fragment);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Toast.makeText(MainActivity.this, "test.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setVisible(false);//隐藏一个菜单
        //menu.add(R.string.app_name);
        menu.add(1, Menu.FIRST, Menu.FIRST, "发表").setOnMenuItemClickListener(new MyOnMenuItemClickListener()).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);//always
        //menu.add(1, Menu.FIRST, Menu.FIRST, "发表").setIntent(new Intent(this, MainActivity2.class));
        menu.setGroupVisible(1, true);

        return true;
    }
    public static class MyOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener{

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.e("itemId:", item.getItemId()+"");
            return true;
        }
    }
}
