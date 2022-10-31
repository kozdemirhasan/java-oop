package de.kozdemir.advancedJava.search;


public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 2,4,6,8,12,34,56 },0,6,6 ));

	}
	
	static int binarySearch(int[] dizi, int bas, int son, int deger){		
		
		
        if (son >= bas){
            
            int orta = (bas + son)/2;
           
            if (dizi[orta] == deger)
               return deger;

            if (dizi[orta] > deger)
                 return binarySearch(dizi, bas, orta-1, deger);                         

           return binarySearch(dizi, orta+1, son, deger);        
        }
  
         return -1;
    }

}
