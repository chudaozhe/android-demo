package net.cuiwei.diyview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import net.cuiwei.diyview.fragment.GridFragment;
import net.cuiwei.diyview.fragment.ImagesToggleFragment;
import net.cuiwei.diyview.fragment.TagsFragment;

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
        //System.out.println("action:"+action);
        if (action.equals("tags")){
            mManager.beginTransaction().replace(R.id.container,new TagsFragment()).addToBackStack(null).commit();
        }else if (action.equals("images_toggle")){
            mManager.beginTransaction().replace(R.id.container,new ImagesToggleFragment()).addToBackStack(null).commit();
        }else if (action.equals("grid")){
            mManager.beginTransaction().replace(R.id.container,new GridFragment()).addToBackStack(null).commit();
        }
    }
}
