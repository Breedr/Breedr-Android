/**
 * Pokemon.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr.db.pokemon;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ed.george.breedr.pokemon.core.Constants.Gender;

@DatabaseTable(tableName = "pokemon")
public class Pokemon {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private int pokemonId;
	@DatabaseField(canBeNull = false)
	private Gender gender;
	@DatabaseField(canBeNull = false)
	private int level;
	@DatabaseField
	private String nickname;
	@DatabaseField
	private boolean shiny;
	@DatabaseField
	private boolean pokerus;
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
	
	
    //@DatabaseField(canBeNull = false)
	//Species species
	//@DatabaseField(canBeNull = false)
	//Nature nature
	
	//Pokemon mother
	//Pokemon father
	
	//@DatabaseField(canBeNull = false)
	//Trainer trainer
	
	//Item heldItem
	
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
	
	public boolean isShiny() {
		return shiny;
	}

	public void setShiny(boolean shiny) {
		this.shiny = shiny;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	
}
