package com.synvata.learning;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.synvata.modules.TestView;
public class MainWithTableLayoutActivity extends Activity {
	private TableLayout tableLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tableLayout = (TableLayout)findViewById(R.id.tablelout_in_main);
		this.addTableRow("First Row");
		this.addTableRow("Second Row",R.color.yellow);
		//this.addTableRow("Third Row");
		Button button = (Button)findViewById(R.id.button_in_main_tablelayout);
		button.setOnClickListener(buttonClick);
		
	}
	private OnClickListener buttonClick = new OnClickListener(){

		@Override
		public void onClick(View v) {
			updateTableRows();
			
		}
		
	};
	private void updateTableRows(){
		int count =tableLayout.getChildCount();
		for(int i=0;i<count;i++){
			View v=tableLayout.getChildAt(i);
			if (v instanceof TableRow){
				TableRow tr =(TableRow)v;
				TestView tv = (TestView)tr.findViewWithTag(1);
				tv.setLableText("Updated!");
			}else{
				Log.d("TableLayout", v.toString());
			}
		}
	}
	private void addTableRow(final String rowTitle){
		this.addTableRow(rowTitle, R.color.gray01);
	}
	private void addTableRow(final String rowTitle,final int colorId){
		TableRow tr = new TableRow(this);
		tr.setBackgroundColor(this.getResources().getColor( colorId));
		TestView tv = new TestView(this,null);
		tv.setTag(1);
		tv.setLableText(rowTitle);
		tr.addView(tv);
		tableLayout.addView(tr);
	}

}
