package ed.george.breedr;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class PokeListFragment extends ListFragment {

	AutoCompleteTextView species;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.add_poke_layout, null);

		species = (AutoCompleteTextView) view.findViewById(R.id.add_pokemon_species);
		return view;

	}

	
				
		
	
		@Override
		public void onStart() {
			super.onStart();
			String[] species_list = new String[] {
			         "Belgium", "France", "Italy", "Germany", "Spain"
		     };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, species_list);
			species.setAdapter(adapter);
		}

}
