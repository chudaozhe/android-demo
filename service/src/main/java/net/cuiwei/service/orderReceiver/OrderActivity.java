package net.cuiwei.service.orderReceiver;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import net.cuiwei.service.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = new Intent();
        intent.setAction("android.intent.action.CW_ORDER_NOTIFY");
        intent.putExtra("msg", "好消息");
        sendOrderedBroadcast(intent, null);
    }
}
