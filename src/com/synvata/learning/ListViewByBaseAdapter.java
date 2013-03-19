package com.synvata.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewByBaseAdapter extends Activity {
	private ListView lv;
	private List<Map<String,Object>> data;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(getListView());
	}

	private View getListView() {
		data = getData();
		lv = new ListView(this);
		MyAdapter adapter = new MyAdapter(this);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), "ListView"+String.valueOf(position), Toast.LENGTH_LONG).show();
				
			}
			
		});
		return lv;
	}
	private List<Map<String,Object>> getData(){
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<10;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("title", "this is title");
			map.put("content", "This is happy content");
			list.add(map);
		}
		return list;
	}
	class ViewHolder{
		public ImageView image;
		public TextView title;
		public TextView info;
		public Button button;
	}
	public class MyAdapter extends BaseAdapter
	{
		private LayoutInflater mInflater = null;
		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		
		@Override
		public int getCount() {
			
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
			return position;
		}

		@Override
		public long getItemId(int position) {
			 //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView==null){
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.listitem, null);
				holder.image = (ImageView)convertView.findViewById(R.id.listitem_pic);
				holder.title = (TextView)convertView.findViewById(R.id.listitem_title);
				holder.info = (TextView)convertView.findViewById(R.id.listitem_content);
				holder.button = (Button)convertView.findViewById(R.id.listitem_button);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			holder.image.setBackgroundResource((Integer)data.get(position).get("image"));
			holder.title.setText((String)data.get(position).get("title"));
			holder.info.setText((String)data.get(position).get("content"));
			final int pos = position;
			final ViewHolder fholder = holder;
			holder.button.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					fholder.info.setText(String.valueOf(pos));
					Toast.makeText(ListViewByBaseAdapter.this, "haha"+String.valueOf(pos), Toast.LENGTH_LONG).show();
					
				}
				
			});
			holder.image.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					fholder.info.setText("Image"+String.valueOf(pos));
					
				}
				
			});
			return convertView;
		}
		
	}
}
