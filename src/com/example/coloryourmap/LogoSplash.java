package com.example.coloryourmap;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class LogoSplash extends Activity {

	int splashSceneNumber;

	RelativeLayout splashLayout;

	Handler mHandler;

	boolean isClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_logo_splash);
		// ActionBar hide ������ ���ְ� ������ manifest���� Theme�� .NoActionBar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		// xml �ҽ� ����
		splashLayout = (RelativeLayout) findViewById(R.id.LogoSplash);
		
		// ó��ȭ�� 0
		splashSceneNumber = 0;

		// Ŭ�� �̺�Ʈ�� �־����� Ȯ��
		isClick = true;

		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (splashSceneNumber) {
				case 0:
					// �ι�° ȭ��
					splashSceneNumber = 1;

					splashLayout
							.setBackgroundResource(R.drawable.coloryourmap_logo);

					mHandler.sendEmptyMessage(splashSceneNumber);
					break;

				case 1:
					splashSceneNumber = 2;
					mHandler.sendEmptyMessageDelayed(splashSceneNumber, 2000);
					break;

				case 2:
					// ��Ƽ��Ƽ ����
					LogoSplash.this.finish();
					break;

				case 3:
					// �������̺�Ʈ Ŭ���� ������� �ٷ� 0 �̺�Ʈ�� ������..
					if (isClick && splashSceneNumber == 0) {
						splashSceneNumber = 0;
						mHandler.sendEmptyMessage(splashSceneNumber);
					}
					break;
				}
			}
		};
		mHandler.sendEmptyMessageDelayed(3, 2000);
	}

	public void hn_splashOnclick(View v) {

		switch (splashSceneNumber) {
		case 0:
			splashSceneNumber = 0;

			isClick = false;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;

		case 1:
			splashSceneNumber = 2;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;
		}
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
		return super.onOptionsItemSelected(item);
	}
}
