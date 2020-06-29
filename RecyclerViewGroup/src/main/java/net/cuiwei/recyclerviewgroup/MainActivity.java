package net.cuiwei.recyclerviewgroup;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.cuiwei.recyclerviewgroup.bean.Topics;
import net.cuiwei.recyclerviewgroup.listener.OnListListener;
import net.cuiwei.recyclerviewgroup.model.TopicModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnListListener<Topics> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopicModel model=new TopicModel();
        model.list(this);
    }

    @Override
    public void onSuccess(ArrayList<Topics> list) {
       System.out.println(list);

    }


    @Override
    public void onError() {

    }
}
