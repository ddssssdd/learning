package com.synvata.service;

import java.util.Calendar;

import com.synvata.learning.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.synvata.utils.DateUtils;
public class TestBC extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startRepeatAlarm();
		((Button)findViewById(R.id.btn_main_start)).setOnClickListener(start_button_press);
		((Button)findViewById(R.id.btn_main_end)).setOnClickListener(end_button_press);
	}
	private OnClickListener start_button_press = new OnClickListener(){

		@Override
		public void onClick(View v) {
			String actionString = "com.synvata.service.myReceiver";
			Intent broadcastIntent = new Intent(actionString);
			broadcastIntent.putExtra("message", "hello, i come from Button press");
			sendBroadcast(broadcastIntent);
			
		}
		
	};
	private OnClickListener end_button_press = new OnClickListener(){

		@Override
		public void onClick(View v) {
			String actionString = "com.synvata.service.myReceiver";
			Intent broadcastIntent = new Intent(actionString);
			broadcastIntent.putExtra("message", "clear");
			sendBroadcast(broadcastIntent);
			
		}
		
	};
	private void startRepeatAlarm(){
		Calendar cal = DateUtils.getTimeAfterInSecs(10);
		String s = DateUtils.getDateTimeString(cal);
		
		String actionString = "com.synvata.service.myReceiver";
		Intent broadcastIntent = new Intent(actionString);
		broadcastIntent.putExtra("message", "hello, i come from Button press");
		PendingIntent pi = this.getDistinctPendingIntent(broadcastIntent, 2);
		AlarmManager am =(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
		am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 10*1000, pi);
		
	}
	protected PendingIntent getDistinctPendingIntent(Intent intent,int requestId){
		PendingIntent pi = PendingIntent.getBroadcast(this, requestId, intent, 0);
		return pi;
	}

}
