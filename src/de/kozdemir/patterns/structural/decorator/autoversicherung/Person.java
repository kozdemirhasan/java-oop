package de.kozdemir.patterns.structural.decorator.autoversicherung;

public  class Person {
	private String vorname;
	private String name;
	private String adress;
	private int alter;
	
	public Person(String vorname, String name, String adress, int alter) {
		this.vorname = vorname;
		this.name = name;
		this.adress = adress;
		this.alter = alter;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[vorname=");
		builder.append(vorname);
		builder.append(", name=");
		builder.append(name);
		builder.append(", adress=");
		builder.append(adress);
		builder.append(", alter=");
		builder.append(alter);
		builder.append("]");
		return builder.toString();
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}


	
	


}
