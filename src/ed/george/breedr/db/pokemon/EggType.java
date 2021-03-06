package ed.george.breedr.db.pokemon;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "eggtypes")
public class EggType {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(canBeNull = true)
	private String name;
	@DatabaseField
	private boolean canBreed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean canBreed() {
		return canBreed;
	}

	public void setCanBreed(boolean canBreed) {
		this.canBreed = canBreed;
	}



}
