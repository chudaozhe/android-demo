package net.cuiwei.layout.fragment.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.layout.R;

public class DialogFragment extends Fragment implements View.OnClickListener {
    private String[] items = new String[] {"第一个", "第二个", "第三个", "第四个"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dialog, container, false);

        view.findViewById(R.id.first).setOnClickListener(this);
        view.findViewById(R.id.second).setOnClickListener(this);
        view.findViewById(R.id.third).setOnClickListener(this);
        view.findViewById(R.id.fourth).setOnClickListener(this);
        view.findViewById(R.id.fifth).setOnClickListener(this);
        view.findViewById(R.id.sixth).setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first:
                first();
                break;
            case R.id.second:
                second();
                break;
            case R.id.third:
                third();
                break;
            case R.id.fourth:
                fourth();
                break;
            case R.id.fifth:
                fifth();
                break;
            case R.id.sixth:
                sixth();
                break;
        }
    }
    //第一个Dialog
    public void first() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("简单的Dialog")
                .setIcon(R.drawable.ok)
                .setMessage("这是一条提示\n很好的效果！");
        setPositiveButton(builder);

        setNegativeButton(builder)
                .create()
                .show();
    }

    //第二个列表弹窗
    public void second() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("列表Dialog")
                .setIcon(R.drawable.ok)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getContext(), "点击了" + items[which], Toast.LENGTH_SHORT);
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
    public void third() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("单选Dialog")
                .setIcon(R.drawable.ok)
                .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getContext(), "点击了" + items[which], Toast.LENGTH_SHORT);
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
    public void fourth() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
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
    public void fifth() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("自定义Dialog")
                .setIcon(R.drawable.ok)
                .setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.dialog_array_item, items), null);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    //第六个自定义Dialog
    public void sixth() {
        TableLayout loginForm = (TableLayout)getLayoutInflater().inflate( R.layout.dialog_login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
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

    /**
     * 确定按钮
     * @param builder
     * @return
     */
    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        // 调用setPositiveButton方法添加“确定”按钮
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getContext(), "\"单击了【确定】按钮！\"", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    /**
     * 取消按钮
     * @param builder
     * @return
     */
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        // 调用setNegativeButton方法添加“取消”按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getContext(), "\"单击了【取消】按钮！\"", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}