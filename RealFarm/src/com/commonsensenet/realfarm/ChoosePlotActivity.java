package com.commonsensenet.realfarm;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.commonsensenet.realfarm.dataaccess.RealFarmProvider;
import com.commonsensenet.realfarm.homescreen.Homescreen;
import com.commonsensenet.realfarm.model.Plot;
import com.commonsensenet.realfarm.view.PlotItemAdapter;

/**
 * Activity that enables the selection of one plot.
 * 
 * @author Oscar Bola�os <@oscarbolanos>
 * 
 */
public class ChoosePlotActivity extends Activity implements OnItemClickListener {
	/** Access to the underlying database of the application. */
	private RealFarmProvider mDataProvider;
	/** ListAdapter used to handle the plots. */
	private PlotItemAdapter mPlotItemAdapter;
	/** ListView where the plots are rendered. */
	private ListView mPlotsListView;

	private void listViewSettings() {

		// gets the users from the database.
		List<Plot> plots = mDataProvider.getPlotsByUserIdAndDeleteFlag(
				Global.userId, 0);

		mPlotItemAdapter = new PlotItemAdapter(this, plots, mDataProvider);

		// gets the list from the UI.
		mPlotsListView = (ListView) findViewById(R.id.list_plots);
		mPlotsListView.setItemsCanFocus(true);
		// sets the custom adapter.
		mPlotsListView.setAdapter(mPlotItemAdapter);
	}

	public void onBackPressed() {

		Intent adminintent123 = new Intent(ChoosePlotActivity.this,
				Homescreen.class);
		startActivity(adminintent123);
		ChoosePlotActivity.this.finish();
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// sets the layout
		setContentView(R.layout.act_choose_plot);

		// gets the data provider
		mDataProvider = RealFarmProvider.getInstance(this);

		// updates the list view
		listViewSettings();

		// sets the listener
		mPlotsListView.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// gets the selected view using the position
		Plot selectedPlot = mPlotItemAdapter.getItem(position);

		// sets the active plotId
		Global.plotId = selectedPlot.getId();

		// loads the target activity
		if (Global.selectedAction != null) {
			view.getContext().startActivity(
					new Intent(view.getContext(), Global.selectedAction));
			// ensures that back will not reach it.
			ChoosePlotActivity.this.finish();
		}
	}
}