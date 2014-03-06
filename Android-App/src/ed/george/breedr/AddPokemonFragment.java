package ed.george.breedr;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.j256.ormlite.dao.Dao;

import ed.george.breedr.db.core.DatabaseHelper;
import ed.george.breedr.db.pokemon.Pokemon;
import ed.george.breedr.db.pokemon.Species;

public class AddPokemonFragment extends Fragment {

	ArrayAdapter<String> speciesAdapter, regionAdapter;
	EditText level,nickname;
	Spinner region;
	AutoCompleteTextView species;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.add_poke_fragment, null);
		level = (EditText) view.findViewById(R.id.pokemon_level_edit);
		nickname = (EditText) view.findViewById(R.id.add_pokemon_nickname);
		species = (AutoCompleteTextView) view.findViewById(R.id.add_pokemon_species);
		region = (Spinner) view.findViewById(R.id.add_pokemon_region);
		return view;

	}

	@Override
	public void onStart() {
		super.onStart();

		if(speciesAdapter == null)
			setupSpeciesAdapter();
		
		if(regionAdapter == null)
			setupRegionAdapter();


		level.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {		
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if(s.length() > 0){
					int parsed_level = Integer.parseInt(s.toString());
					if(parsed_level == 0){
						level.setText("1");
					}else if(parsed_level > 100){
						level.setText("100");
					}
				}
			}
		});

	}

	private void setupRegionAdapter() {
		regionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Pokemon.Region.names());
		region.setAdapter(regionAdapter);	
	}

	private void setupSpeciesAdapter() {
		new Thread(new Runnable() {
			public void run() {

				try{	
					//TODO: make this more efficient
					
					Dao<Species, Integer> sd = DatabaseHelper.getInstance(getActivity()).getDao(Species.class);
					List<Species> species_list = sd.queryForAll();
					
					final String[] species_list_name = new String[species_list.size()];
					
					for(int i = 0; i < species_list.size(); i++){
						
						species_list_name[i] = species_list.get(i).getName();
						
					}

					getActivity().runOnUiThread(new Runnable() {
						public void run() {
							
							speciesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, species_list_name);
							species.setAdapter(speciesAdapter);
						}
					});
					
				}catch(Exception e){
					e.printStackTrace();	
				}
			}
		}).start();
	}
	
	
	private void createPokemon(final Pokemon pkm){
		new Thread(new Runnable() {
			public void run() {
				
				if(Pokemon.createPokemon(pkm, getActivity())){
					//TODO: Pokemon added
				}else{
					//TODO: error handling
				}
				
			}
		}).start();
	}
	
}
