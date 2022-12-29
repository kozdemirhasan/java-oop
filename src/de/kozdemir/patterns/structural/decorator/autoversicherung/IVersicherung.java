package de.kozdemir.patterns.structural.decorator.autoversicherung;

import java.util.List;

public interface IVersicherung {	
	
	double calculatePreis();
	
	List<Versicherung> getVersicherung();
}
