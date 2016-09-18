package com.example.work.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView name = (TextView) findViewById(R.id.name);
        TextView passwd = (TextView) findViewById(R.id.passwd);
        TextView sex = (TextView) findViewById(R.id.sex);
        TextView msg = (TextView) findViewById(R.id.msg);

        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("person");
        name.setText("你的名字：" + p.getName());
        passwd.setText("你的密码：" + p.getPasswd());
        sex.setText("你的性别：" + p.getSex());

        String result = null;
        try {
//            result = HttpUtil.getRequest("http://192.168.1.61/Items/test/test.php");
            HashMap sf = new HashMap();
            sf.put("name",p.getName());
            result = HttpUtil.postRequest("http://test.cuiwei.net/reg.php",sf);
            JSONObject json = new JSONObject(result);

//            if (json.get("status") == 1)
            msg.setText("提示信息：" + json.get("msg"));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setText("错误提示：" + e.toString());
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
