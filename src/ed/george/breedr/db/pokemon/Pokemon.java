package ed.george.breedr.db.pokemon;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ed.george.breedr.pokemon.core.Constants.Gender;

@DatabaseTable(tableName = "pokemon")
public class Pokemon {

	@DatabaseField(index = true, generatedId = true)
	private int id;
	@DatabaseField(canBeNull = false)
	private Gender gender;
	@DatabaseField(canBeNull = false)
	private int level;
	
	@DatabaseField
	private boolean perfectHP;
	@DatabaseField
	private boolean perfectAttack;
	@DatabaseField
	private boolean perfectDefense;
	@DatabaseField
	private boolean perfectSpecialAttack;
	@DatabaseField
	private boolean perfectSpecialDefense;
	@DatabaseField
	private boolean perfectSpeed;
	
	//Species species
	//Trainer trainer
	//
	
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean hasPerfectSpeed() {
		return perfectSpeed;
	}

	public void setPerfectSpeed(boolean perfectSpeed) {
		this.perfectSpeed = perfectSpeed;
	}

	public boolean hasPerfectSpecialDefense() {
		return perfectSpecialDefense;
	}

	public void setPerfectSpecialDefense(boolean perfectSpecialDefense) {
		this.perfectSpecialDefense = perfectSpecialDefense;
	}

	public boolean hasPerfectSpecialAttack() {
		return perfectSpecialAttack;
	}

	public void setPerfectSpecialAttack(boolean perfectSpecialAttack) {
		this.perfectSpecialAttack = perfectSpecialAttack;
	}

	public boolean hasPerfectDefense() {
		return perfectDefense;
	}

	public void setPerfectDefense(boolean perfectDefense) {
		this.perfectDefense = perfectDefense;
	}

	public boolean hasPerfectAttack() {
		return perfectAttack;
	}

	public void setPerfectAttack(boolean perfectAttack) {
		this.perfectAttack = perfectAttack;
	}

	public boolean hasPerfectHP() {
		return perfectHP;
	}

	public void setPerfectHP(boolean perfectHP) {
		this.perfectHP = perfectHP;
	}
	
}
