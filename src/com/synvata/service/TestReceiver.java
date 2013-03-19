package com.synvata.service;

import com.synvata.learning.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.synvata.learning.MainActivity;
public class TestReceiver extends BroadcastReceiver {
	private static final int NOTIFICATION_ID = 0;
	private Context context;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		Toast.makeText(arg0, "i am running", Toast.LENGTH_LONG).show();
		this.context = arg0;
		Log.d("TestReceiver","intent="+arg1);
		String message = arg1.getStringExtra("message");
		Log.d("TestReceiver",message);
		if (message.equals("clear")){
			this.deleteNotification();
		}else{
			this.showNotification();
		}
	}
	 private void deleteNotification() {  
	        NotificationManager notificationManager = (NotificationManager) context.getSystemService(android.content.Context.NOTIFICATION_SERVICE);  
	        notificationManager.cancel(NOTIFICATION_ID);  
	    }  
	private void showNotification() {  
        Notification notification = new Notification(R.drawable.ic_launcher, "title", System.currentTimeMillis());  
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);  
        notification.setLatestEventInfo(context, "title", "information", contentIntent);  
          
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(  
                android.content.Context.NOTIFICATION_SERVICE);  
        notificationManager.notify(NOTIFICATION_ID, notification);  
    }  

}
