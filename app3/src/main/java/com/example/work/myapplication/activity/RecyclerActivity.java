package com.example.work.myapplication.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.work.myapplication.R;
import com.example.work.myapplication.bean.Manual;
import com.example.work.myapplication.listener.OnManualListListener;
import com.example.work.myapplication.model.ManualModel;


import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements OnManualListListener {
    public RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));

        ManualModel model = new ManualModel();
        model.list(1, this);
    }

    @Override
    public void onSuccess(ArrayList<Manual> list) {
        recyclerview.setAdapter(new DemoAdapter(this, list));
    }

    @Override
    public void onError() {

    }

    public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.VH> {
        private List<Manual> dataList;
        private Context context;

        public DemoAdapter(Context context, ArrayList<Manual> datas) {
            this.dataList = datas;
            this.context = context;
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(View.inflate(context, R.layout.recycler_item_1, null));
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.name.setText(dataList.get(position).getName());
            holder.args.setText(dataList.get(position).getArgs());
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class VH extends RecyclerView.ViewHolder {
            TextView name;
            TextView args;

            public VH(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.name);
                args = (TextView) itemView.findViewById(R.id.args);
            }
        }
    }
}