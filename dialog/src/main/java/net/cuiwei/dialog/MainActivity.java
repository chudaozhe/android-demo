package net.cuiwei.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.cuiwei.dialog.fragment.BottomDialog;
import net.cuiwei.dialog.fragment.CustomViewDialog;
import net.cuiwei.dialog.fragment.DialogTypeDialog;
import net.cuiwei.dialog.fragment.TopDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                new TopDialog().show(getSupportFragmentManager(), "1");
                break;
            case R.id.bt2:
                CustomViewDialog customViewDialog=new CustomViewDialog();
                customViewDialog.show(getSupportFragmentManager(),"2");
                break;
            case R.id.bt3:
                new DialogTypeDialog().show(getSupportFragmentManager(), "3");
                break;
            case R.id.bt4:
                new BottomDialog().show(getSupportFragmentManager(), "4");
                break;
        }
    }
}
