package com.synvata.utils;

import com.synvata.learning.BaseHttpActivity;
import com.synvata.learning.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Main extends BaseHttpActivity {
	private TextView tv = null;
	private Resources resources;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		resources = this.getResources();
		tv =(TextView)findViewById(R.id.textView1);
		setOptionText();
		
		Log.e("Information", this.getOfflineResult(1));
		this.get("admin/index_test?userid=0",1);
		
		
	}
	private void setOptionText() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String option = prefs.getString(resources.getString(R.string.selected_flight_sort_option), resources.getString(R.string.flight_sort_option_default_value));
		String[] optionText = resources.getStringArray(R.array.flight_sort_options);
		tv.setText("Options value is "+option+"("+optionText[Integer.parseInt(option)]+")");
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		Intent intent = new Intent().setClass(this, com.synvata.utils.FlightPreference.class);
		this.startActivityForResult(intent, 0);
		return true;
	}
	@Override
	public void onActivityResult(int reqCode,int resCode,Intent data){
		super.onActivityResult(reqCode, resCode, data);
		setOptionText();
	}
}
