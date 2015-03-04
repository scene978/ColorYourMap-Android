package com.example.coloryourmap;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class BeforeTravelActivity extends Activity {
	ListView planList;
	BeforeTravelAdapter userAdapter;
	ArrayList<TravelPlan> planArray = new ArrayList<TravelPlan>();

	private String[] navItems;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bftravel);

		/**
		 * add item in arraylist
		 */
		planArray.add(new TravelPlan("2015 Summer Europe", "2015.07.14 - 2015.08.16"));
		planArray.add(new TravelPlan("2014 Winter Japan", "2014.01.01 - 2014.01.15"));

		/**
		 * set item into adapter
		 */
		userAdapter = new BeforeTravelAdapter(BeforeTravelActivity.this, R.layout.row_travelplan,
				planArray);
		planList = (ListView) findViewById(R.id.listView);
		planList.setItemsCanFocus(false);
		planList.setAdapter(userAdapter);

		/**
		 * get on item click listener
		 */
		planList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					final int position, long id) {
				Log.i("List View Clicked", "**********");
				Toast.makeText(BeforeTravelActivity.this,
						"List View Clicked:" + position, Toast.LENGTH_LONG)
						.show();
			}

		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_bftravel, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	//When press the add button the activity shows
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_addplan:
	            openAddnewplan();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	private void openAddnewplan() {
		Intent intent = new Intent(this, AddPlanActivity.class);
		startActivity(intent);
	}
	
	
}
