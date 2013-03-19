package com.synvata.modules;

import com.synvata.learning.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.LinearLayout;
import android.widget.TextView;

public class TestView extends LinearLayout {
	private LayoutInflater mInflater = null;
	public TestView(Context context) {
		super(context);
		
	}
	public TestView(Context context, AttributeSet attrs) {
		super(context,attrs);
		mInflater = LayoutInflater.from(context);
		mInflater.inflate(R.layout.main,this);
		this.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				System.out.println("i am pressed");
				
			}});
	}
	public void setLableText(final String info){
		TextView tv = (TextView)findViewById(R.id.txt_main_info);
		tv.setText(info);
	}
	
}
