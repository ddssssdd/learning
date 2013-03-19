package com.synvata.components;

import com.synvata.learning.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class VeryDetailItemView extends LinearLayout {
	private LayoutInflater mInflater = null;
	public VeryDetailItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mInflater = LayoutInflater.from(context);
		mInflater.inflate(R.layout.partview_businessinsurance,this);
	}
	public void setData(final String title,final String item1,final String item2,final String item3){
		
	}

}
