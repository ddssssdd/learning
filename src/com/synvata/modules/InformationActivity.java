package com.synvata.modules;


import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.synvata.learning.AppSettings;
import com.synvata.learning.R;


public class InformationActivity extends BaseListViewActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modules_information_activity);
		this.resource_listview_id = R.id.modules_information_listview;
		this.resource_listitem_id = R.layout.listviewitem_detail;
		this.get(AppSettings.url_for_get_news(), 1);
	}
	@Override
	protected void initData(Object result,int msgType){
		try{
			result = ((JSONObject)result).getJSONObject("result");
			JSONArray obj = ((JSONObject)result).getJSONArray("data");		
			this.initList(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	protected void initView(){
		ListView lv = (ListView)findViewById(R.id.modules_information_listview);
		MyAdapter adapter =new MyAdapter(InformationActivity.this);
		lv.setAdapter(adapter);
		
	}
	@Override
	protected void setupListItem(ViewHolder holder,Map<String,Object> info){
		holder.title.setText(info.get("title").toString());
		holder.detail.setText(info.get("description").toString());
		holder.action.setText(info.get("action").toString());
	}
	@Override
	protected void initListItem(ViewHolder holder,View convertView){
		holder.title = (TextView)convertView.findViewById(R.id.txt_listitem_detail_title);
		holder.detail = (TextView)convertView.findViewById(R.id.txt_listitem_detail_detail);
		holder.action = (TextView)convertView.findViewById(R.id.txt_listitem_detail_right);
		convertView.setTag(holder);
	}
	
}
