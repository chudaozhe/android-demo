package com.example.work.myapplication.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.work.myapplication.ArticleBean;
import com.example.work.myapplication.R;


/**
 * @Author Zheng Haibo
 * @PersonalWebsite http://www.mobctrl.net
 * @Description
 */
public class ChildViewHolder extends BaseViewHolder {

	public TextView text;
	public TextView desc;
	public ImageView image;

	public ChildViewHolder(View itemView) {
		super(itemView);
		text = (TextView) itemView.findViewById(R.id.text);
		desc = (TextView) itemView.findViewById(R.id.desc);
		image = (ImageView) itemView.findViewById(R.id.image);
	}

	public void bindView(String str, int position) {
		text.setText(str);
	}

}
