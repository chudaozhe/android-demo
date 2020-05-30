package project.cuiwei.net.service;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentServiceActivity extends AppCompatActivity {
    Button start_service, start_intent_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        //发送广播
//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.CW_NOTIFY");
//        intent.putExtra("msg", "haha");
//        sendBroadcast(intent);
    }
    public void startService(View v){
        Intent intent = new Intent(IntentServiceActivity.this, TwoService.class);
        startService(intent);
    }
    public void startIntentService(View v){
        Intent intent = new Intent(IntentServiceActivity.this, FirstIntentService.class);
        startService(intent);
    }
}
