package de.kozdemir.uebung09_todolist;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Todo implements Serializable , Comparable<Todo>{
	
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titel;
	private LocalDateTime erzeugungsDate;
	private boolean status;
	
		
//	getter and setter methode	
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

	public LocalDateTime getErzeugungsDate() {
		return erzeugungsDate;
	}

	public void setErzeugungsDate(LocalDateTime erzeugungsDate) {
		this.erzeugungsDate = erzeugungsDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//nicht nötig für diese App
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Todo [titel=").append(titel).append(", erzeugungsDate=")
				.append(erzeugungsDate).append(", status=").append(status).append("]");
		return builder.toString();
	}

//	//Sortierung - Erzeugsdatum
//	@Override
//	public int compareTo(Todo o) {		
//		return titel.compareTo(o.getTitel());
//	}
	
	
	//Sortierung - Date
		@Override
		public int compareTo(Todo o) {		
//			return erzeugungsDate.compareTo(o.getErzeugungsDate());
			return o.getErzeugungsDate().compareTo(erzeugungsDate);
		}
}