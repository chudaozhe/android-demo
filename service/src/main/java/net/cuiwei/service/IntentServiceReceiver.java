package net.cuiwei.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class IntentServiceReceiver extends BroadcastReceiver {
    public IntentServiceReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "接收到Intent的action为：" + intent.getAction()+"\n消息："+intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
    }
}
