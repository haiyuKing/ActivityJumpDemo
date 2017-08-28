package com.why.project.activityjumpdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.why.project.activityjumpdemo.R;
import com.why.project.activityjumpdemo.utils.ActivityJump;

public class MainActivity extends BaseActivity {

	private Button btn_openActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews() {
		btn_openActivity = (Button) findViewById(R.id.btn_openActivity);
	}

	private void initEvents() {
		btn_openActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityJump.NormalJump(MainActivity.this,SecondActivity.class);
			}
		});
	}
}
