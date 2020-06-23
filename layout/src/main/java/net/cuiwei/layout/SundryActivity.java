package net.cuiwei.layout;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.cuiwei.layout.R;

public class SundryActivity extends AppCompatActivity {

    NotificationManager nm;
    static final int NOTIFICATION_ID = 0x123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundry);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Toast
        Button toastbtn = (Button) findViewById(R.id.toast);
        toastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(SundryActivity.this, "提示一下"
                        //提示信息持续时间
                        , Toast.LENGTH_SHORT
                );
                toast.show();
            }
        });
    }

    // 为发送通知的按钮的点击事件定义事件处理方法
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void send(View source)
    {
        // 创建一个启动其他Activity的Intent
        Intent intent = new Intent(SundryActivity.this
                , TextActivity.class);
        PendingIntent pi = PendingIntent.getActivity(
                SundryActivity.this, 0, intent, 0);
        Notification notify = new Notification.Builder(this)
                // 设置打开该通知，该通知自动消失
                .setAutoCancel(true)
                        // 设置显示在状态栏的通知提示信息
                .setTicker("有新消息")
                        // 设置通知的图标
                .setSmallIcon(R.drawable.ok)
                        // 设置通知内容的标题
                .setContentTitle("一条新通知")
                        // 设置通知内容
                .setContentText("恭喜你，您加薪了，工资增加20%!")
                        // 设置使用系统默认的声音、默认LED灯
                .setDefaults(Notification.DEFAULT_SOUND
                         |Notification.DEFAULT_LIGHTS)
                        // 设置通知的自定义声音
                .setWhen(System.currentTimeMillis())
                        // 设改通知将要启动程序的Intent
                .setContentIntent(pi)
                .build();
        // 发送通知
        nm.notify(NOTIFICATION_ID, notify);
    }
    // 为删除通知的按钮的点击事件定义事件处理方法
    public void del(View v)
    {
        // 取消通知
        nm.cancel(NOTIFICATION_ID);
    }

}
