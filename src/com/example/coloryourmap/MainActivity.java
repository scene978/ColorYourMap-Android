package com.example.coloryourmap;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] navItems = { "여행 전", "여행 후", "설정" };
	private ListView menuList;
	private FrameLayout frContainer;
	private DrawerLayout dlDrawer;
	private ActionBarDrawerToggle dtToggle;

	ImageButton diaryButton, checkButton, bucketButton, moneyButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startActivity(new Intent(this, LogoSplash.class));

		setContentView(R.layout.activity_main);

		// navigation drawer
		// load slide menu items
		menuList = (ListView) findViewById(R.id.list_slidermenu);
		frContainer = (FrameLayout) findViewById(R.id.frame_container);

		menuList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, navItems));
		menuList.setOnItemClickListener(new DrawerItemClickListener());

		// open and close the menu
		dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		dtToggle = new ActionBarDrawerToggle(this, dlDrawer,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}

		};
		dlDrawer.setDrawerListener(dtToggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// button
		addButtonListener();
	}

	// DrawerItemClickListener
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		switch (position) {
		case 0:
			Intent intent1 = new Intent(this, BeforeTravelActivity.class);
			startActivity(intent1);
			finish();
			break;
		case 1:
			Intent intent2 = new Intent(this, AfterTravelActivity.class);
			startActivity(intent2);
			finish();
			break;
		case 2:
			Intent intent3 = new Intent(this, SettingsActivity.class);
			startActivity(intent3);
			finish();
			break;
		}
            // update selected item and title, then close the drawer
            menuList.setItemChecked(position, true);
            menuList.setSelection(position);
            setTitle(navItems[position]);
            dlDrawer.closeDrawer(menuList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		if (dtToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	// Toggle
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		dtToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		dtToggle.onConfigurationChanged(newConfig);
	}

	// button

	public void addButtonListener() {
		diaryButton = (ImageButton) findViewById(R.id.button_diary);
		checkButton = (ImageButton) findViewById(R.id.button_check);
		bucketButton = (ImageButton) findViewById(R.id.button_bucketlist);
		moneyButton = (ImageButton) findViewById(R.id.button_expenditure);

		diaryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Diary", Toast.LENGTH_SHORT)
						.show();

			}
		});

		checkButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Checklist!",
						Toast.LENGTH_SHORT).show();

			}
		});

		bucketButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Bucketlist!",
						Toast.LENGTH_SHORT).show();

			}
		});

		moneyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Expenditure!",
						Toast.LENGTH_SHORT).show();

			}
		});
	}

}
