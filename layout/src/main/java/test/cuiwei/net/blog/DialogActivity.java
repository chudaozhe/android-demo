package test.cuiwei.net.blog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private String[] items = new String[] {"第一个", "第二个", "第三个", "第四个"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //第一个Dialog
    public void btn1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单的Dialog")
                .setIcon(R.drawable.ok)
                .setMessage("这是一条提示\n很好的效果！");
                setPositiveButton(builder);

                setNegativeButton(builder)
                .create()
                .show();
    }

    //第二个列表弹窗
    public void btnlist(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("列表Dialog")
                .setIcon(R.drawable.ok)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(DialogActivity.this, "点击了" + items[which]
                                //提示信息持续时间
                                , Toast.LENGTH_SHORT
                        );
                        toast.show();
                    }
                });
                // 为AlertDialog.Builder添加“确定”按钮
                setPositiveButton(builder);
                // 为AlertDialog.Builder添加“取消”按钮
                setNegativeButton(builder)
                .create()
                .show();
    }

    //第三个单选弹窗
    public void btnone(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选Dialog")
                .setIcon(R.drawable.ok)
                .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(DialogActivity.this, "点击了" + items[which]
                                //提示信息持续时间
                                , Toast.LENGTH_SHORT
                        );
                        toast.show();
                    }
                });
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    //第四个多选弹窗
    public void btnmore(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("多选Dialog")
                .setIcon(R.drawable.ok)
                .setMultiChoiceItems(items, new boolean[]{true, false, false, false}, null);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    //第五个自定义Dialog
    public void btndiy(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义Dialog")
                .setIcon(R.drawable.ok)
                .setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), null);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    //第五个自定义Dialog
    public void btnview(View v)
    {
        TableLayout loginForm = (TableLayout)getLayoutInflater()
                .inflate( R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义ViewDialog")
                .setIcon(R.drawable.ok)
                .setView(loginForm);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(
            AlertDialog.Builder builder)
    {
        // 调用setPositiveButton方法添加“确定”按钮
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(DialogActivity.this, "\"单击了【确定】按钮！\""
                        //提示信息持续时间
                        , Toast.LENGTH_SHORT
                );
                toast.show();
            }
        });

    }
    private AlertDialog.Builder setNegativeButton(
            AlertDialog.Builder builder)
    {
        // 调用setNegativeButton方法添加“取消”按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast toast = Toast.makeText(DialogActivity.this, "\"单击了【取消】按钮！\""
                        //提示信息持续时间
                        , Toast.LENGTH_SHORT
                );
                toast.show();
            }
        });
    }
}
