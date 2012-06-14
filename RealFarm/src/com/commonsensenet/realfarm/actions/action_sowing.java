package com.commonsensenet.realfarm.actions;

import com.commonsensenet.realfarm.Global;
import com.commonsensenet.realfarm.R;
import com.commonsensenet.realfarm.Settings;
import com.commonsensenet.realfarm.WF_details;
import com.commonsensenet.realfarm.admincall;
import com.commonsensenet.realfarm.control.NumberPicker;
import com.commonsensenet.realfarm.dataaccess.RealFarmProvider;
import com.commonsensenet.realfarm.homescreen.HelpEnabledActivity;
import com.commonsensenet.realfarm.homescreen.Homescreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class action_sowing extends HelpEnabledActivity {
	//MediaPlayer mp = null;                  //Integration
	 protected RealFarmProvider mDataProvider;
	   private Context context=this;
	String treatment_sow="0", days_sel_sow="0", units_sow="0",seed_sow="0";
	int sow_no;
	String sow_no_sel;
	 public void onBackPressed() {
			
		 if(mp != null)
			{
				mp.stop();
			mp.release();
				mp = null;
			}
	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
						mDataProvider.File_Log_Create("UIlog.txt","***** user has clicked soft key BACK in Spraying page*********** \r\n");
					
						}
		 
			Intent adminintent = new Intent(action_sowing.this,Homescreen.class);
			        
			      startActivity(adminintent);                        
			      action_sowing.this.finish();
}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	System.out.println("Plant details entered");
     	mDataProvider = RealFarmProvider.getInstance(context);
    	        super.onCreate(savedInstanceState);
    	        setContentView(R.layout.sowing_dialog);
    	    	System.out.println("plant done");
    	    	final TextView day_sow = (TextView) findViewById(R.id.dlg_lbl_day_sow);	    	
    	    	day_sow.setText("Today");
    	    	days_sel_sow="Today";
    	    	if(mp != null)
    			{
    				mp.stop();
    				mp.release();
    				mp = null;
    			}
    			mp = MediaPlayer.create(this, R.raw.thankyouclickingactionsowing);
    			mp.start();
    			
    			
				if(Global.WriteToSD==true)
				{
					
				String	logtime=getcurrenttime();
				mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
				mDataProvider.File_Log_Create("UIlog.txt","***** In Action Sowing*********** \r\n");
			
				}
    			
    final Button item1;
    final Button item2;
    final Button item3;
    final Button item4;
    final Button item5;
    ImageButton home;
    ImageButton help;
    item1 = (Button) findViewById(R.id.home_btn_var_sow);
    item2 = (Button) findViewById(R.id.home_btn_units_sow);
    item3 = (Button) findViewById(R.id.home_btn_day_sow);
    item4 = (Button) findViewById(R.id.home_btn_treat_sow);
    item5 = (Button) findViewById(R.id.home_btn_units_no_sow);
    home = (ImageButton) findViewById(R.id.aggr_img_home);
    help = (ImageButton) findViewById(R.id.aggr_img_help);
    
    item1.setOnLongClickListener(this);                                       //Integration
    item2.setOnLongClickListener(this);
    item3.setOnLongClickListener(this);
    item4.setOnLongClickListener(this);
    item5.setOnLongClickListener(this);
    help.setOnLongClickListener(this);
    

	item1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				stopaudio() ;
				Log.d("in variety sowing dialog", "in dialog");
				final Dialog dlg = new Dialog(v.getContext());
		    	dlg.setContentView(R.layout.variety_sowing_dialog);
		    	dlg.setCancelable(true);
		        dlg.setTitle("Choose the Variety of seed sowed");
		    	Log.d("in variety sowing dialog", "in dialog");
		    	dlg.show();
		    	if(Global.WriteToSD==true)
				{
					
				String	logtime=getcurrenttime();
				mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
				mDataProvider.File_Log_Create("UIlog.txt","***** In selection of variety of seed sowed in  Sowing*********** \r\n");
			
				}
		    	final Button variety1;
		    	final Button variety2;
		    	final Button variety3;
		    	final Button variety4;
		    	final Button variety5;
		    	final Button variety6;
	//	    	final Button variety7;
		    	final ImageView img_1;
		    	img_1 = (ImageView) findViewById(R.id.dlg_var_sow);
		    	
		    	final TextView var_text = (TextView) findViewById(R.id.dlg_var_text_sow);
		    	variety1 = (Button) dlg.findViewById(R.id.home_btn_var_sow_1);
		    	variety2 = (Button) dlg.findViewById(R.id.home_btn_var_sow_2);
		    	variety3 = (Button) dlg.findViewById(R.id.home_btn_var_sow_3);
		    	variety4 = (Button) dlg.findViewById(R.id.home_btn_var_sow_4);
		    	variety5 = (Button) dlg.findViewById(R.id.home_btn_var_sow_5);
		    	variety6 = (Button) dlg.findViewById(R.id.home_btn_var_sow_6);
		    	
		    	variety1.setOnClickListener(new View.OnClickListener() {
		    			public void onClick(View v) {
		    				Log.d("var 1 picked ", "in dialog");
		    				//img_1.setMaxWidth(300);
		    				img_1.setImageResource(R.drawable.pic_90px_bajra_tiled);
		    				var_text.setText("Bajra");
		    				seed_sow="Bajra";
		    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
		  	    	      	
		  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
		  	    	    	if(Global.WriteToSD==true)
							{
								
							String	logtime=getcurrenttime();
							mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
						
							mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
							
						
							}
		    				//item1.setBackgroundResource(R.drawable.pic_90px_bajra_tiled);
		    				dlg.cancel();                      
		    				}
		     	});
		     	
		    	variety2.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 2 picked ", "in dialog");   
	    				img_1.setImageResource(R.drawable.pic_90px_castor_tiled);
	    				var_text.setText("Castor");
	    				seed_sow="Castor";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
		    	
		    	variety3.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 3 picked ", "in dialog");  
	    				img_1.setImageResource(R.drawable.pic_90px_cowpea_tiled);
	    				var_text.setText("Cowpea");
	    				seed_sow="Cowpea";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
						
					
						}

	    				dlg.cancel();                      
	    				}
	     	});
		    	
		    	variety4.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 3 picked ", "in dialog");  
	    				img_1.setImageResource(R.drawable.pic_90px_greengram_tiled);
	    				var_text.setText("Greengram");
	    				seed_sow="Greengram";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
		    	variety5.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 3 picked ", "in dialog");  
	    				img_1.setImageResource(R.drawable.pic_90px_groundnut_tiled);
	    				var_text.setText("Groundnut");
	    				seed_sow="Groundnut";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
		    	variety6.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 3 picked ", "in dialog");  
	    				img_1.setImageResource(R.drawable.pic_90px_horsegram_tiled);
	    				var_text.setText("Horsegram");
	    				seed_sow="Horsegram";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ seed_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
			
			}
		});
    
	item2.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			stopaudio() ;
			Log.d("in units sow dialog", "in dialog");
			final Dialog dlg = new Dialog(v.getContext());
	    	dlg.setContentView(R.layout.units_dialog);
	    	dlg.setCancelable(true);
	        dlg.setTitle("Choose the units");
	    	Log.d("in units sow dialog", "in dialog");
	    	dlg.show();

	    	
	    	final Button unit1;
	    	final Button unit2;
	    	final Button unit3;
	    	
	    	final ImageView img_1;
	    	img_1 = (ImageView) findViewById(R.id.dlg_unit_sow);
	    	
	    	final TextView var_text = (TextView) findViewById(R.id.dlg_lbl_unit_sow);
	    	unit1 = (Button) dlg.findViewById(R.id.home_btn_units_1);
	    	unit2 = (Button) dlg.findViewById(R.id.home_btn_units_2);
	    	unit3 = (Button) dlg.findViewById(R.id.home_btn_units_3);
	    	if(Global.WriteToSD==true)
			{
				
			String	logtime=getcurrenttime();
			mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
		
			mDataProvider.File_Log_Create("UIlog.txt","***** In selection of units for Sowing*********** \r\n");
			
		
			}
	    	
	    	unit1.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 1 picked ", "in dialog");
	    				//img_1.setMaxWidth(300);
	    			//	img_1.setImageResource(R.drawable.pic_90px_bajra_tiled);
	    				var_text.setText("Bag of 10 Kgs");
	    				units_sow="Bag of 10 Kgs";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	    				//item1.setBackgroundResource(R.drawable.pic_90px_bajra_tiled);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ units_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
	     	
	    	unit2.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 2 picked ", "in dialog");   
    			//	img_1.setImageResource(R.drawable.pic_90px_castor_tiled);
    				var_text.setText("Bag of 20 Kgs");
    				units_sow="Bag of 20 Kgs";
    				  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
  	    	      	
  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
  	    	      if(Global.WriteToSD==true)
					{
						
					String	logtime=getcurrenttime();
					mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
				
					mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ units_sow + " for Sowing*********** \r\n");
					
				
					}
    				dlg.cancel();                      
    				}
     	});
	    	
	    	unit3.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 3 picked ", "in dialog");  
    				//img_1.setImageResource(R.drawable.pic_90px_cowpea_tiled);
    				var_text.setText("Bag of 50 Kgs");
    				units_sow="Bag of 50 Kgs";
    				  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
  	    	      	
  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
  	    	      if(Global.WriteToSD==true)
					{
						
					String	logtime=getcurrenttime();
					mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
				
					mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ units_sow + " for Sowing*********** \r\n");
					
				
					}
    				dlg.cancel();                      
    				}
     	});
		
		}
	});
	
	
	item3.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			stopaudio() ;
			Log.d("in day sowing dialog", "in dialog");
			final Dialog dlg = new Dialog(v.getContext());
	    	dlg.setContentView(R.layout.days_dialog);
	    	dlg.setCancelable(true);
	        dlg.setTitle("Choose the day");
	    	Log.d("in day sowing dialog", "in dialog");
	    	dlg.show();

	    	   if(Global.WriteToSD==true)
				{
					
				String	logtime=getcurrenttime();
				mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
			
				mDataProvider.File_Log_Create("UIlog.txt","***** In selection of day for Sowing*********** \r\n");
				
			
				}
	    	
	    	final Button day1;
	    	final Button day2;
	    	final Button day3;
	    	final Button day4;
	    	final Button day5;
	    		    	
	    	final ImageView img_1;
	    	img_1 = (ImageView) findViewById(R.id.dlg_unit_sow);
	    	
	    	
	    	day1 = (Button) dlg.findViewById(R.id.home_day_1);
	    	day2 = (Button) dlg.findViewById(R.id.home_day_2);
	    	day3 = (Button) dlg.findViewById(R.id.home_day_3);
	    	day4 = (Button) dlg.findViewById(R.id.home_day_4);
	    	day5 = (Button) dlg.findViewById(R.id.home_day_5);
	    	
	    	day1.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 1 picked ", "in dialog");
	    				//img_1.setMaxWidth(300);
	    			//	img_1.setImageResource(R.drawable.pic_90px_bajra_tiled);
	    				day_sow.setText("Two week before");
	    				days_sel_sow="Two week before";
	    				//item1.setBackgroundResource(R.drawable.pic_90px_bajra_tiled);
	    				   if(Global.WriteToSD==true)
							{
								
							String	logtime=getcurrenttime();
							mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
						
							mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ days_sel_sow + " for Sowing*********** \r\n");
							
						
							}
	    				dlg.cancel();                      
	    				}
	     	});
	     	
	    	day2.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 2 picked ", "in dialog");   
    			//	img_1.setImageResource(R.drawable.pic_90px_castor_tiled);
    				day_sow.setText("One week before");
    				days_sel_sow="One week before";
    				  if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ days_sel_sow + " for Sowing*********** \r\n");
						
					
						}
    				dlg.cancel();                      
    				}
     	});
	    	
	    	day3.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 3 picked ", "in dialog");  
    				//img_1.setImageResource(R.drawable.pic_90px_cowpea_tiled);
    				day_sow.setText("Yesterday");
    				days_sel_sow="Yesterday";
    				  if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ days_sel_sow + " for Sowing*********** \r\n");
						
					
						}
    				dlg.cancel();                      
    				}
     	});
	    	day4.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 3 picked ", "in dialog");  
    				//img_1.setImageResource(R.drawable.pic_90px_cowpea_tiled);
    				day_sow.setText("Today");
    				days_sel_sow="Today";
    				  if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ days_sel_sow + " for Sowing*********** \r\n");
						
					
						}
    				dlg.cancel();                      
    				}
     	});
	    	day5.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 3 picked ", "in dialog");  
    				//img_1.setImageResource(R.drawable.pic_90px_cowpea_tiled);
    				day_sow.setText("Tomorrow");
    				days_sel_sow="Tomorrow";
    				  if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ days_sel_sow + " for Sowing*********** \r\n");
						
					
						}
    				dlg.cancel();                      
    				}
     	});
		
		}
	});
	
	
	
	item4.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			stopaudio() ;
			Log.d("in treat sow dialog", "in dialog");
			final Dialog dlg = new Dialog(v.getContext());
	    	dlg.setContentView(R.layout.treat_sow_dialog);
	    	dlg.setCancelable(true);
	        dlg.setTitle("Select weather you have treated the seeds");
	    	Log.d("in treat sow dialog", "in dialog");
	    	dlg.show();

	    	  if(Global.WriteToSD==true)
				{
					
				String	logtime=getcurrenttime();
				mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
			
				mDataProvider.File_Log_Create("UIlog.txt","***** In selection of treatment to seeds for Sowing*********** \r\n");
				
			
				}
	    	
	    	final Button treat1;
	    	final Button treat2;
	   
	    	
	    	final ImageView img_1;
	    	img_1 = (ImageView) findViewById(R.id.dlg_unit_sow);
	    	
	    	final TextView var_text = (TextView) findViewById(R.id.dlg_lbl_treat_sow);
	    	treat1 = (Button) dlg.findViewById(R.id.home_treat_sow_1);
	    	treat2 = (Button) dlg.findViewById(R.id.home_treat_sow_2);
	    	
	    	
	    	
	    	treat1.setOnClickListener(new View.OnClickListener() {
	    			public void onClick(View v) {
	    				Log.d("var 1 picked ", "in dialog");
	    				//img_1.setMaxWidth(300);
	    			//	img_1.setImageResource(R.drawable.pic_90px_bajra_tiled);
	    				var_text.setText("Treated");
	    				treatment_sow="treated";
	    				  TableRow tr_feedback = (TableRow) findViewById(R.id.treatment_sow_tr);
	  	    	      	
	  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	    				//item1.setBackgroundResource(R.drawable.pic_90px_bajra_tiled);
	  	    	      if(Global.WriteToSD==true)
						{
							
						String	logtime=getcurrenttime();
						mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
					
						mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ treatment_sow + " for Sowing*********** \r\n");
						
					
						}
	    				dlg.cancel();                      
	    				}
	     	});
	     	
	    	treat2.setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v) {
    				Log.d("var 2 picked ", "in dialog");   
    			//	img_1.setImageResource(R.drawable.pic_90px_castor_tiled);
    				var_text.setText("May not Treat");
    				treatment_sow="may not treat";
    				  TableRow tr_feedback = (TableRow) findViewById(R.id.treatment_sow_tr);
  	    	      	
  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
  	    	      if(Global.WriteToSD==true)
					{
						
					String	logtime=getcurrenttime();
					mDataProvider.File_Log_Create("UIlog.txt",logtime+" -> ");
				
					mDataProvider.File_Log_Create("UIlog.txt","***** user selected"+ treatment_sow + " for Sowing*********** \r\n");
					
				
					}
    				dlg.cancel();                      
    				}
     	});
	    	
	    
		
		}
	});
	
	
	final TextView no_text = (TextView) findViewById(R.id.dlg_lbl_unit_no_sow); 
	   
	item5.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			stopaudio() ;
			Log.d("in variety sowing dialog", "in dialog");
			final Dialog dlg = new Dialog(v.getContext());
	    	dlg.setContentView(R.layout.numberentry_dialog);
	    	dlg.setCancelable(true);
	        dlg.setTitle("Choose the Number of bags");
	    	Log.d("in variety sowing dialog", "in dialog");
	    	dlg.show();
	    	
	    	  Button no_ok=(Button) dlg.findViewById(R.id.number_ok);
	   	   Button no_cancel=(Button) dlg.findViewById(R.id.number_cancel);
	   	no_ok.setOnClickListener(new View.OnClickListener() {
		    	public void onClick(View v) {
		    		
		    		  NumberPicker mynp1 = (NumberPicker) dlg.findViewById(R.id.numberpick);
		    		    sow_no = mynp1.getValue();
		    		    sow_no_sel= String.valueOf(sow_no);
		    		    no_text.setText(sow_no_sel);
		    		    if(sow_no !=0)
		    		    {
		    		    	 
		    		    	  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
		  	    	      	
		  	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
		    		    	
		    		    }
		    		    
		    		    dlg.cancel(); 
		    	}
	   	 });
	   	no_cancel.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
	    		dlg.cancel(); 	
	    	}
	    	});
	   	
	   
	   	   
		}
	});
	
	final CheckBox intercrop = (CheckBox) findViewById(R.id.chkintercrop);
	 
	intercrop.setOnClickListener(new OnClickListener() {
 	
	  public void onClick(View v) {
                //is chkIos checked?
		if (((CheckBox) v).isChecked()) {
			Toast.makeText(action_sowing.this,
		 	   "Intercrop is selected :)", Toast.LENGTH_LONG).show();
		}
 
	  }
	});
	

	   Button btnNext=(Button) findViewById(R.id.sow_ok);  
	   Button cancel=(Button) findViewById(R.id.sow_cancel);  
	   
	   btnNext.setOnLongClickListener(this);                                       //Integration
	   cancel.setOnLongClickListener(this); 
	   
	   cancel.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
               cancelaudio();
	    	}
	   
	    	});
	   
	    btnNext.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
	    		
	    		
	    		
	    	//	 Toast.makeText(action_sowing.this, "User enetred " + sow_no_sel + "kgs", Toast.LENGTH_LONG).show();
	    		 int flag1, flag2,flag3;
	    		 if(seed_sow.toString().equalsIgnoreCase("0") )
	    		    {
	    			 flag1 =1;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img_not);
	    			 
	    			 
	    		    }
	    		 else
	    		 {
	    			 flag1 =0;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.seed_type_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	    		 }
	    		
	    		 if(units_sow.toString().equalsIgnoreCase("0") ||  sow_no == 0)
	    		    {
	    		    
	    			 flag2 =1;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img_not);
	    		    }
	    		 else
	    		 {
	    			 
	    			 flag2 =0;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.units_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	    		 }
	    		 
	    		 if(treatment_sow.toString().equalsIgnoreCase("0"))
	    		    {
	    		    
	    			 flag3 =1;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.treatment_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img_not);
	    		    }
	    		 else
	    		 {
	    			 
	    			 flag3 =0;
	    	    	  
	    	    	  TableRow tr_feedback = (TableRow) findViewById(R.id.treatment_sow_tr);
	    	      	
	    	      	tr_feedback.setBackgroundResource(R.drawable.def_img);
	    		 }
	    		 
	    		 
	    		 
	    		 
	    		 if(flag1 ==0 && flag2 ==0 && flag3 ==0) 
	    		    {   	 
	    			 System.out.println("sowing writing");
	    				mDataProvider.setSowing(sow_no, seed_sow, units_sow, days_sel_sow, treatment_sow,
	    						0, 0);

	    				System.out.println("sowing reading");
	    				mDataProvider.getsowing();
	    			
	    		    	 Intent adminintent = new Intent(action_sowing.this,Homescreen.class);
	    			      startActivity(adminintent);                        
	    			      action_sowing.this.finish();
	    			      okaudio();	
	 	    			 
	    		    }
	    		 else
	    			 initmissingval();
	    		 
	    		 
	    	}
	    });
 
	    home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent adminintent = new Intent(action_sowing.this,Homescreen.class);
		        
			      startActivity(adminintent);                        
			      action_sowing.this.finish();
				                    
				}
 	});
    
	   
	
   
    }

	@Override
	protected void initKannada() {
		// TODO Auto-generated method stub
		
	}
	
	protected void cancelaudio() {
		// TODO Auto-generated method stub
		if(mp != null)
		{
			mp.stop();
			mp.release();
			mp = null;
		}
		mp = MediaPlayer.create(this, R.raw.cancel);
		mp.start();
		Intent adminintent = new Intent(action_sowing.this,Homescreen.class);
        
	      startActivity(adminintent);                        
	      action_sowing.this.finish();
	}
	protected void okaudio() {
		// TODO Auto-generated method stub
		if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
			mp = MediaPlayer.create(this, R.raw.ok);
			mp.start();
		
	    	 
		
	}
	
	protected void stopaudio() {
		// TODO Auto-generated method stub
		if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
	}
	
	protected void initmissingval() {
		// TODO Auto-generated method stub
		if(mp != null)
		{
			mp.stop();
			mp.release();
			mp = null;
		}
		mp = MediaPlayer.create(this, R.raw.missinginfo);
		mp.start();
	}
	
    
	@Override
	public boolean onLongClick(View v) {                      //latest
	
		if( v.getId() == R.id.home_btn_var_sow){
			
			if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
			mp = MediaPlayer.create(this, R.raw.varietyofseedssowd);
			mp.start();
			
		}
		
       if( v.getId() == R.id.home_btn_units_sow || v.getId() ==  R.id.home_btn_units_no_sow){
			
			if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
			mp = MediaPlayer.create(this, R.raw.selecttheunits);
			mp.start();
			
		}
       
       if( v.getId() == R.id.home_btn_day_sow){
			
			if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
			mp = MediaPlayer.create(this, R.raw.selectthedate);
			mp.start();
			
		}
       
       if( v.getId() == R.id.home_btn_treat_sow){
			
  			if(mp != null)
  			{
  				mp.stop();
  				mp.release();
  				mp = null;
  			}
  			mp = MediaPlayer.create(this, R.raw.treatmenttoseeds1);
  			mp.start();
  			
  		}
		
       if( v.getId() == R.id.sow_ok){
			
 			if(mp != null)
 			{
 				mp.stop();
 				mp.release();
 				mp = null;
 			}
 			mp = MediaPlayer.create(this, R.raw.ok);
 			mp.start();
 			
 		}
		
       if( v.getId() == R.id.sow_cancel){
			
 			if(mp != null)
 			{
 				mp.stop();
 				mp.release();
 				mp = null;
 			}
 			mp = MediaPlayer.create(this, R.raw.cancel);
 			mp.start();
 			
 		}
       
       
       if( v.getId() ==R.id.aggr_img_help ){
			
			if(mp != null)
			{
				mp.stop();
				mp.release();
				mp = null;
			}
			mp = MediaPlayer.create(this, R.raw.help);
			mp.start();
			
		}
       

		return true;
	}
    
    
    
    
    
    
    
    
    
    
    
}