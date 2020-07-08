package net.cuiwei.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

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
//        System.out.println("action:"+action);
        if (action.equals("groupList")){
            mManager.beginTransaction().replace(R.id.container,new GroupListFragment()).addToBackStack(null).commit();
        }
    }
}