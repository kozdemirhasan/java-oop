package de.kozdemir.solid;

import java.util.LinkedList;
import java.util.Queue;

public class InterfaceSegregationTest {
	
	public static void main(String[] args) {
		
		Betankbar auto = () -> System.out.println("Auto wird betankt...");
		auto.tanken();
		
		// Warteschlange, FIFO-Speicher
		Queue<StartbarLandbar> startWarteschlage = new LinkedList<>();
		
		startWarteschlage.offer(new A380());
		startWarteschlage.offer(new A380());
		startWarteschlage.offer(new WasserFlugzeug());
		startWarteschlage.offer(new WasserFlugzeug());
		startWarteschlage.offer(new Ente());
		startWarteschlage.offer(new Ente());
		
		// Koordinirte Starts
		while(!startWarteschlage.isEmpty()) {
			startWarteschlage.poll().starten();
		}
		
		// KoordiniertesBetanken
		Queue<Betankbar> tankWarteschlage = new LinkedList<>();
		tankWarteschlage.offer(new A380());
		tankWarteschlage.offer(new WasserFlugzeug());
		//tankWarteschlage.offer(new Ente()); // Ente kann nicht betankt werden
		tankWarteschlage.offer(auto);
		
		while(!tankWarteschlage.isEmpty()) {
			tankWarteschlage.poll().tanken();
		}
		
	}
}

interface Flugobjekt extends StartbarLandbar, HatFahrwerk, Betankbar, TowerKommunikation {
	
//	void towerKommunikation();
//	
//	void starten();
//	
//	void landen();
//	
//	void fahrwerkAusfahren();
//	
//	void fahrwerkEinfahren();
//	
//	void tanken();
}

interface HatFahrwerk {
	
	void fahrwerkAusfahren();
	
	void fahrwerkEinfahren();
}

interface Betankbar {
	
	void tanken();
}

interface StartbarLandbar {
	
	void starten();
	
	void landen();
}

interface TowerKommunikation {
	
	void kommunizieren();
}

class A380 implements Flugobjekt {

	@Override
	public void starten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void landen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fahrwerkAusfahren() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fahrwerkEinfahren() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tanken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kommunizieren() {
		// TODO Auto-generated method stub
		
	}
}

class WasserFlugzeug implements StartbarLandbar, Betankbar, TowerKommunikation {

	@Override
	public void kommunizieren() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tanken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void starten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void landen() {
		// TODO Auto-generated method stub
		
	}	
}

class Ente implements StartbarLandbar {

	@Override
	public void starten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void landen() {
		// TODO Auto-generated method stub
		
	}
}