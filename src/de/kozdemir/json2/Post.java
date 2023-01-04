package de.kozdemir.json2;

public class Post {

	private int id;
	
	private String titel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post [id=");
		builder.append(id);
		builder.append(", titel=");
		builder.append(titel);
		builder.append("]");
		return builder.toString();
	}
}
