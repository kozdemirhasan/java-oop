package de.kozdemir.objects;

public class SpielTest {
	
	public static void main(String[] args) {
		
		SpielBrett brett = new SpielBrett();
		brett.zeigeBrett();
		
		Spieler s1 = new Spieler("Peter", brett);
		
		Spieler s2 = new Spieler("Carol", brett);
		
		Runnable spieler1 = () -> {
			for(int i = 0; i < 6; i++) {
				s1.setzStein();
				
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable spieler2 = () -> {
			for(int i = 0; i < 6; i++) {
				s2.setzStein();
				
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(spieler1).start();
		new Thread(spieler2).start();
		
	}

}
