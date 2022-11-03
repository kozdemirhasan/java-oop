package de.kozdemir.uebung10_scout;

import java.time.LocalDate;

public class Scout /*implements Comparable<Scout>*/ {

	private String firstName;

	private String lastName;

	private LocalDate birthDate;
	
	

	public Scout() {
		
	}

	public Scout(String firstName, String lastName, LocalDate birthDate, int height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.height = height;
	}

	private int height;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

//	@Override
//	public int compareTo(Scout o) {
//		
//		return 0;
//	}

}
