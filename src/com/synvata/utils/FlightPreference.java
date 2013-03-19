package com.synvata.utils;



import com.synvata.learning.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class FlightPreference extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.addPreferencesFromResource(R.xml.flightoptions);
	
	}
}
