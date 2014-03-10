package ed.george.breedr;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ed.george.breedr.db.pokemon.Pokemon;

public class PokemonListAdapter extends BaseAdapter{

	private Activity ctx;
	private List<Pokemon> pokemon;

	static class PokemonListViewHolder {
		public TextView text;
		public ImageView image;
		public View type;
	}

	public PokemonListAdapter(Activity ctx, List<Pokemon> pokemon) {
		this.ctx = ctx;
		this.pokemon = pokemon;
	}

	@Override
	public int getCount() {
		return pokemon.size();
	}

	@Override
	public Pokemon getItem(int position) {
		// TODO Auto-generated method stub
		return pokemon.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;

		if (rowView == null) {
			LayoutInflater inflater = ctx.getLayoutInflater();
			rowView = inflater.inflate(R.layout.list_poke_main, null);


			PokemonListViewHolder viewHolder = new PokemonListViewHolder();
			viewHolder.text = (TextView) rowView.findViewById(R.id.TextView01);
			viewHolder.image = (ImageView) rowView
					.findViewById(R.id.ImageView01);
			rowView.setTag(viewHolder);
		}

		//Populate views
		PokemonListViewHolder holder = (PokemonListViewHolder) rowView.getTag();
		holder.text.setText(pokemon.get(position).getDisplayName());
		//	    if (s.startsWith("Windows7") || s.startsWith("iPhone")
		//	        || s.startsWith("Solaris")) {
		//	      holder.image.setImageResource(R.drawable.no);
		//	    } else {
		//	      holder.image.setImageResource(R.drawable.ok);
		//	    }

		return rowView;
	}

}
