package net.cuiwei.news;

import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initView();
//        initDrawer();
        mDrawerLayout.openDrawer(Gravity.RIGHT);
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    //根据点击，生成一个对应Fragment
    private void setFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HolderFragment())
                .commit();
    }

    public void Common(View v){
        setFragment();
        Toast.makeText(DrawerActivity.this, "good", Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }
    public void Commony(View v){
        Toast.makeText(DrawerActivity.this, "goody", Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawer(Gravity.RIGHT);
    }
}
