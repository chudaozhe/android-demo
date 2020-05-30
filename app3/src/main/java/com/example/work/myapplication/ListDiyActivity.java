package com.example.work.myapplication;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDiyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter myAdapter;
    private SuperSwipeRefreshLayout swipeRefreshLayout;
    // Header View
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;

    // Footer View
    private ProgressBar footerProgressBar;
    private TextView footerTextView;
    private ImageView footerImageView;
    private int i=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_diy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


        // init SuperSwipeRefreshLayout
        swipeRefreshLayout = (SuperSwipeRefreshLayout) findViewById(R.id.swipe_refresh);
//        swipeRefreshLayout.setHeaderViewBackgroundColor(0xFFFFFFFF);
        swipeRefreshLayout.setHeaderView(createHeaderView());// add headerView
        swipeRefreshLayout.setFooterView(createFooterView());
        swipeRefreshLayout.setTargetScrollWithLayout(true);
        swipeRefreshLayout
                .setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {

                    @Override
                    public void onRefresh() {
                        textView.setText("正在刷新");
                        imageView.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
//                                myAdapter.removeAll(0,myAdapter.getItemCount());
                                List<ArticleBean> result =initDatas(1);
//                                myAdapter.addAll(result, 0);
                                myAdapter.getTopic(result);
                                i=1;
                                swipeRefreshLayout.setRefreshing(false);
                                progressBar.setVisibility(View.GONE);
                            }
                        }, 2000);
                    }

                    @Override
                    public void onPullDistance(int distance) {
                        // pull distance
                    }

                    @Override
                    public void onPullEnable(boolean enable) {
                        textView.setText(enable ? "松开刷新" : "下拉刷新");
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setRotation(enable ? 180 : 0);
                    }
                });

        swipeRefreshLayout
                .setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        footerTextView.setText("正在加载...");
                        footerImageView.setVisibility(View.GONE);
                        footerProgressBar.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                footerImageView.setVisibility(View.VISIBLE);
                                footerProgressBar.setVisibility(View.GONE);
                                int p=i+1;
                                System.out.println("cw:new:p=" + p);

                                List<ArticleBean> result =initDatas(p);
                                if (result.size()>0) {
                                    int n = getDataCount(getData(p));
                                    myAdapter.addAll(result, (p - 1) * 16);

                                    //定位，显示第一条新数据
                                    recyclerView.smoothScrollToPosition(linearLayoutManager.getItemCount() - n);
                                    //linearLayoutManager.scrollToPositionWithOffset(page, 49);
                                    if (0<n) i++;
                                }
                                swipeRefreshLayout.setLoadMore(false);
                            }
                        }, 2000);
                    }

                    @Override
                    public void onPushEnable(boolean enable) {
                        footerTextView.setText(enable ? "松开加载" : "上拉加载");
                        footerImageView.setVisibility(View.VISIBLE);
                        footerImageView.setRotation(enable ? 0 : 180);
                    }

                    @Override
                    public void onPushDistance(int distance) {
                        // TODO Auto-generated method stub

                    }

                });
//        setData();

        List<ArticleBean> result =initDatas(1);
        myAdapter.addAll(result, 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setData(){
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        try {
            String result = HttpUtil.getRequest("http://test.cuiwei.net/manual?type=api&cid=1");
            JSONArray arr = new JSONArray(result);

            for (int i = 0; i < arr.length(); i++)
            {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("header", R.drawable.img1);
                listItem.put("personName", "函数名：" + arr.getJSONObject(i).getString("name"));
                listItem.put("desc", "参数：" + arr.getJSONObject(i).getString("args"));
                listItem.put("output", "返回值：" + arr.getJSONObject(i).getString("output"));
                listItem.put("remark", "备注：" + arr.getJSONObject(i).getString("remark"));
                listItems.add(listItem);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        // 创建一个SimpleAdapter
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
//                R.layout.simple_item,
//                new String[] { "personName", "header" , "desc", "output", "remark"},
//                new int[] { R.id.name, R.id.header , R.id.desc, R.id.output, R.id.remark });
//        ListView list = (ListView) findViewById(R.id.mylist);
//        // 为ListView设置Adapter
//        list.setAdapter(simpleAdapter);
    }
    private JSONArray getData(int page){
        //http://test.cuiwei.net/manual?type=api&cid=1
        String result = null;
        JSONArray arr = null;
        try {
            result = HttpUtil.getRequest("http://192.168.9.101/items/manual/index.php?type=api&cid=1&page=" + page + "&max=16");
            Log.d("TAG", "cwcom in");
            arr = new JSONArray(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    private int getDataCount(JSONArray arr){
        if (arr.length() < 1) return 0;
        return arr.length();
    }
    private List<ArticleBean> initDatas(int page) {
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 50; i++) {
//            list.add("item " + i);
//        }
        List<ArticleBean> datas = new ArrayList<>();

        JSONArray arr=getData(page);
        if (arr.length()>0) {
            for (int i = 0; i < arr.length(); i++) {
                ArticleBean articleBean = new ArticleBean();
                try {
                    articleBean.setId(String.valueOf(arr.getJSONObject(i).getInt("id")));
                    articleBean.setCid(arr.getJSONObject(i).getInt("cid"));
                    articleBean.setName(arr.getJSONObject(i).getString("name"));
                    articleBean.setArgs(arr.getJSONObject(i).getString("args"));
                    datas.add(articleBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else return new ArrayList<>();

        return datas;
    }
    private View createFooterView() {
        View footerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_footer, null);
        footerProgressBar = (ProgressBar) footerView
                .findViewById(R.id.footer_pb_view);
        footerImageView = (ImageView) footerView
                .findViewById(R.id.footer_image_view);
        footerTextView = (TextView) footerView
                .findViewById(R.id.footer_text_view);
        footerProgressBar.setVisibility(View.GONE);
        footerImageView.setVisibility(View.VISIBLE);
        footerImageView.setImageResource(R.drawable.down_arrow);
        footerTextView.setText("上拉加载更多...");
        return footerView;
    }

    private View createHeaderView() {
        View headerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_head, null);
        progressBar = (ProgressBar) headerView.findViewById(R.id.pb_view);
        textView = (TextView) headerView.findViewById(R.id.text_view);
        textView.setText("下拉刷新");
        imageView = (ImageView) headerView.findViewById(R.id.image_view);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.drawable.down_arrow);
        progressBar.setVisibility(View.GONE);
        return headerView;
    }

}
