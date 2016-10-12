package com.example.work.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recyclerview = (RecyclerView)
                findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false));

        ArrayList<ArticleBean> datas = new ArrayList<>();

        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=1");
            Log.d("TAG", "cwcom in");
            JSONArray arr = new JSONArray(result);

            for(int i=0; i<arr.length(); i++)
            {
                ArticleBean articleBean = new ArticleBean();
                articleBean.setName(arr.getJSONObject(i).getString("name"));
                articleBean.setArgs(arr.getJSONObject(i).getString("args"));
                datas.add(articleBean);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        recyclerview.setAdapter(new DemoAdapter(this, datas));
    }

    public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.VH> {
        private List<ArticleBean> dataList;
        private Context context;

        public DemoAdapter(Context context, ArrayList<ArticleBean> datas) {
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