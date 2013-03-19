package com.synvata.modules;

import org.json.JSONException;
import org.json.JSONObject;

import com.synvata.learning.AppSettings;
import com.synvata.learning.BaseHttpActivity;
import com.synvata.learning.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class CarRegistrationEditActivity extends BaseHttpActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modules_edit_carregistration_activity);
		Intent intent =this.getIntent();
		String data =intent.getStringExtra("data");
		try {
			JSONObject json = new JSONObject(data);
			initView(json);
		} catch (JSONException e) {
			log(e);
		}
		
		
	}
	private void initView(final JSONObject json){
		try {
			EditText t1 = ((EditText)findViewById(R.id.edt_carregistration_plate_no));
			String s1 =json.getString("plate_no"); 
			t1.setText(s1);
			((EditText)findViewById(R.id.edt_carregistration_engine_no  )).setText(json.getString("engine_no"));
			((EditText)findViewById(R.id.edt_carregistration_vin  )).setText(json.getString("vin"));
			((EditText)findViewById(R.id.edt_carregistration_registration_date  )).setText(json.getString("registration_date"));
			
			findViewById(R.id.btn_carregistration_save).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					save();
					
				}
				
			});
			
		} catch (Exception e) {
			log(e);
		}
	}
	private void save(){
		String url =String.format("api/add_car_registration?user_id=%d&car_id=%s&engine_no=%s&vin=%s&init_date=%s",
				AppSettings.userid,
				((EditText)findViewById(R.id.edt_carregistration_plate_no)).getText(),
				((EditText)findViewById(R.id.edt_carregistration_engine_no)).getText(),
				((EditText)findViewById(R.id.edt_carregistration_vin)).getText(),
				((EditText)findViewById(R.id.edt_carregistration_registration_date)).getText()
				);
		this.get(url, 2);
	}
	@Override
	public void processMessage(int msgType, final Object result) {
		
		super.processMessage(msgType, result);
		Bundle bundle =new Bundle();
		bundle.putString("result",result.toString());
		Intent intent = new Intent();
		intent.putExtras(bundle);
		setResult(RESULT_OK,intent);
		finish();
	}
}