package com.synvata.learning;

import android.util.Log;

public final class AppTools {
	public static void log(Exception e){
		Log.e("Application Log", e.getMessage());
	}
}
