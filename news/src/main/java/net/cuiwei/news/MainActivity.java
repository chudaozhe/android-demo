package net.cuiwei.news;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import net.cuiwei.news.view.TitleBar;

public class MainActivity extends Activity {
    private ImageView mCollectView;
    private boolean mIsSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.parseColor("#64b4ff"));
        }

        final TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        assert titleBar != null;

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setLeftImageResource(R.mipmap.back_green);
        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleBar.setTitle("文章详情\n副标题");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        titleBar.setActionTextColor(Color.WHITE);
        mCollectView = (ImageView) titleBar.addAction(new TitleBar.ImageAction(R.mipmap.collect) {
            @Override
            public void performAction(View view) {
                Toast.makeText(MainActivity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                mCollectView.setImageResource(R.mipmap.fabu);
                titleBar.setTitle(mIsSelected ? "文章详情\n朋友圈" : "帖子详情");
                mIsSelected = !mIsSelected;
            }
        });

        titleBar.addAction(new TitleBar.TextAction("发布") {
            @Override
            public void performAction(View view) {
                Toast.makeText(MainActivity.this, "点击了发布", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置
     * @param v
     */
    public void Settings(View v){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     * 图文混排
     * @param v
     */
    public void ImageText(View v){
        Intent intent = new Intent(MainActivity.this, ImageTextActivity.class);
        startActivity(intent);
    }

    /**
     * Form
     * @param v
     */
    public void Form(View v){
        Intent intent = new Intent(MainActivity.this, FormActivity.class);
        startActivity(intent);
    }

    /**
     * Drawer
     * @param view
     */
    public void Drawer(View view) {
        Intent intent = new Intent(MainActivity.this, DrawerActivity.class);
        startActivity(intent);
    }
}
