package ed.george.breedr.db.pokemon;

import java.sql.SQLException;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ed.george.breedr.db.core.DatabaseHelper;

@DatabaseTable(tableName = "eggtypes")
public class EggType {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(canBeNull = true)
	private String identifier;
	@DatabaseField
	private boolean canBreed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return identifier;
	}

	public void setName(String name) {
		this.identifier = name;
	}

	public boolean canBreed() {
		return canBreed;
	}

	public void setCanBreed(boolean canBreed) {
		this.canBreed = canBreed;
	}


	private static Dao<EggType, Integer> daoInstance;

	public static Dao<EggType, Integer> getDao(Context ctx) throws SQLException{

		if(daoInstance != null)
			return daoInstance;

		daoInstance = DatabaseHelper.getInstance(ctx).getDao(EggType.class);

		return daoInstance;


	}

	public static boolean createOrUpdate(EggType pkm, Context ctx){

		try {
			getDao(ctx).createOrUpdate(pkm);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean create(EggType pkm, Context ctx){

		try {
			getDao(ctx).create(pkm);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static EggType fromID(Context ctx, int id) throws SQLException{
		
		return getDao(ctx).queryForId(id);
		
	}

}
