package net.cuiwei.layout.fragment.widget;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.layout.*;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotifyFragment extends Fragment implements View.OnClickListener {
    NotificationManager manager;
    static final int NOTIFICATION_ID = 0x123;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        manager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
        View view= inflater.inflate(R.layout.fragment_notify, container, false);

        view.findViewById(R.id.send).setOnClickListener(this);
        view.findViewById(R.id.cancel).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
                send();
                break;
            case R.id.cancel:
                // 取消通知
                manager.cancel(NOTIFICATION_ID);
                break;
        }
    }
    /**
     * 发送通知
     */
    public void send() {
        // 创建一个启动其他Activity的Intent
        Intent intent=new Intent(getActivity(), ContentActivity.class);
        intent.setAction("linear_layout");
//        startActivity(intent);
        PendingIntent pi = PendingIntent.getActivity(getContext(), 0, intent, 0);
        //1、NotificationManager
//        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder notify = new Notification.Builder(getContext())
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
                .setContentIntent(pi);
        //兼容android 8
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("001","my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.GREEN); //小红点颜色
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            manager.createNotificationChannel(channel);
            notify.setChannelId("001");
        }

        // 发送通知
        manager.notify(NOTIFICATION_ID, notify.build());
    }
}