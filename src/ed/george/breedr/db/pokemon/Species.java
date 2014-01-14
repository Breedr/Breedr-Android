package ed.george.breedr.db.pokemon;

import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "species")
public class Species {

	//Equal to national dex number
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private String name;
	
	//May need intermediate table here
	
	//Evolution
	//id (auto gen)
	//Species from;
	//Species to;
	
	@DatabaseField(foreign = true)
	private Collection<Species> evolvesInto;
	@DatabaseField
	private Species evolvesFrom;

	public Collection<Species> getEvolvesInto() {
		return evolvesInto;
	}

	public void setEvolvesInto(Collection<Species> evolvesInto) {
		this.evolvesInto = evolvesInto;
	}

	public Species getEvolvesFrom() {
		return evolvesFrom;
	}

	public void setEvolvesFrom(Species evolvesFrom) {
		this.evolvesFrom = evolvesFrom;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
