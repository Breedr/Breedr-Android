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
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	//https://code.google.com/p/iosched/source/browse/android/src/main/java/com/google/android/apps/iosched/ui/HomeActivity.java
	//http://pokeapi.co/
	//https://github.com/veekun/pokedex/tree/master/pokedex/data/csv
	//http://www.convertcsv.com/csv-to-json.htm
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
