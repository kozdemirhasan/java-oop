package de.kozdemir.solid;

import java.util.ArrayList;
import java.util.List;

public class DependencyInversionTest {
	
	public static void main(String[] args) {
		
		KlimaFreundlichesGebeude gebeude = new KlimaFreundlichesGebeude(
			new KlimaFreundlicherRaum(),
			new KlimaFreundlicherRaum(),
			new KlimaNeutralerRaum(),
			new SehrKlimaFreundlicherRaum()
		);
	}
}


class KlimaFreundlichesGebeude {
	
	private final List<Raum> raeume = new ArrayList<>();
	
	public KlimaFreundlichesGebeude(Raum... raeume) {
		
		for(Raum raum : raeume)
			this.raeume.add(raum);
	}
}

interface Raum {
}

class KlimaFreundlicherRaum implements Raum {
	
}

class KlimaNeutralerRaum extends KlimaFreundlicherRaum  {
	
}

class SehrKlimaFreundlicherRaum implements Raum {
	
}