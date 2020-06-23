package net.cuiwei.service.orderReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver2 extends BroadcastReceiver {
    public Receiver2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Bundle bundle = getResultExtras(true);
        String newd = intent.getStringExtra("msg")+"\n"+bundle.getString("new");
        Toast.makeText(context, "2收到的消息为:"+newd, Toast.LENGTH_LONG).show();
    }
}
