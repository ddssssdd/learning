package com.synvata.modules;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.synvata.learning.AppSettings;
import com.synvata.learning.BaseHttpActivity;
import com.synvata.learning.R;

public class BusinessSuggestionActivity extends BaseHttpActivity {
	private JSONObject _result;
	private JSONArray _list;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modules_businesssuggestion_activity);
		this.get(AppSettings.url_get_suggestion_insurance(), 1);
	}
	@Override
	public void processMessage(int msgType, final Object result) {
		
		super.processMessage(msgType, result);
		try{
			if (this.isSuccess(result)){
				initData((JSONObject)result,msgType);
				this.runOnUiThread(
						new Runnable(){

							@Override
							public void run() {
								initView();
								
						
							}
					
						}
				);
			}
		}catch(Exception e){
			log(e);
		}
		
	}
	private void initData(JSONObject result,int msgType){
		try{
			_result = result.getJSONObject("result");
			_list = _result.getJSONArray("data");
		}catch(Exception e){
			log(e);
		}
	}
	private TextView addTextView(final String title){
		TextView tv = new TextView(this);
		tv.setText(title);
		return tv;
	}
	private void initView(){
		TableLayout table = (TableLayout)findViewById(R.id.table_modules_businesssuggestion_table);
		try{
			for(int i=0;i<_list.length();i++){
				JSONObject item = _list.getJSONObject(i);
				TableRow  tr= new TableRow(this);
				tr.addView(addTextView(item.getString("item")));
				tr.addView(addTextView(item.getString("field1")));
				tr.addView(addTextView(item.getString("field2")));
				
				table.addView(tr);
				
			}
		}catch(Exception e){
			log(e);
		}
		
	}
}
