package com.synvata.service;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class ServicesListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		TextView mTextView = new TextView(this);
		ActivityManager mActivityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> mServiceList=mActivityManager.getRunningServices(30);
		mTextView.setText(this.getServiceClassName(mServiceList));
		setContentView(mTextView);
		
	}
	private boolean isServiceRunning(List<ActivityManager.RunningServiceInfo> mList,final String serviceName){
		for(int i=0;i<mList.size();i++){
			if (mList.get(i).service.getClassName().equals(serviceName)){
				return true;
			}
		}
		return false;
	}
	private String getServiceClassName(List<ActivityManager.RunningServiceInfo> mServiceList){
		String res="";
		for(int i=0;i<mServiceList.size();i++){
			res += mServiceList.get(i).service.getClassName()+" \n";
		}
		return res;
	}
}
