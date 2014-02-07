package ed.george.breedr;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import ed.george.breedr.pokemon.core.Utils;


public class BaseActivity extends ActionBarActivity {

	protected void setHasTabs() {
		if (!Utils.isTablet(this)
				&& getResources().getConfiguration().orientation
				!= Configuration.ORIENTATION_LANDSCAPE) {
			// Only show the tab bar's shadow
			//TODO: complete
			//            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(
			//                    R.drawable.actionbar_background_noshadow));
		}
	}
}
