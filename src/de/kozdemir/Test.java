package de.kozdemir;

public class Test {

	public static void main(String[] args) {
		String str = "  Hoşlgeldin :Misafir Kullanıcı";
        String[] arrStr = str.split(":");
        for (String el: arrStr)
            System.out.println(el);

	}

}
