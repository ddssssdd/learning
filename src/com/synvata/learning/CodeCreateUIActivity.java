package com.synvata.learning;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeCreateUIActivity extends Activity {
	private LinearLayout nameContainer;
	private LinearLayout addressContainer;
	private LinearLayout parentContainer;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		createNameContainter();
		createAddressContainer();
		createParentContainer();
		setContentView(parentContainer);
	}
	private void createParentContainer() {
		parentContainer = new LinearLayout(this);
		parentContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		parentContainer.setOrientation(LinearLayout.VERTICAL);
		parentContainer.addView(nameContainer);
		parentContainer.addView(addressContainer);
		
	}
	private void createAddressContainer() {
		addressContainer = new LinearLayout(this);
		addressContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		addressContainer.setOrientation(LinearLayout.VERTICAL);
		TextView addressLbl = new TextView(this);
		addressLbl.setText("Address:");
		
		TextView addressValue = new TextView(this);
		addressValue.setText("http://www.baidu.com");
		addressValue.setAutoLinkMask(Linkify.WEB_URLS);
		
		addressContainer.addView(addressLbl);
		addressContainer.addView(addressValue);
	}
	private void createNameContainter() {
		nameContainer = new LinearLayout(this);
		nameContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		nameContainer.setOrientation(LinearLayout.HORIZONTAL);
		TextView nameLbl =new TextView(this);
		nameLbl.setText("Name:");
		TextView nameValue = new TextView(this);
		nameValue.setText("John Doe");
		nameContainer.addView(nameLbl);
		nameContainer.addView(nameValue);
			
	}

}
