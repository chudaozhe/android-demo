package net.cuiwei.service;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.cuiwei.service.orderReceiver.OrderActivity;

import net.cuiwei.service.R;

public class MainActivity extends AppCompatActivity {
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start= (Button) findViewById(R.id.first_service_start);
        stop= (Button) findViewById(R.id.first_service_stop);

        final Intent intent = new Intent(this, FirstService.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }
    public void bindService(View v){
        Intent intent = new Intent(MainActivity.this, BindServiceActivity.class);
        startActivity(intent);
    }
    public void intentService(View v){
        Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
        startActivity(intent);
    }
    public void orderReceiver(View v){
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);
    }

}
