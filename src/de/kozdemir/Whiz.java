package de.kozdemir;

import java.util.*;
import static java.lang.Math.*;

public class Whiz {

	public static void main(String[] args) {

		 int s = 2;
		 final int x=3;
		switch(s) {
		
		case 1: System.out.println("A"); break;
		case x-1: System.out.println("B");
		case x: System.out.println("C"); break;
		case x+1: System.out.println("D"); break;
		default: System.out.println("F");
			
		}
		
	}
}
