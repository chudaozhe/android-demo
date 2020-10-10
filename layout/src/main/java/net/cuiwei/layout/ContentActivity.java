package net.cuiwei.layout;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import net.cuiwei.layout.fragment.base.FrameFragment;
import net.cuiwei.layout.fragment.base.GridFragment;
import net.cuiwei.layout.fragment.base.LinearFragment;
import net.cuiwei.layout.fragment.base.TableFragment;
import net.cuiwei.layout.fragment.demo.DemoFragment;
import net.cuiwei.layout.fragment.demo.TextFragment;
import net.cuiwei.layout.fragment.widget.*;

public class ContentActivity extends AppCompatActivity {
    public FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //fragment管理器
        mManager=getSupportFragmentManager();
        Intent intent=getIntent();
        String action=intent.getAction();
        if (action!=null) {
            if (action.equals("linear_layout")) {
                mManager.beginTransaction().replace(R.id.container, new LinearFragment()).addToBackStack(null).commit();
            }else if (action.equals("frame_layout")) {
                mManager.beginTransaction().replace(R.id.container, new FrameFragment()).addToBackStack(null).commit();
            }else if (action.equals("grid_layout")) {
                mManager.beginTransaction().replace(R.id.container, new GridFragment()).addToBackStack(null).commit();
            }else if (action.equals("table_layout")) {
                mManager.beginTransaction().replace(R.id.container, new TableFragment()).addToBackStack(null).commit();
            }else if (action.equals("webview")) {
                mManager.beginTransaction().replace(R.id.container, new WebViewFragment()).addToBackStack(null).commit();
            }else if (action.equals("picker")) {
                mManager.beginTransaction().replace(R.id.container, new PickerFragment()).addToBackStack(null).commit();
            }else if (action.equals("notify")) {
                mManager.beginTransaction().replace(R.id.container, new NotifyFragment()).addToBackStack(null).commit();
            }else if (action.equals("spinner")) {
                mManager.beginTransaction().replace(R.id.container, new SpinnerFragment()).addToBackStack(null).commit();
            }else if (action.equals("dialog")) {
                mManager.beginTransaction().replace(R.id.container, new DialogFragment()).addToBackStack(null).commit();
            }else if (action.equals("text")) {
                mManager.beginTransaction().replace(R.id.container, new TextFragment()).addToBackStack(null).commit();
            }else if (action.equals("demo")) {
                mManager.beginTransaction().replace(R.id.container, new DemoFragment()).addToBackStack(null).commit();
            }

        }
    }
}