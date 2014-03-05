/**
 * Constants.java
 * Breedr
 * 
 * Created by Ed George on Jan 13, 2014
 * Released under The MIT License (MIT)
 * Copyright (c) 2014 Breedr
 */
package ed.george.breedr.pokemon.core;


public class Constants {

	public enum Gender{	
		MALE, FEMALE, GENDERLESS;
		
		public static String[] names() {
		    Gender[] states = values();
		    String[] names = new String[states.length];

		    for (int i = 0; i < states.length; i++) {
		        names[i] = states[i].name();
		    }

		    return names;
		}
	}
	
	public static enum Stat{
		HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED;
		
		public static String[] names() {
		    Stat[] states = values();
		    String[] names = new String[states.length];

		    for (int i = 0; i < states.length; i++) {
		        names[i] = states[i].name();
		    }

		    return names;
		}
	}

	//Generation VI 
	//Source http://bulbapedia.bulbagarden.net/wiki/Breeding#Generation_VI
	public static final double MASUDA_METHOD_CHANCE = 6.0f/8192.0f;
	
	public static final double SHINY_CHARM_HATCH_SAME_REGION = 3.0f/8192.0f;
	public static final double SHINY_CHARM_HATCH_MASUDA = 8.0f/8192.0f;
	
}
