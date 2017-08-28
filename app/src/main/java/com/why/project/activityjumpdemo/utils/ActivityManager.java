package com.why.project.activityjumpdemo.utils;

import android.app.Activity;
import android.util.Log;
import java.util.Stack;

/**
 * CreateBy HaiyuKing
 * Used activity集合，用于保存打开的activity【栈——先进后出】
 */
public class ActivityManager {
	
	// 栈
	private static Stack<Activity> activityStack;
	
	private static ActivityManager managerInstance;
	/**
	 * 获得管理器
	 * */
	public static ActivityManager getScreenManager() {
		if (managerInstance == null) {
			managerInstance = new ActivityManager();
		}
		return managerInstance;
	}
	
	/**
	 * 增加一个Activity
	 * */
	public void pushActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}
	
	/**
	 * 弹出栈顶的activity（也就是最后添加进去的activity）并finish
	 * */
	public void popActivity() {
		Activity activity = activityStack.lastElement();
		if (activity != null) {
			activity.finish();
			activity = null;
		}
	}
	
	/**
	 * 弹出指定的activity并finish
	 * */
	public void popActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
			activityStack.remove(activity);
			activity = null;
		}
	}
	/**
	 * 获得栈顶的activity，也就是当前界面的上一个界面*/
	public Activity topActivity() {
		if (activityStack == null || activityStack.size() == 0) {
			return null;
		}
		Activity activity = activityStack.lastElement();
		
		return activity;
	}
	
	/**弹出所有的activity并finish*/
	public void popAllActivity() {
		while (true) {
			Activity activity = topActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
		}
	}
	/**弹出除去指定的activity以外所有的activity并finish*/
	public void popAllActivityExceptOne(Class<?> cls) {
		while (true) {
			Activity activity = topActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(cls)) {
				break;
			}
			popActivity(activity);
		}
	}
	/**弹出后加入的n个activity并finish*/
	public void popActivity(int num) {
		for (int i = 0; i < num; i++) {
			Activity activity = topActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
		}
	}
	
	/**打印栈里面的activity名称*/
	public void LogAllActivityNames(){
		if(activityStack != null && activityStack.size() > 0){
			for(int i=0;i<activityStack.size();i++){
				Activity activity = activityStack.get(i);
				Log.v("ActivityManager", i + "::" + activity.getClass().getSimpleName());
			}
		}
	}
	
	/**
	 *  获取栈顶的context
	 *  */
	/*public static Class<?> getCurrentClass(Context context) {
		android.app.ActivityManager am = (android.app.ActivityManager) context
				.getSystemService(Activity.ACTIVITY_SERVICE);
		List<android.app.ActivityManager.RunningTaskInfo> taskInfo = am
				.getRunningTasks(1);
		ComponentName componentName = taskInfo.get(0).topActivity;

		return componentName.getClass();
	}*/
	
}
