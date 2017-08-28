package com.why.project.activityjumpdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.why.project.activityjumpdemo.R;
import com.why.project.activityjumpdemo.utils.ActivityJump;

/**
 * Created by HaiyuKing
 * Used
 */

public class SecondActivity extends BaseActivity{

	private Button btn_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		initViews();
		initEvents();
	}

	private void initViews() {
		btn_back = (Button) findViewById(R.id.btn_back);
	}

	private void initEvents() {
		btn_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityJump.Back(SecondActivity.this);
			}
		});
	}
}
