package de.kozdemir.uebung17;

import java.awt.Point;

public class Person implements Runnable {
	Point p;

	private String name;
	private int posX;
	private int posY;
	private int zielPosX;
	private int zielPosY;

	public Person(String name, int posX, int posY) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
	}

	public void neuesZiel(int x, int y) {
		this.zielPosX = x;
		this.zielPosY = y;
	}

	public int getZielPosX() {
		return zielPosX;
	}

	public int getZielPosY() {
		return zielPosY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", posX=").append(posX).append(", posY=").append(posY)
				.append("]");
		return builder.toString();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean move() {
		
	}

}
