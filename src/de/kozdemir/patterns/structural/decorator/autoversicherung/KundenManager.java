package de.kozdemir.patterns.structural.decorator.autoversicherung;



public class KundenManager  {
	
	Person person;
	Fahrzeug fahrzeug;
	IVersicherung versicherung;
	
	public KundenManager(Person person, IVersicherung versicherung, Fahrzeug fahrzeug) {	
		this.person = person;
		this.versicherung = versicherung;
		this.fahrzeug = fahrzeug;
	}

	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}

	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}

	public IVersicherung getVersicherung() {
		return versicherung;
	}

	public void setVersicherung(IVersicherung versicherung) {
		this.versicherung = versicherung;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person=");
		builder.append(person.toString());
		builder.append("\nFahrzeug=");
		builder.append(fahrzeug.toString());
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	


}
