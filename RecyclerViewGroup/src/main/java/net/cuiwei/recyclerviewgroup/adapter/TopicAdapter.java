package net.cuiwei.recyclerviewgroup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.cuiwei.recyclerviewgroup.MainActivity;
import net.cuiwei.recyclerviewgroup.R;
import net.cuiwei.recyclerviewgroup.bean.Topic;
import net.cuiwei.recyclerviewgroup.bean.Topics;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int SITES = 0;//标题 跨一列 也就是合并两列
    public static final int SITE = 1;//不跨列
    //所有数据的集合，将标题和数据项，全部装在到这个集合中，在适配器中利用viewtype来区分，并显示不同的布局
    private List<Object> items = new ArrayList<>();
    private Context context;

    public TopicAdapter(Context context, List<Object> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);//获取mInflater对象
        switch (viewType) {//根据viewtyupe来区分，是标题还是数据项
            case SITES://标题，加载显示标题的item布局，就一个textview显示文本，这里我们自顶一个标题的viewholder->TopicsHolder
                final TopicsHolder TopicsHolder = new TopicsHolder(mInflater.inflate(R.layout.item_topics, parent, false));
                //点击事件
                TopicsHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(onItemClickListener != null){
                            onItemClickListener.onClick(TopicsHolder.itemView , TopicsHolder.getLayoutPosition());
                        }
                    }
                });
                return TopicsHolder;
            case SITE://数据项，雷同不赘述了，标题和数据项的item布局和veiwholder都不会相互影响的
                final TopicHolder TopicHolder = new TopicHolder(mInflater.inflate(R.layout.item_topic, parent, false));
                TopicHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(onItemClickListener != null){
                            onItemClickListener.onClick(TopicHolder.itemView , TopicHolder.getLayoutPosition());
                        }
                    }
                });
                return TopicHolder;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        //这个方法很重要，这里根据position取出items集合中的对象，用instanceof判断他是标题还是数据项，来返回对应的标识
        if (items.get(position) instanceof Topics) {//根据items数据类型的不同来判断他是标题还是数据项
            return SITES;//标题
        } else if (items.get(position) instanceof Topic) {
            return SITE;//数据项
        } else {
            return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        //根据getItemViewType绑定view进行赋值显示
        switch (holder.getItemViewType()) {
            case SITES://标题
                TopicsHolder TopicsHolder = (TopicsHolder) holder;
                TopicsHolder.title.setText(((Topics) items.get(position)).getTitle());
                break;
            case SITE://数据项
                TopicHolder TopicHolder = (TopicHolder) holder;
                TopicHolder.name.setText(((Topic) items.get(position)).getName());
//                Glide.with(context).load(((Topic) items.get(position)).getAvatar_url()).into(TopicHolder.icon);
                Glide.with(context).load("https://test.cuiwei.net/phpMyAdmin/themes/pmahomme/img/logo_right.png").into(TopicHolder.icon);//((Topic) items.get(position)).getIcon()//图片显示不出来，再议
                break;
        }
    }

    /**
     * 公布点击事件出去
     */
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(View itemview , int position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * 数据项的viewholder  一个文本textview一个cion  imageview
     */
    private class TopicHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;

        TopicHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            icon = itemView.findViewById(R.id.icon);
        }
    }

    /**
     * 标题的viewholder  只有一个textview
     */
    private class TopicsHolder extends RecyclerView.ViewHolder {

        TextView title;

        TopicsHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}