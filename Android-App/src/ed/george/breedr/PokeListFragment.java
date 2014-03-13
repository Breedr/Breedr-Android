package ed.george.breedr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import ed.george.breedr.db.pokemon.Pokemon;

public class PokeListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<Pokemon>> {


	private PokemonListAdapter mListAdapter;
	private List<Pokemon> data = new ArrayList<Pokemon>();

	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// Initially there is no data 
		setEmptyText("No Data Here");

		mListAdapter = new PokemonListAdapter(getActivity(), data);
		setListAdapter(mListAdapter);

		// Start out with a progress indicator.
		setListShown(false);

		getLoaderManager().initLoader(0, null, this).forceLoad();
	}

	@Override 
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.i("PokeList", "Item clicked: " + id);
	}


	@Override
	public Loader<List<Pokemon>> onCreateLoader(int arg0, Bundle arg1) {
		return new PokeListLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<List<Pokemon>> arg0, List<Pokemon> data) {
		this.data.clear();
		this.data.addAll(data);
		mListAdapter.notifyDataSetChanged();
		Log.i("PokeList", "Load fnished - " + data.size());
		if (isResumed()) {
			setListShown(true);
		
		} else {
			setListShownNoAnimation(true);
		}      

		
	}

	@Override
	public void onLoaderReset(Loader<List<Pokemon>> arg0) {
		data = null;
	}

	public static class PokeListLoader extends AsyncTaskLoader<List<Pokemon>> {

		List<Pokemon> mPoke;

		public PokeListLoader(Context context) {
			super(context);
			Log.i("PokeList", "Constructor");
			mPoke = new ArrayList<Pokemon>();
		}

		/**
		 * This is where the bulk of our work is done.  This function is
		 * called in a background thread and should generate a new set of
		 * data to be published by the loader.
		 */
		@Override public List<Pokemon> loadInBackground() {
		
			try {
				mPoke = Pokemon.getDao(getContext()).queryForAll();
				
				if(mPoke == null || mPoke.size() == 0){
					Log.i("PokeList", "Oh dear");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return mPoke;
		}

		/**
		 * Called when there is new data to deliver to the client.  The
		 * super class will take care of delivering it; the implementation
		 * here just adds a little more logic.
		 */
		@Override public void deliverResult(List<Pokemon> poke) {

			List<Pokemon> oldApps = mPoke;
			mPoke = poke;

			Log.i("PokeList", "Return " + poke.size());
			
			if (isStarted()) {
				// If the Loader is currently started, we can immediately
				// deliver its results.
				super.deliverResult(poke);
			}

			// At this point we can release the resources associated with
			// 'oldApps' if needed; now that the new result is delivered we
			// know that it is no longer in use.
			//	        if (oldApps != null) {
			//	            onReleaseResources(oldApps);
			//	        }
		}
	}

}
