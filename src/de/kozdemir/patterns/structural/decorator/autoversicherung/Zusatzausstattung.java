package de.kozdemir.patterns.structural.decorator.autoversicherung;

public class Zusatzausstattung {
	FelgenTyp felgenTyp;
	AudioSystem audioSystem;
	
	public Zusatzausstattung(FelgenTyp felgenTyp, AudioSystem audioSystem) {
	
		this.felgenTyp = felgenTyp;
		this.audioSystem = audioSystem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("felgenTyp=");
		builder.append(felgenTyp);
		builder.append(", audioSystem=");
		builder.append(audioSystem);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
