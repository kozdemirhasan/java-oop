package de.kozdemir.solid;

import java.util.ArrayList;
import java.util.List;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		
		Fahrzeug f = new Fahrzeug();
		f.motorStart();
		f.gibGas(100);
		f.addZuKofferraum("Einbruchswerkzeug");
		f.tanken(100);
		
		
		BesserFahrzeug f2 = new BesserFahrzeug(new KleinerTank(), new SportMotor());
		f2.tanken(100);
	}
}

class Fahrzeug {
	
	private int tankFuellMenge = 50;
	
	private int tank;
	
	private boolean an;
	
	private int geschwindigkeit;
	
	private List<String> kofferraum = new ArrayList<>();
	
	void tanken(int menge) {
		
		if(tank + menge > tankFuellMenge)
			tank = tankFuellMenge;
		else
			tank += menge;
	}

	public void removeVomKofferraum(String zeug) {
		kofferraum.remove(zeug);
	}

	public void addZuKofferraum(String zeug) {
		this.kofferraum.add(zeug);
	}
	
	void motorStart() {
		an = true;
	}
	
	void motorStop() {
		an = false;
	}
	
	void gibGas(int kmh) {
		geschwindigkeit += kmh;
	}
	
	void bremsen(int kmh) {
		geschwindigkeit -= kmh;
	}
	
	int getGeschwindigkeit() {
		return geschwindigkeit;
	}
}

class BesserFahrzeug implements Tank, Motor {
	
	private Tank tank;
	
	private Motor motor;
	
	public BesserFahrzeug(Tank tank, Motor motor) {
		this.tank = tank;
		this.motor = motor;
	}
	
	public BesserFahrzeug() {
		this.tank = new GrosserTank();
		this.motor = new SportMotor();
	}

	@Override
	public void tanken(int menge) {
		this.tank.tanken(menge);
	}

	@Override
	public void motorStart() {
		this.motor.motorStart();
	}

	@Override
	public void motorStop() {
		this.motor.motorStop();
	}

	@Override
	public void gibGas(int kmh) {
		this.motor.gibGas(kmh);
	}

	@Override
	public void bremsen(int kmh) {
		this.motor.bremsen(kmh);
	}

	@Override
	public int getGeschwindigkeit() {
		return this.motor.getGeschwindigkeit();
	}
}

interface Tank {
	
	void tanken(int menge);
	
}

class GrosserTank implements Tank {

	private final int tankFuellMenge = 100;
	
	private int tank;
	
	@Override
	public void tanken(int menge) {
		
		if(tank + menge > tankFuellMenge)
			tank = tankFuellMenge;
		else
			tank += menge;
	}
}

class KleinerTank implements Tank {

	private final int tankFuellMenge = 50;
	
	private int tank;
	
	@Override
	public void tanken(int menge) {
		
		if(tank + menge > tankFuellMenge)
			tank = tankFuellMenge;
		else
			tank += menge;
	}
}

interface Motor {
	
	void motorStart();
	
	void motorStop();
	
	void gibGas(int kmh);
	
	void bremsen(int kmh);
	
	int getGeschwindigkeit();
}

class SportMotor implements Motor {

	@Override
	public void motorStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void motorStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gibGas(int kmh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bremsen(int kmh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGeschwindigkeit() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
