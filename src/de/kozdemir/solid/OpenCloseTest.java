package de.kozdemir.solid;

import java.util.ArrayList;
import java.util.List;

public class OpenCloseTest {
	
	public static void main(String[] args) {
		
		PersonalInfo info = new PersonalInfo();
		
		info.addPerson(new Person(Job.ENTWICKLER));
		info.addPerson(new Person(Job.ENTWICKLER));
		info.addPerson(new Person(Job.MANAGER));
		info.addPerson(new Person(Job.BERATER));
		info.addPerson(new Person(Job.BERATER));
		info.addPerson(new Person(Job.BERATER));
		
		System.out.println(info.getPersonenAnzahl(Job.BERATER));
	}

}

class PersonalInfo {
	
	private List<Person> personal = new ArrayList<>();

	public List<Person> getPersonal() {
		return personal;
	}

	public void addPerson(Person person) {
		this.personal.add(person);
	}
	
	public int getPersonenAnzahl(Job job) {
		
//		int count = 0;
//		for(Person p : personal) {
//			if(p.getJob().equals(job))
//				count++;
//		}
//		return count;
		
		return (int) personal.stream().filter(p -> p.getJob().equals(job)).count();
	}
}



// Statt eine Klasse direkt zu verändern ist es besser sie durch Erweiterung zu verbessern!
class EntwicklerInfo extends PersonalInfo {
	
	public int getEntwicklerAnzahl() {
		
		return getPersonenAnzahl(Job.ENTWICKLER);
	}
}

class Person {
	
	private Job job;
	
	public Person(Job job) {
		this.job = job;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}

enum Job {
	ENTWICKLER, BERATER, MANAGER;
}