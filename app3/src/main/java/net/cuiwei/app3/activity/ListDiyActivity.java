package net.cuiwei.app3.activity;

import android.os.Bundle;

import net.cuiwei.app3.adapter.RecyclerAdapter;
import net.cuiwei.app3.bean.Manual;
import net.cuiwei.app3.listener.OnManualListListener;
import net.cuiwei.app3.model.ManualModel;
import net.cuiwei.app3.view.AdvanceDecoration;
import net.cuiwei.app3.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDiyActivity extends AppCompatActivity implements OnManualListListener {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_diy);

        /** init recyclerView */
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new RecyclerAdapter(this, new RecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListDiyActivity.this, "id:"+position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new AdvanceDecoration(this, OrientationHelper.VERTICAL));

        ManualModel jokeModel = new ManualModel();
        jokeModel.list(1, this);
    }
    @Override
    public void onSuccess(ArrayList<Manual> list) {
        this.myAdapter.addAll(list, 0);
    }

    @Override
    public void onError() {

    }
}
