/**
 * DatabaseHelper.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */

package ed.george.breedr.db.core;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import ed.george.breedr.db.pokemon.Pokemon;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	//      .==.        .==.          
	//     //`^\\      //^`\\         
	//    // ^ ^\(\__/)/^ ^^\\        
	//   //^ ^^ ^/6  6\ ^^ ^ \\       
	//  //^ ^^ ^/( .. )\^ ^ ^ \\      
	// // ^^ ^/\| v""v |/\^ ^ ^\\     
	//// ^^/\/ /  `~~`  \ \/\^ ^\\    
	//-----------------------------
	/// HERE BE DRAGONS - Please update this properly!

	private static final String BASE_DATABASE_NAME = "breedr.db";
	public static final int DATABASE_VERSION = 1;
	private static final String TAG = DatabaseHelper.class.getSimpleName();
	private static DatabaseHelper instance;

	public DatabaseHelper(final Context context) {
		super(context, BASE_DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			createTables(connectionSource);
		} catch (SQLException e) {
			Log.e(TAG, e.getMessage()); 
			throw new RuntimeException(e);
		}
	}

	public static DatabaseHelper getDatabaseHelperInstance(Context c) {
		if (instance == null) {
			instance = new DatabaseHelper(c);
		}
		return instance;
	}

	private void createTables(ConnectionSource connectionSource) throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Pokemon.class);
	}

	private void dropTables(ConnectionSource connectionSource) throws SQLException {
		TableUtils.dropTable(connectionSource, Pokemon.class, true);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			dropTables(connectionSource);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(TAG, "Can't drop database\n" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void close() {
		super.close();
	}


}

