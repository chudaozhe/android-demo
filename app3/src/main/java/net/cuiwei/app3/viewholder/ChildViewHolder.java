package net.cuiwei.app3.viewholder;

import android.view.View;
import android.widget.TextView;

import net.cuiwei.app3.bean.Manual;

import net.cuiwei.app3.R;


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

	public void bindView(Manual str, int position) {
		aid.setText(String.valueOf(str.getId()));
		name.setText(str.getName());
		args.setText(str.getArgs());
//		args.setText(str);
	}

}
