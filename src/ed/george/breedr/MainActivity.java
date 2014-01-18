/**
 * MainActivity.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.dao.Dao;

import ed.george.breedr.db.core.DatabaseHelper;
import ed.george.breedr.db.pokemon.EggType;
import ed.george.breedr.db.pokemon.Species;

public class MainActivity extends Activity {

	//https://code.google.com/p/iosched/source/browse/android/src/main/java/com/google/android/apps/iosched/ui/HomeActivity.java
	//http://pokeapi.co/
	//https://github.com/veekun/pokedex/tree/master/pokedex/data/csv
	//http://www.convertcsv.com/csv-to-json.htm

	private Dao<Species,Integer> spd;
	private Dao<EggType,Integer> etd;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try{

			tv = (TextView) findViewById(R.id.textView);


			spd = DatabaseHelper.getDatabaseHelperInstance(getApplicationContext()).getDao(Species.class);
			etd = DatabaseHelper.getDatabaseHelperInstance(getApplicationContext()).getDao(EggType.class);

			spd.callBatchTasks(new Callable<Void>() {
				@Override
				public Void call() throws Exception {

					addSpecies();

					return null;
				}	
			});

			etd.callBatchTasks(new Callable<Void>() {
				@Override
				public Void call() throws Exception {

					addEggTypes();

					return null;
				}	
			});

			List<Species> sp = spd.queryForAll();
			StringBuilder sb = new StringBuilder();

			for(Species s : sp)
			{
				sb.append(s.getId() + " - " + s.getName() + "\n");
			}

			tv.setText(sb.toString());

		}catch(Exception e){
			e.printStackTrace();
		}		
	}


	private String loadJSONToString(String filename) throws IOException{

		AssetManager assetManager = getResources().getAssets();
		InputStream inputStream = null;

		inputStream = assetManager.open(filename);

		if (inputStream != null) {

			StringBuilder buf = new StringBuilder();

			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String str;

			while ((str = in.readLine()) != null) {
				buf.append(str);
			}

			in.close();

			return buf.toString();

		}

		return null;

	}


	protected void addEggTypes() throws SQLException {

		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<EggType>>(){}.getType();

		try {

			List<EggType> eggTypes = gson.fromJson(loadJSONToString("egg_groups.json"), listType);

			for (EggType et : eggTypes) {
				etd.createOrUpdate(et);
			}

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	protected void addSpecies() throws SQLException {

		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Species>>(){}.getType();

		try {

			List<Species> species = gson.fromJson(loadJSONToString("species.json"), listType);

			for (Species sp : species) {
				spd.createOrUpdate(sp);
			}

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
