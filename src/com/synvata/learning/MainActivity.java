package com.synvata.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.synvata.utils.*;
import com.synvata.modules.*;
import com.synvata.service.*;
public class MainActivity extends BaseHttpActivity {
	private List<Map<String,Object>>  mList;
	private TestReceiver br;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//setContentView(simpleList());
		setContentView(customList());
		//setContentView(customGridView());
		
		
		//this.get("admin/get_all?userid=0",1);
		
		//Log.e("Information", this.getOfflineResult(1));
		init_register();
	}
	private void init_register(){
		/*
		IntentFilter filter = new IntentFilter("com.synvata.service.myReceiver");
		br = new TestReceiver();
		registerReceiver(br,filter);
		*/
		Intent service = new Intent(this,BackendService.class);
		this.startService(service);
		
	}
	@Override
	protected void onDestroy(){
		//this.unregisterReceiver(br);
		super.onDestroy();
	}
//	private GridView customGridView(){
//		
//		List<Map<String,Object>> mList = new ArrayList<Map<String,Object>>();
//		for(int i=0;i<10;i++){
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("Pic", R.drawable.ic_launcher);
//			map.put("Title", "Test Title");
//			map.put("Content", "This is Content");
//			mList.add(map);
//		}
//		
//		SimpleAdapter adapter = new SimpleAdapter(this,
//													mList,
//													R.layout.gridview,
//													new String[]{"Pic","Title"},
//													new int[]{R.id.griditem_pic,R.id.griditem_title}
//													);
//		GridView listview = (GridView)findViewById(R.id.grid);
//		listView.setAdapter(adapter);
//		return listView;
//	}
	private void addItem(final String title,final String content,List<Map<String,Object>> mList,Class aClass){
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("Pic", R.drawable.ic_launcher);
		map.put("Pic", R.drawable.index_looks);
		map.put("Title", title);
		map.put("Content", content);
		map.put("classRef",aClass);
		mList.add(map);
	}
	private ListView customList(){
		ListView listView = new ListView(this);
		mList = new ArrayList<Map<String,Object>>();
		
		addItem("RelativeLayout","RelativeLayout test and Button",mList,RelativeLayoutTest.class);
		addItem("Prefs setup","Prefs setup view",mList,FlightPreference.class);
		addItem("Login","Login Window",mList,LoginActivity.class);
		addItem("BaseAdapter Test","Custom ListView by inherit from BaseAdapter",mList,ListViewByBaseAdapter.class);
		addItem("Dynamic create UI","Dynamic create ui components",mList,CodeCreateUIActivity.class);
		addItem("Weight and Gravity","Weight and Gravith in LinearLayout",mList,WeightAndGravityActivity.class);
		addItem("Handler","Main thread and use message",mList,com.synvata.thread.MainActivity.class);
		/*
		addItem("Informaiton","001",mList,InformationActivity.class);
		addItem("HelpCall","002",mList,HelpCallActivity.class);
		addItem("Rescue","003",mList,RescueActivity.class);
		addItem("Maintain","004",mList,MaintainActivity.class);
		addItem("DriverLicense","005",mList,DriverLicenseActivity.class);
		addItem("Car registration","006",mList,CarRegistrationActivity.class);
		addItem("Tax of car and ship","007",mList,TaxForCarShipActivity.class);
		addItem("Compulsory Insurance","008",mList,CompulsoryInsuranceActivity.class);
		addItem("Business Insurance","009",mList,BusinessInsuranceActivity.class);
		
		addItem("DriverLicense","005",mList,LoginActivity.class);
		addItem("Test broader and receiver","This is description for long lines",mList,SignupActivity.class);
		addItem("Service list","This is description for long lines",mList,ViolationSearchActivity.class);
		addItem("TableLayout main","dynamic add tablerow",mList,HomeActivity.class);
		*/
		SimpleAdapter adapter = new SimpleAdapter(this,
													mList,
													R.layout.listitem_2,//R.layout.listitem,
													new String[]{"Pic","Title","Content"},
													new int[]{R.id.listitem_pic,R.id.listitem_title,R.id.listitem_content}
													);
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Class aclass= (Class)mList.get(arg2).get("classRef");
				Intent intent=new Intent(MainActivity.this,aclass);
				startActivity(intent);
				
			}
			
		});
		return listView;
	}
	private ListView simpleList(){
		ListView listView = new ListView(this);
		List<Map<String,String>> mList = new ArrayList<Map<String,String>>();
		for(int i=0;i<10;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("Title", "Test Title");
			map.put("Content", "This is Content");
			mList.add(map);
		}
		/* Simple 1 line
		SimpleAdapter adapter = new SimpleAdapter(this,
													mList,
													android.R.layout.simple_list_item_1,
													new String[]{"Title"},
													new int[]{android.R.id.text1}
													);
		*/
		
		/* 2 lines
		SimpleAdapter adapter = new SimpleAdapter(this,
				mList,
				android.R.layout.simple_list_item_2,
				new String[]{"Title","Content"},
				new int[]{android.R.id.text1,android.R.id.text2}
				);
		*/
		SimpleAdapter adapter = new SimpleAdapter(this,
				mList,
				android.R.layout.simple_list_item_2,
				new String[]{"Title","Content"},
				new int[]{android.R.id.text1,android.R.id.text2}
				);
		listView.setAdapter(adapter);
		return listView;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
