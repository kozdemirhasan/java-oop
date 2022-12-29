package de.kozdemir.uebung16;

import java.util.HashSet;

public class Roboter {

	private String name;
	private HashSet<String> aufgaben;

	public Roboter(String name, HashSet<String> aufgaben) {
		this.name = name;
		this.aufgaben = aufgaben;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<String> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(HashSet<String> aufgaben) {
		this.aufgaben = aufgaben;
	}

}
