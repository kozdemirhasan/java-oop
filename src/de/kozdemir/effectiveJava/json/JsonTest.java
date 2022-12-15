package de.kozdemir.effectiveJava.json;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		User user = new User();
		user.setId(34);
		user.setName("Eric Clapton");
		
	

		String filePatch = "D:\\JAVA\\java-projects\\javaOOP\\src\\de\\kozdemir\\effectiveJava\\json\\user.json";

		File file = new File(filePatch);
		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(file, user);

		User deserilizedUser = mapper.readValue(new File(filePatch), User.class);
		System.out.println(deserilizedUser.toString());

	}

}

class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}

}