package com.synvata.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.synvata.components.HomeMenuItem;
import com.synvata.learning.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

public class HomeActivity extends Activity {
	private TableLayout _tableLayout;
	private List<Menu> menus;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moudles_home_activity);
		setupMenu();
	}
	private void setupMenu(){
		_tableLayout = (TableLayout)findViewById(R.id.tablelout_in_home_activity);
		initMenuItems();
		fillMenu();
		
	}
	private void addTableRow(Menu menu){
		TableRow tr = new TableRow(this);
		HomeMenuItem item = new HomeMenuItem(this,null);
		item.setData(menu);
		tr.addView(item);
		_tableLayout.addView(tr);
	}
	private void fillMenu(){
		for(int i=0;i<menus.size();i++){
			Menu menu = menus.get(i);
			addTableRow(menu);
		}
	}
	
	private void initMenuItems(){
		menus = new ArrayList<Menu>();
		menus.add(new Menu("01","01",InformationActivity.class));
		menus.add(new Menu("02","02",HelpCallActivity.class));
		menus.add(new Menu("03","03",RescueActivity.class));
		menus.add(new Menu("04","04",MaintainActivity.class));
		menus.add(new Menu("05","05",DriverLicenseActivity.class));
		menus.add(new Menu("06","06",CarRegistrationActivity.class));
		menus.add(new Menu("07","07",TaxForCarShipActivity.class));
		menus.add(new Menu("08","08",CompulsoryInsuranceActivity.class));
		menus.add(new Menu("09","09",BusinessInsuranceActivity.class));
		
		menus.add(new Menu("10","10",null));
		menus.add(new Menu("11","11",null));
	}
	public class Menu{
		public String name;
		public String description;
		public String lastUpdate;
		public String key;
		public String phone;
		public String company;
		public Class activityClass;
		public Menu(final String n,final String k,Class aClass){
			this.name= n;
			this.key =k;
			this.activityClass = aClass;
		}
	}
}
