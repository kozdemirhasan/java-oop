package de.kozdemir.json2;

import java.util.Arrays;

public class Held {
	
	private int id;
	private String vorname;
	private String nachname;
	private String[] stadt;
	private int alter;
	private boolean raucher;
	
	public Held() {
	}

	public Held(String vorname, String nachname, String[] stadt, int alter, boolean raucher) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.stadt = stadt;
		this.alter = alter;
		this.raucher = raucher;
	}
	
	public Held(int id, String vorname, String nachname, String[] stadt, int alter, boolean raucher) {
		this(vorname, nachname, stadt, alter, raucher);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String[] getStadt() {
		return stadt;
	}

	public void setStadt(String[] stadt) {
		this.stadt = stadt;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public boolean isRaucher() {
		return raucher;
	}

	public void setRaucher(boolean raucher) {
		this.raucher = raucher;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Held [vorname=");
		builder.append(vorname);
		builder.append(", nachname=");
		builder.append(nachname);
		builder.append(", stadt=");
		builder.append(Arrays.toString(stadt));
		builder.append(", alter=");
		builder.append(alter);
		builder.append(", raucher=");
		builder.append(raucher);
		builder.append("]");
		return builder.toString();
	}
}
