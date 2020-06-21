package com.example.work.myapplication.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.work.myapplication.R;
import com.example.work.myapplication.bean.Manual;
import com.example.work.myapplication.viewholder.BaseViewHolder;
import com.example.work.myapplication.viewholder.ChildViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author Zheng Haibo
 * @PersonalWebsite http://www.mobctrl.net
 * @Description
 */
public class RecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

	private Context mContext;
	private ArrayList<Manual> mDataSet;
	private  OnRecyclerItemClickListener onRecyclerItemClickListener;
	public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
		this.onRecyclerItemClickListener = onRecyclerItemClickListener;
	}

	public RecyclerAdapter(Context context,OnRecyclerItemClickListener onRecyclerItemClickListener) {
		mContext = context;
		mDataSet = new ArrayList<>();
		this.onRecyclerItemClickListener=onRecyclerItemClickListener;
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final View view = LayoutInflater.from(mContext).inflate(
				R.layout.item_recycler_child, parent, false);
		//这边可以做一些属性设置，甚至事件监听绑定
		//view.setBackgroundColor(Color.RED);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(onRecyclerItemClickListener!=null){
					onRecyclerItemClickListener.onItemClick(view, (int)view.getTag());
				}
			}
		});
		return new ChildViewHolder(view);
	}

	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		ChildViewHolder textViewHolder = (ChildViewHolder) holder;
		textViewHolder.bindView(mDataSet.get(position), position);
		holder.itemView.setTag(mDataSet.get(position).getId());

	}

	@Override
	public int getItemCount() {
		return mDataSet.size();
	}

	/**
	 * 从position开始删除，删除
	 * 
	 * @param position
	 * @param itemCount
	 *            删除的数目
	 */
	protected void removeAll(int position, int itemCount) {
		for (int i = 0; i < itemCount; i++) {
			mDataSet.remove(position);
		}
		notifyItemRangeRemoved(position, itemCount);
	}

	@Override
	public int getItemViewType(int position) {
		return 0;
	}

	public void add(Manual text, int position) {
		mDataSet.add(position, text);
		notifyItemInserted(position);
	}

	public void addAll(List list, int position) {
		mDataSet.addAll(position, list);
		notifyItemRangeInserted(position, list.size());
	}

	public void getTopic(List list) {
		mDataSet=new ArrayList<>();
		mDataSet.addAll(0, list);
		notifyDataSetChanged();
	}
	public interface OnRecyclerItemClickListener {
		/**
		 * item view 回调方法
		 * @param view  被点击的view
		 * @param position 点击索引
		 */
		void onItemClick(View view, int position);
	}

}
