package de.kozdemir.uebung03_robot;

import java.util.Scanner;

public class TestRoboter {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Roboter grace = new Roboter("Grace",10,10); //nur Name oder Name und erste Position eingaben können
		grace.sagHallo();
		System.out.println(grace.toString());
		
		Spielfeld sp = new Spielfeld(20,20); //Spielfeld erst mal created

		while (true) {
			System.out.print("Anleitung: ");
			String eingabe = sc.next().trim().toLowerCase();

			if (eingabe.equalsIgnoreCase("exit")) {
				System.out.println("App wurde beendet. Tschüss...");
				break;
			}				

			grace = grace.controller(eingabe, grace);

			grace.toString();
			
			sp.fuellen(grace.x,grace.y);//Spielfeld wird gefüllt und druchen

		}

	}


}
