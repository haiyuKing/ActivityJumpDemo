package com.why.project.activityjumpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.why.project.activityjumpdemo.utils.ActivityJump;

/**
 * Created by HaiyuKing
 * Used Activity基类
 */

public class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ActivityJump.AddToTack(this);
		super.onCreate(savedInstanceState);
	}

	/*
	 */
	@Override
	protected void onStop() {
		super.onStop();

		ActivityJump.LogAllActivityNames();
	}

	/**截取返回软键事件*/
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			ActivityJump.Back(this);//防止内存泄漏

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
