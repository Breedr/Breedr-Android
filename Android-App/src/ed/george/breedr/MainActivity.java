/**
 * MainActivity.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;

public class MainActivity extends BaseActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

	//https://code.google.com/p/iosched/source/browse/android/src/main/java/com/google/android/apps/iosched/ui/HomeActivity.java
	//http://pokeapi.co/
	//https://github.com/veekun/pokedex/tree/master/pokedex/data/csv
	//http://www.convertcsv.com/csv-to-json.htm
	//	https://github.com/nhaarman/ListViewAnimations
	// http://i.imgur.com/KV6uAxk.png
	//https://github.com/soberstadt/GeneralHttpAndroidExample/tree/master/src/com/spencero/example/generalHttpRequest


	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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

			final ActionBar actionBar = getSupportActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			actionBar.addTab(actionBar.newTab()
					.setText("Breeding")
					.setTabListener(this));
			actionBar.addTab(actionBar.newTab()
					.setText("My Pok�mon")
					.setTabListener(this));
			actionBar.addTab(actionBar.newTab()
					.setText("Other")
					.setTabListener(this));
			//			actionBar.addTab(actionBar.newTab()
			//					.setText(R.string.title_explore)
			//					.setTabListener(this));
			//			actionBar.addTab(actionBar.newTab()
			//					.setText(R.string.title_stream)
			//					.setTabListener(this));
			setHasTabs();
		}

		getSupportActionBar().setHomeButtonEnabled(false);


	}

	@Override
	protected void onStart() {
		super.onStart();

		// new InitialLoadTask(this).execute();
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
			//	            switch (position) {
			//	                case 0:
			//	                    return new ScheduleFragment();
			//
			//	                case 1:
			//	                    return new ExploreFragment();
			//
			//	                case 2:
			//	                    return (mSocialStreamFragment = new SocialStreamFragment());
			//	            }
			return new PokeListFragment();
		}

		@Override
		public int getCount() {
			return 3;
		}
	}

}
