/**
 * MainActivity.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.Dao;

import ed.george.breedr.db.core.DatabaseHelper;
import ed.george.breedr.db.core.InitialLoadTask;
import ed.george.breedr.db.pokemon.EggType;
import ed.george.breedr.db.pokemon.Species;

public class MainActivity extends BaseActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

	//https://code.google.com/p/iosched/source/browse/android/src/main/java/com/google/android/apps/iosched/ui/HomeActivity.java
	//http://pokeapi.co/
	//https://github.com/veekun/pokedex/tree/master/pokedex/data/csv
	//http://www.convertcsv.com/csv-to-json.htm
	//https://github.com/nhaarman/ListViewAnimations
	// http://i.imgur.com/KV6uAxk.png
	//https://github.com/soberstadt/GeneralHttpAndroidExample/tree/master/src/com/spencero/example/generalHttpRequest


	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Crashlytics.start(this);
		setContentView(R.layout.activity_main);

		FragmentManager fm = getSupportFragmentManager();
		mViewPager = (ViewPager) findViewById(R.id.pager);


		if (mViewPager != null) {
			// Phone setup
			mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
			mViewPager.setOnPageChangeListener(this);
			//			mViewPager.setPageMarginDrawable(R.drawable.grey_border_inset_lr);
			//			mViewPager.setPageMargin(getResources()
			//					.getDimensionPixelSize(R.dimen.page_margin_width));


			//http://developer.android.com/training/basics/actionbar/adding-buttons.html
			final ActionBar actionBar = getSupportActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			actionBar.addTab(actionBar.newTab()
					.setText(R.string.breeding_fragment)
					.setTabListener(this));
			actionBar.addTab(actionBar.newTab()
					.setText(R.string.pkm_fragment)
					.setTabListener(this));
			actionBar.addTab(actionBar.newTab()
					.setText(R.string.other_fragment)
					.setTabListener(this));
			setHasTabs();
		}

		getSupportActionBar().setHomeButtonEnabled(false);


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	
	    case R.id.menu_add_pokemon:
	    	startActivity(new Intent(getApplicationContext(), AddNewPokemonActivity.class));
	    	return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onStart() {
		super.onStart();

		loadDatabaseIfNeeded();
		
	}

	private void loadDatabaseIfNeeded() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try{
					Dao<Species, Integer> sd = DatabaseHelper.getInstance(getApplicationContext()).getDao(Species.class);
					Dao<EggType, Integer> etd = DatabaseHelper.getInstance(getApplicationContext()).getDao(EggType.class);

					if(sd.queryBuilder().countOf() == 0 || etd.queryBuilder().countOf() == 0){

						runOnUiThread(new Runnable() {

							@Override
							public void run() {
								new InitialLoadTask(MainActivity.this).execute();
							}
						});						
					}
				}catch(Exception e){
					//TODO: show dialog here
				}
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position) {
		getSupportActionBar().setSelectedNavigationItem(position);

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// TODO Auto-generated method stub

	}

	private class MainPagerAdapter extends FragmentPagerAdapter {
		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {

//			case 1:
//				return new AddPokemonFragment();

			default:
				return new PokeListFragment();
			}

		}

		@Override
		public int getCount() {
			return 3;
		}
	}

}
