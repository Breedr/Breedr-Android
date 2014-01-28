package ed.george.breedr.db.core;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.dao.Dao;

import ed.george.breedr.R;
import ed.george.breedr.db.pokemon.EggType;
import ed.george.breedr.db.pokemon.Species;
import ed.george.breedr.pokemon.core.Utils;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class InitialLoadTask extends AsyncTask<Void, Void, String> {

	private Context context;
	private ProgressDialog dialog;
	private Dao<Species,Integer> spd;
	private Dao<EggType,Integer> etd;

	public InitialLoadTask(Context context){
		this.context = context;
	}

	@Override
	protected void onPreExecute()
	{
		dialog = new ProgressDialog(context);
		dialog.setMessage(context.getResources().getString(R.string.initial_load));
		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	protected String doInBackground(Void... params) {

		try{

		spd = DatabaseHelper.getDatabaseHelperInstance(context).getDao(Species.class);
		etd = DatabaseHelper.getDatabaseHelperInstance(context).getDao(EggType.class);

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

		return sb.toString();
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			return null;
			
		}
	}

	@Override
	protected void onPostExecute(String result) {

		dialog.dismiss();

	}


	protected void addEggTypes() throws SQLException {

		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<EggType>>(){}.getType();

		try {

			List<EggType> eggTypes = gson.fromJson(Utils.getInstance().loadJSONToString(context, "egg_groups.json"), listType);

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

			List<Species> species = gson.fromJson(Utils.getInstance().loadJSONToString(context, "species.json"), listType);

			for (Species sp : species) {
				spd.createOrUpdate(sp);
			}

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
