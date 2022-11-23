package de.kozdemir.database2;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User extends AbstractEntity {
	/* id kommt aus AbstractEntity class */

	private String firstname;

	private String lastname;

	public User() {
	}

	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User(int id, String firstname, String lastname) {
		this(firstname, lastname);
		setId(id);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE); //JSON format
	}
}
