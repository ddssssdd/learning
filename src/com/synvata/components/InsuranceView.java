package com.synvata.components;

import org.json.JSONArray;
import org.json.JSONObject;

import com.synvata.learning.AppTools;
import com.synvata.learning.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class InsuranceView extends LinearLayout {
	private LayoutInflater mInflater = null;
	private Context mContext;
	public InsuranceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mInflater = LayoutInflater.from(context);
		mInflater.inflate(R.layout.partview_businessinsurance,this);
	}
	public void setData(final JSONObject data,final String title){
		try{
			((TextView)findViewById(R.id.txt_partview_business_title)).setText(title);
			((TextView)findViewById(R.id.txt_partview_business_companyname)).setText(data.getString("company"));
			((TextView)findViewById(R.id.txt_partview_business_insurance_no)).setText(data.getString("po"));
			((TextView)findViewById(R.id.txt_partview_business_date_to_date)).setText(data.getString("valid"));
			TableLayout tablelayout= (TableLayout)findViewById(R.id.table_partview_business_items);
			TableRow tr= new TableRow(mContext);
			tr.addView(createTextView("InsuName"));
			tr.addView(createTextView("Amount"));
			tr.addView(createTextView("Fee"));
			tr.addView(createTextView("DeductibleFee"));
			tr.setBackgroundResource(R.drawable.sign_input2);
			tablelayout.addView(tr);
			
			JSONArray list = data.getJSONArray("list");
			for(int i=0;i<list.length();i++){
				JSONObject item = list.getJSONObject(i);
				TableRow row= new TableRow(mContext);
				row.addView(createTextView(item.getString("InsuName")));
				row.addView(createTextView(item.getString("Amount")));
				row.addView(createTextView(item.getString("Fee")));
				row.addView(createTextView(item.getString("DeductibleFee")));
				tablelayout.addView(row);
				
			}
			
		}catch(Exception e){
			AppTools.log(e);
		}
	}
	private TextView createTextView(final String title){
		TextView tv = new TextView(mContext);
		tv.setText(title);
		return tv;
	}

}
