package com.synvata.thread;

import com.synvata.learning.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button _btnStart;
	private TextView _txtLog;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_main);
		_btnStart = (Button)findViewById(R.id.btnStart);
		_txtLog = (TextView)findViewById(R.id.txtLog);
		_btnStart.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				_txtLog.setText("Hello,this is a test");
				
			}});
	}
}
