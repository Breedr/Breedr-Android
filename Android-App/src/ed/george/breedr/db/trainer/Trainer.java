package ed.george.breedr.db.trainer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ed.george.breedr.pokemon.core.Constants.Gender;

@DatabaseTable(tableName = "trainer")
public class Trainer {

	@DatabaseField(id = true)
	private int id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private Gender gender;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
