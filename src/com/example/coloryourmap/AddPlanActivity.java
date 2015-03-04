package com.example.coloryourmap;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPlanActivity extends Activity {
	DatePicker datePicker1, datePicker2;
	ArrayList<String> list, list2;
	ArrayAdapter<String> adapter, adapter2;
	ArrayAdapter<CharSequence> adspin;
	ListView lvChecklist, lvBucketlist;
	InputMethodManager imm, imm2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_addplan);

		datePicker1 = (DatePicker) findViewById(R.id.datepicker_startdate);
		datePicker2 = (DatePicker) findViewById(R.id.datepicker_enddate);
		Button btn = (Button) findViewById(R.id.button_save);
		Button btnGo = (Button) findViewById(R.id.button_go);

		// start date date picker
		datePicker1.init(datePicker1.getYear(), datePicker1.getMonth(),
				datePicker1.getDayOfMonth(),
				new DatePicker.OnDateChangedListener() {

					@Override
					public void onDateChanged(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						// TODO Auto-generated method stub
						String msg = String.format("%d / %d / %d", year,
								monthOfYear + 1, dayOfMonth);
						Toast.makeText(AddPlanActivity.this, msg,
								Toast.LENGTH_SHORT).show();
					}
				});

		// end date date picker
		datePicker2.init(datePicker2.getYear(), datePicker2.getMonth(),
				datePicker2.getDayOfMonth(),
				new DatePicker.OnDateChangedListener() {

					@Override
					public void onDateChanged(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						// TODO Auto-generated method stub
						String msg = String.format("%d / %d / %d", year,
								monthOfYear + 1, dayOfMonth);
						Toast.makeText(AddPlanActivity.this, msg,
								Toast.LENGTH_SHORT).show();
					}
				});

		// checklist
		list = new ArrayList<String>();

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, list);

		lvChecklist = (ListView) findViewById(R.id.list_checklist_addplan);
		imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		lvChecklist.setAdapter(adapter);

		findViewById(R.id.btn_add_checklist).setOnClickListener(clickListener1);
		findViewById(R.id.btn_delete_checklist).setOnClickListener(
				clickListener1);

		// bucketlist
		list2 = new ArrayList<String>();

		adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, list2);

		lvBucketlist = (ListView) findViewById(R.id.list_bucketlist_addplan);
		imm2 = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		lvBucketlist.setAdapter(adapter2);

		findViewById(R.id.btn_add_bucketlist)
				.setOnClickListener(clickListener2);
		findViewById(R.id.btn_delete_bucketlist).setOnClickListener(
				clickListener2);

		// 국가 spinner
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setPrompt("시/도 를 선택하세요.");

		adspin = ArrayAdapter.createFromResource(this, R.array.country,
				android.R.layout.simple_spinner_item);

		adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adspin);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(AddPlanActivity.this,
						adspin.getItem(position) + "을 선택했습니다.", 1).show();
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// 저장버튼
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(AddPlanActivity.this, "Save!",
						Toast.LENGTH_SHORT).show();
			}
		});

		// GO 버튼
		btnGo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(AddPlanActivity.this, "Go!",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	// 체크리스트 추가 삭제
	private Button.OnClickListener clickListener1 = new Button.OnClickListener() {
		// private View.OnClickListener clickListener = new
		// View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText et = (EditText) findViewById(R.id.edit_checklist_addplan);
			if (v.getId() == R.id.btn_add_checklist) {
				// 추가 버튼
				if (et.getText().length() != 0) {
					list.add(et.getText().toString());
					et.setText("");
					// 갱신되었음을 어댑터에 통보한다.
					adapter.notifyDataSetChanged();
					imm.hideSoftInputFromWindow(et.getWindowToken(), 0);

				}
			} else if (v.getId() == R.id.btn_delete_checklist) {
				// 삭제 버튼
				// multi choice

				SparseBooleanArray sba = lvChecklist.getCheckedItemPositions();
				if (sba.size() != 0) {
					for (int i = lvChecklist.getCount() - 1; i >= 0; i--) {
						if (sba.get(i)) {
							list.remove(i);
						}
					}

					lvChecklist.clearChoices();
					adapter.notifyDataSetChanged();

				}
			}
		}
	};

	// 버킷리스트 추가 삭제
	private Button.OnClickListener clickListener2 = new Button.OnClickListener() {
		// private View.OnClickListener clickListener = new
		// View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText et = (EditText) findViewById(R.id.edit_bucketlist_addplan);
			if (v.getId() == R.id.btn_add_bucketlist) {
				// 추가 버튼
				if (et.getText().length() != 0) {
					list2.add(et.getText().toString());
					et.setText("");
					// 갱신되었음을 어댑터에 통보한다.
					adapter2.notifyDataSetChanged();
					imm2.hideSoftInputFromWindow(et.getWindowToken(), 0);

				}
			} else if (v.getId() == R.id.btn_delete_bucketlist) {
				// 삭제 버튼
				// multi choice

				SparseBooleanArray sba = lvBucketlist.getCheckedItemPositions();
				if (sba.size() != 0) {
					for (int i = lvBucketlist.getCount() - 1; i >= 0; i--) {
						if (sba.get(i)) {
							list2.remove(i);
						}
					}

					lvBucketlist.clearChoices();
					adapter2.notifyDataSetChanged();

				}
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
