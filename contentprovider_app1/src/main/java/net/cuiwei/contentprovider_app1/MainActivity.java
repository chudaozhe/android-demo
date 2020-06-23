package net.cuiwei.contentprovider_app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//此MainActivity仅仅为了能安装到手机
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}