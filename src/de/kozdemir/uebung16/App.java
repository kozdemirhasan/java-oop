package de.kozdemir.uebung16;

public class App {

	public static void main(String[] args) {
		
		Roboter r1 = new Roboter("DX-337", AufgabeUtil.aufgabeGeben() );
		
		System.out.println(r1.getName());
		System.out.println(r1.getAufgaben().size());
		
		for(String s : r1.getAufgaben())
			System.out.print(s + "- ");
		

	}

}
