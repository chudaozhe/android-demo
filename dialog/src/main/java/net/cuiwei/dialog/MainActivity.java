package net.cuiwei.dialog;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import net.cuiwei.dialog.fragment.*;
import net.cuiwei.dialog.nice.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);

        //第二组
        findViewById(R.id.bt6).setOnClickListener(this);
        findViewById(R.id.bt7).setOnClickListener(this);
        findViewById(R.id.bt8).setOnClickListener(this);
        findViewById(R.id.bt9).setOnClickListener(this);

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
            case R.id.bt5:
                new Bottom2Dialog().show(getSupportFragmentManager(), "5");
                break;
            case R.id.bt6:
                ConfirmDialog.newInstance("1")
                        .setMargin(60)
                        .setOutCancel(false)
                        .show(getSupportFragmentManager());
//                ConfirmDialog.newInstance("2")
//                        .setMargin(60)
//                        .setOutCancel(true)
//                        .show(getSupportFragmentManager());
                break;
            case R.id.bt7:
                CommonDialog.newInstance()
                        .setLayoutId(R.layout.dialog_friend)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseDialog dialog) {
                                holder.getView(R.id.close).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setShowBottom(true)
                        .setSize(0, 310)
                        .show(getSupportFragmentManager());
                break;
            case R.id.bt8:
                CommonDialog.newInstance()
                        .setLayoutId(R.layout.dialog_comment)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseDialog dialog) {
                                final EditText et_input = holder.getView(R.id.edit_input);

                                holder.setOnClickListener(R.id.tv_commit, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String text = et_input.getText().toString().trim();
                                        text = TextUtils.isEmpty(text) ? "请输入文字" : et_input.getText().toString().trim();
                                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setShowBottom(true)
                        .show(getSupportFragmentManager());
                break;
            case R.id.bt9:
                CommonDialog.newInstance()
                        .setLayoutId(R.layout.dialog_share)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseDialog dialog) {
                                holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, "微信分享", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setDimAmout(0.3f)
                        .setShowBottom(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
                break;
        }
    }
}
