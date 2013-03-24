package com.synvata.learning;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class TabTestActivity extends TabActivity {
	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_activity);
		tabHost = getTabHost();
//		tabHost.addTab(tabHost.newTabSpec("Test one").setIndicator("",getResources().getDrawable(android.R.drawable.ic_menu_call)).setContent(R.id.tabFirst));
//		tabHost.addTab(tabHost.newTabSpec("Test two").setIndicator("",getResources().getDrawable(android.R.drawable.ic_menu_camera)).setContent(R.id.tabSecond));
//		tabHost.addTab(tabHost.newTabSpec("Test one").setIndicator("a").setContent(R.id.tabFirst));
//		tabHost.addTab(tabHost.newTabSpec("Test two").setIndicator("b").setContent(R.id.tabSecond));
//		tabHost.addTab(tabHost.newTabSpec("Test three").setIndicator("c").setContent(R.id.tabSecond));
		tabHost.addTab(tabHost.newTabSpec("Test one").setIndicator("a",getResources().getDrawable(android.R.drawable.ic_menu_call)).setContent(R.id.tabFirst));
		tabHost.addTab(tabHost.newTabSpec("Test two").setIndicator("b",getResources().getDrawable(android.R.drawable.ic_menu_recent_history)).setContent(R.id.tabSecond));
		tabHost.addTab(tabHost.newTabSpec("Test three").setIndicator("c",getResources().getDrawable(android.R.drawable.ic_menu_gallery)).setContent(R.id.tabSecond));
		//����TabHost�ı�����ɫ
		tabHost.setBackgroundColor(Color.argb(150,22,70,150));
		//����TabHost�ı���ͼƬ��Դ
//		tabHost.setBackgroundResource(R.drawable.bg);
		//���õ�ǰ��ʵ��һ����ǩ
		tabHost.setCurrentTab(0);   //0Ϊ��ǩID
		//��ǩ�л�������setOnTabChangedListener	
		tabHost.setOnTabChangedListener(new OnTabChangeListener(){
			public void onTabChanged(String tabId){
				Toast.makeText(TabTestActivity.this, "This is a Test!", Toast.LENGTH_LONG).show();
			}
		});
	}
}

