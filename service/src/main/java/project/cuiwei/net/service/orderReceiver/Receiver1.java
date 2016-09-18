package project.cuiwei.net.service.orderReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver1 extends BroadcastReceiver {
    public Receiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "1收到的消息为:"+intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putString("new", "加点料");
        setResultExtras(bundle);
        //停止传播
//        abortBroadcast();
    }
}
