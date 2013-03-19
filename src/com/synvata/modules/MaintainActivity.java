package com.synvata.modules;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.synvata.learning.AppSettings;
import com.synvata.learning.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MaintainActivity extends BaseListViewActivity {
	private String _average_mileage;
	private String _pre_distance;
	private String _prev_date;
	private String _max_distance;
	private String _max_time;
	private String _current_date;
	private String _current_miles;
	private String _current_distance;
	private JSONObject _result;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moudles_maintain_activity);
		this.get(AppSettings.url_for_get_maintain_record(), 1);
	}
	@Override
	protected void initData(Object result, int msgType) {
		try{
			JSONObject obj = ((JSONObject)result).getJSONObject("result");
			_result = obj.getJSONObject("data");
			_average_mileage = _result.getString("average_mileage");
			_pre_distance = _result.getString("prev_distance");
			_prev_date = _result.getString("prev_date");
			_max_distance = _result.getString("max_distance");
			_max_time = _result.getString("max_time");
			_current_date = _result.getString("current_date");
			_current_miles = _result.getString("current_miles");
			_current_distance = _result.getString("current_distance");
		}catch(Exception e){
			log(e);
		}


	}

	@Override
	protected void initView() {
		((TextView)findViewById(R.id.txt_maintain_average_mileage)).setText(_average_mileage);
		((TextView)findViewById(R.id.txt_maintain_pre_distance)).setText(_pre_distance);
		((TextView)findViewById(R.id.txt_maintain_pre_date)).setText(_prev_date);
		((TextView)findViewById(R.id.txt_maintain_max_distance)).setText(_max_distance);
		((TextView)findViewById(R.id.txt_maintain_max_time)).setText(_max_time);
		((TextView)findViewById(R.id.txt_maintain_current_date)).setText(_current_date);
		((TextView)findViewById(R.id.txt_maintain_current_miles)).setText(_current_miles);
		((TextView)findViewById(R.id.txt_maintain_current_distance)).setText(_current_distance);
		((Button)findViewById(R.id.btn_modules_maintain_edit)).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent =new Intent(MaintainActivity.this,MaintainEditActivity.class);
				intent.putExtra("data", _result.toString());
				startActivityForResult(intent,0);
				
			}});
	}

	@Override
	protected void setupListItem(ViewHolder holder, Map<String, Object> info) {
		

	}
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==0 && resultCode==RESULT_OK){
			Bundle extras = data.getExtras();
			try {
				this.processMessage(1, new JSONObject(extras.getString("result")));
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
	}
}
