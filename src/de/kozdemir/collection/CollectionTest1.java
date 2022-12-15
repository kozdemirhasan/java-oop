package de.kozdemir.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest1 {

	public static void main(String[] args) {
		
		// List - Erlaubt Duplikate, behält die Reihnenfolge bei
		// Set - (Menge) Keine Duplikate erlaubt
		// Queue/Deque - Warteschlange
		// Map - Assoziativ-Speicher (Schlüssel-Wert-Paare)
		
		//List<String> list = new List<>(); // Error, List ist ein Interface, keine Instanzierung möglich
		List<String> list1 = new ArrayList<>(); // ArrayList implementiert das List Interface
		list1 = new LinkedList<>(); // LinkedList implementiert das List Interface

		ArrayList<String> list2 = new ArrayList<>();
		//list2 = new LinkedList<>(); // LinkedList ist KEINE ArrayList
		
		
		list1.add("Peter"); // Wird am Ende der Liste eingefügt
		list1.add("Carol");
		//[Peter, Carol]
		list1.add(0, "Bruce"); // Fügt das Element an passender Stelle ein. Folgeelemente werden nach rechts verschoben
		//[Bruce, Peter, Carol]
		boolean entfernt = list1.remove("Peter"); // Element wird entfernt, wenn es vorhanden ist. Folgeelemente werden nach links verschoben
		//[Bruce, Carol]
		System.out.println(entfernt); // true, wenn das Objekt gefunden und entfernt wurde
		
		// Liefert das enfernte Element zurück
		String removedElement = list1.remove(1); // Entfernt das Element an passender Position
		//[Bruce]
		System.out.println(removedElement); // Carol
		
		// Liefert den ursprünglichen Wert zurück
		removedElement = list1.set(0, "Natasha"); // Überschreibt das Element an gewünschter Position
		System.out.println(removedElement); // Bruce
		
		list1.clear(); // Alle Elemente werden entfernt
		
		System.out.println(list1); // toString
		
		list1.addAll(Arrays.asList("Bruce", "Peter", "Stanley")); // Fügt alle Elemente am Ende der Liste ein. Verlagt eine Collection
		list1.addAll(2, Arrays.asList("Hans", "Bob", "Anna")); // Fügt alle Elemente an gewünschter Position ein
		
		System.out.println(list1);
		
		//list1 = Arrays.asList("Bruce", "Peter", "Stanley"); // Arrays.asList produziert eine fixed-size Liste
		//list1.add("Steve"); // Exception, kann nicht erweitert werden
		
		list1.removeAll(Arrays.asList("Hans", "Bob")); // Entfernt gewünschte Elemente aus der Liste. Verlangt eine Collection
		
		list1.retainAll(Arrays.asList("Bruce", "Stanley", "John")); // Behält gewünschte Elemente und entfernt den Rest
		
		System.out.println(list1);
		
		list1.clear(); // Ist jetzt leer
		boolean enthalten = list1.contains("Peter"); // Ist passendes Element in der Liste enthalten?
		System.out.println("Ist Peter in der Liste: " + enthalten);
		
		if(!list1.isEmpty()) {
			String s = list1.get(0); // An Index 0 ist nicht abgelegt, Position 0 ist nicht da, IndexOutOfBounds
			System.out.println(s);
		}
		else {
			System.out.println("Liste ist leer");
		}
		
//		list1 = null;
//		System.out.println(list1.size()); // NullPointerExcaption
		
		
		list1 = new ArrayList<>(100); // das interne Array hat eine größe von 100
		//list1 = new ArrayList<>(-100); // Produziert eine Exception
		list1 = new ArrayList<>(list1); // übernimmt alle alten Elemente in die neue Liste
		list1.add("Carol"); // size 1, Anzahl der vorhandenen Elemente
		//list1.add(2, "Peter"); //Exception:  Index ist nicht vorhanden, daher nicht nutzbar. Index muss kleiner gleich size sein (0 oder 1)
		//list1.add(-2, "Peter"); //Exception: Index darf nicht negativ sein
		
		System.out.println();
		
		list1.clear();
		list1.add("Peter");
		list1.add("Hans");
		list1.add("Bob");
		
		Object[] objects = list1.toArray(); // Liefer ein Objekt-Array zurück
		
		for(Object o : objects) {
			System.out.println(((String)o).toUpperCase());
		}
		
		System.out.println();
		// Mit passenden Typen
		
		//Integer[] namen = list1.toArray(n); // Liefer ein Array vom Typ der Parameter-Arrays
		String[] namen = list1.toArray(new String[]{}); // Liefer ein Array vom Typ der Parameter-Arrays
		// Typ des Parameter-Arrays entscheidet über den Typ der Rückgabe
		
		for(String n : namen) {
			System.out.println(n.toUpperCase());
		}
		
		System.out.println();
		
		String[] namen2 = new String[10]; // Leeres String Array
		list1.toArray(namen2); // Füllt das vorgegebene Array mit Elementen auf
		
		for(String n : namen2) {
			System.out.println(n);
		}
		
	}
}
