package com.why.project.activityjumpdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * CreateBy HaiyuKing
 * Used 不同类型的界面跳转（普通跳转、带参数跳转、带返回值跳转）
 */
public class ActivityJump {

	/**
	 * 普通跳转，并将当前界面添加到栈中
	 * @param mContext - 当前界面
	 * @param cls - 要跳转到的界面
	 * */
	public static void NormalJump(Context mContext, Class<?> cls) {
		//如果当前activity是栈顶则不添加
		if (! ((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity((Activity)mContext);
		}
		Intent intent = new Intent(mContext, cls);
		mContext.startActivity(intent);
	}

	/**
	 * 普通跳转并销毁当前界面
	 * @param mContext - 当前界面
	 * @param cls - 要跳转到的界面
	 * */
	public static void NormalJumpAndFinish(Context mContext, Class<?> cls) {
		//如果当前activity是栈顶则不添加
		if (! ((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity((Activity)mContext);
		}
		
		Intent intent = new Intent(mContext, cls);
		mContext.startActivity(intent);

		Back(mContext);//防止内存泄漏
	}
	
	/**
	 * 带参跳转，并将当前界面添加到栈中
	 * */
	public static void BundleJump(Context mContext, Class<?> cls, Bundle bundle) {
		//如果当前activity是栈顶则不添加
		if (! ((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity((Activity) mContext);
		}
		Intent intent = new Intent(mContext, cls);
		intent.putExtras(bundle);
		mContext.startActivity(intent);
	}

	/**
	 * 带参跳转，并销毁当前界面
	 * */
	public static void BundleJumpAndFinish(Context mContext, Class<?> cls, Bundle bundle) {
		//如果当前activity是栈顶则不添加
		if (! ((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity((Activity) mContext);
		}
		Intent intent = new Intent(mContext, cls);
		intent.putExtras(bundle);
		mContext.startActivity(intent);

		Back(mContext);//防止内存泄漏
	}

	/**
	 * 不带参数的返回值跳转，并将当前界面添加到栈中*/
	public static void JumpForResult(Activity mActivity, Class<?> cls,int requestCode) {
		//如果当前activity是栈顶则不添加
		if (! (mActivity).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity(mActivity);
		}
		Intent intent = new Intent(mActivity, cls);
		mActivity.startActivityForResult(intent, requestCode);

	}

	/**
	 * 带参数和返回值跳转，并将当前界面添加到栈中*/
	public static void JumpForResult(Activity mActivity, Class<?> cls,Bundle bundle, int requestCode) {
		//如果当前activity是栈顶则不添加
		if (! (mActivity).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity(mActivity);
		}
		Intent intent = new Intent(mActivity, cls);
		intent.putExtras(bundle);
		mActivity.startActivityForResult(intent, requestCode);
	}

	/**
	 * 如果当前activity是栈顶则移除当前activity并finish，否则直接finish*/
	public static void Back(Context mContext) {
		if (((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().popActivity((Activity) mContext);
		} else {
			((Activity) mContext).finish();
		}
	}
	
	/**
	 * 从当前界面返回到指定的界面:并finish所有activity
	 * @param mContext - 当前界面
	 * @param cls - 要返回到的界面*/
	public static void BackToAppointActivity(Context mContext,Class<?> cls) {
		ActivityManager.getScreenManager().popAllActivity();//finish所有activity
		Intent intent = new Intent(mContext, cls);
		mContext.startActivity(intent);
		//因为当前界面还要使用，所以不会自动finish，使用后再finish
		((Activity) mContext).finish();
	}
	
	/**
	 * 从当前界面返回到指定下标值的界面
	 * @param mContext - 当前界面
	 * @param num - 返回到的界面的下标值*/
	public static void BackByStep(Context mContext, int num) {
		//如果当前activity是栈顶则不添加
		if (! ((Activity) mContext).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity((Activity) mContext);
		}
		ActivityManager.getScreenManager().popActivity(num);
	}
	
	/**打印栈里面的activity名称*/
	public static void LogAllActivityNames(){
		ActivityManager.getScreenManager().LogAllActivityNames();
	}
	
	/**手动添加到栈中*/
	public static void AddToTack(Activity mActivity){
		Log.i("ActivityJump", "mActivity="+mActivity.getClass().getName());
		//如果当前activity是栈顶则不添加
		if (! (mActivity).equals(ActivityManager.getScreenManager().topActivity())) {
			ActivityManager.getScreenManager().pushActivity(mActivity);
		}
	}

	/**销毁所有的Activity*/
	public static void finnishAllActivitys(){
		ActivityManager.getScreenManager().popAllActivity();
	}
	
}
