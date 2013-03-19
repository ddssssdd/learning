package com.synvata.service;

import java.util.Calendar;

import com.synvata.utils.DateUtils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class BackendService extends Service {
	private TestReceiver br;
	@Override
	public void onStart(Intent intent,int startId){
		super.onStart(intent, startId);
		
		this.startRepeatAlarm();
	}
	@Override
	public void onDestroy(){
		this.unregisterReceiver(br);
	}
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

	private void startRepeatAlarm(){
		IntentFilter filter = new IntentFilter("com.synvata.service.myReceiver");
		br = new TestReceiver();
		registerReceiver(br,filter);
		
		Calendar cal = DateUtils.getTimeAfterInSecs(10);
		String s = DateUtils.getDateTimeString(cal);
		
		String actionString = "com.synvata.service.myReceiver";
		Intent broadcastIntent = new Intent(actionString);
		
		broadcastIntent.putExtra("message", "hello, i come from Button press");
		broadcastIntent.addFlags(Intent.FLAG_FROM_BACKGROUND);
		PendingIntent pi = this.getDistinctPendingIntent(broadcastIntent, 2);
		AlarmManager am =(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
		am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30*60*1000, pi);
		
	}
	protected PendingIntent getDistinctPendingIntent(Intent intent,int requestId){
		PendingIntent pi = PendingIntent.getBroadcast(this, requestId, intent, 0);
		return pi;
	}
}
