package com.example.work.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.work.myapplication.R;
import com.example.work.myapplication.bean.Person;
import com.example.work.myapplication.bean.Reg;
import com.example.work.myapplication.listener.OnRegListener;
import com.example.work.myapplication.model.RegModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class RegResultActivity extends AppCompatActivity implements OnRegListener {
    public TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView name = (TextView) findViewById(R.id.name);
        TextView passwd = (TextView) findViewById(R.id.passwd);
        TextView sex = (TextView) findViewById(R.id.sex);
        msg = (TextView) findViewById(R.id.msg);

        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("person");
        name.setText("你的用户名：" + p.getName());
        passwd.setText("你的密码：" + p.getPasswd());
        sex.setText("你的性别：" + p.getSex());

        try {
            RegModel model = new RegModel();
            model.reg(p.getName(), this);
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

    @Override
    public void onSuccess(Reg reg) {
        this.msg.setText("成功，提示信息：" + reg.msg);
    }

    @Override
    public void onError() {
        this.msg.setText("注册失败了, 用户名不能为空");
    }
}
