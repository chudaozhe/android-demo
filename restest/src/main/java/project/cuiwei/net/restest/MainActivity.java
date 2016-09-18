package project.cuiwei.net.restest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //自定义主题
        setTheme(R.style.cwTheme);
        setContentView(R.layout.activity_main);
        //设置窗口背景
//        getWindow().setBackgroundDrawableResource(R.mipmap.ic_launcher);
        //设置窗口标题 无效
//        getWindow().setTitle(getResources().getText(R.string.title));
        //设置窗口标题 有效
//        setTitle(getResources().getText(R.string.title2));
        //设置窗口标题 有效
        setTitle(R.string.title2);

        Resources res = getResources();
        //获取字符串
        String name= (String) res.getText(R.string.title);
        System.out.println("Test:"+name);
        //获取图片
        Drawable logo =res.getDrawable(R.mipmap.ic_launcher);
    }

    /**
     * 字符串，颜色，尺寸
     * @param v
     */
    public void stringColorSize(View v){
        Intent intent = new Intent(MainActivity.this, ColorActivity.class);
        startActivity(intent);
    }
    /**
     * 数组
     * @param view
     */
    public void array(View view) {
        Intent intent = new Intent(MainActivity.this, ArrayActivity.class);
        startActivity(intent);
    }

    /**
     * XML
     * @param view
     */
    public void XML(View view) {
        Intent intent = new Intent(MainActivity.this, XmlActivity.class);
        startActivity(intent);
    }

    public void Property(View view) {
        Intent intent = new Intent(MainActivity.this, PropertyActivity.class);
        startActivity(intent);
    }

    public void Animation(View view) {
        Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
        startActivity(intent);
    }
}
