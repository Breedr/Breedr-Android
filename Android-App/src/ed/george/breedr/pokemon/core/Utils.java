package ed.george.breedr.pokemon.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;

public class Utils {

	private static Utils instance = null;
	
	public Utils(){
		super();
	}
	
	public static Utils getInstance(){
		
		if(instance == null)
			return new Utils();
		
		return instance;
		
	} 
	
	public String loadJSONToString(Context ctx, String filename) throws IOException{

		AssetManager assetManager = ctx.getResources().getAssets();
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
	
	
	public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
	
	
}
