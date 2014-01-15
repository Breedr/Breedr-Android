package ed.george.breedr.db.pokemon;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "species")
public class Species {

	//Equal to national dex number
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private String identifier;
	@DatabaseField
	private double maleRatio;
	@DatabaseField
	private double femaleRatio;
	
	
	
	//May need intermediate table here
	
	//Evolution
	//id (auto gen)
	//Species from;
	//Species to;

	
	
	public String getName() {
		return identifier;
	}

	public void setName(String name) {
		this.identifier = name;
	}

	
	public double getFemaleRatio() {
		return femaleRatio;
	}

	public void setFemaleRatio(double femaleRatio) {
		this.femaleRatio = femaleRatio;
	}

	public double getMaleRatio() {
		return maleRatio;
	}

	public void setMaleRatio(double maleRatio) {
		this.maleRatio = maleRatio;
	}

	
}
