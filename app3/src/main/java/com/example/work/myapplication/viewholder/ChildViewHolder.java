package com.example.work.myapplication.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.work.myapplication.ArticleBean;
import com.example.work.myapplication.R;


/**
 * @Author Zheng Haibo
 * @PersonalWebsite http://www.mobctrl.net
 * @Description
 */
public class ChildViewHolder extends BaseViewHolder {

	public TextView aid;
	public TextView name;
	public TextView args;

	public ChildViewHolder(View itemView) {
		super(itemView);

		aid = (TextView) itemView.findViewById(R.id.aid);
		name = (TextView) itemView.findViewById(R.id.name);
		args = (TextView) itemView.findViewById(R.id.args);
	}

	public void bindView(ArticleBean str, int position) {
		aid.setText(str.getId());
		name.setText(str.getName());
		args.setText(str.getArgs());
//		args.setText(str);
	}

}
