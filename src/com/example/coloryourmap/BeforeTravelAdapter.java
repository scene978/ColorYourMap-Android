package com.example.coloryourmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class BeforeTravelAdapter extends ArrayAdapter<TravelPlan> {
	Context context;
	int layoutResourceId;
	ArrayList<TravelPlan> data = new ArrayList<TravelPlan>();

	public BeforeTravelAdapter(Context context, int layoutResourceId,
			ArrayList<TravelPlan> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		UserHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new UserHolder();
			holder.textName = (TextView) row.findViewById(R.id.textView1);
			holder.textDate = (TextView) row.findViewById(R.id.textView2);
			row.setTag(holder);
		} else {
			holder = (UserHolder) row.getTag();
		}
		TravelPlan user = data.get(position);
		holder.textName.setText(user.getName());
		holder.textDate.setText(user.getDate());
		return row;

	}

	static class UserHolder {
		TextView textName;
		TextView textDate;
	}

}
