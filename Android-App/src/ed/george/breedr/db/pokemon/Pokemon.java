/**
 * Pokemon.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr.db.pokemon;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ed.george.breedr.db.trainer.Trainer;
import ed.george.breedr.pokemon.core.Constants.Gender;

@DatabaseTable(tableName = "pokemon")
public class Pokemon {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private int nationalDexId;
	@DatabaseField(canBeNull = false)
	private Gender gender;
	@DatabaseField(canBeNull = false)
	private int level;
	@DatabaseField
	private Region region;
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

	//May need relationship table
	//Pokemon mother
	//Pokemon father

	//	@DatabaseField(canBeNull = false)
	Trainer trainer;

	//Item heldItem

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

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

	public int getNationalDexNumber() {
		return nationalDexId;
	}

	public void setNationalDexNumber(int nationalDexId) {
		this.nationalDexId = nationalDexId;
	}

	//HELPER Methods
	
	public ArrayList<Boolean> getIVs(){
		
		ArrayList<Boolean> ivs = new ArrayList<Boolean>();
		
		ivs.add(perfectHP);
		ivs.add(perfectAttack);
		ivs.add(perfectDefense);
		ivs.add(perfectSpecialAttack);
		ivs.add(perfectSpecialDefense);
		ivs.add(perfectSpeed);
		
		return ivs;	
	}

	public int getPerfectIVCount(){

		int ivs  = 0;

		if(perfectHP)
			ivs++;

		if(perfectAttack)
			ivs++;

		if(perfectDefense)
			ivs++;

		if(perfectSpecialAttack)
			ivs++;

		if(perfectSpecialDefense)
			ivs++;

		if(perfectSpeed)
			ivs++;

		return ivs;
	}

	//TODO: confirm these
	public enum Region {
	    ENG, SPA, FRE, GER, ITA, JAP, KOR
	}
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


}
