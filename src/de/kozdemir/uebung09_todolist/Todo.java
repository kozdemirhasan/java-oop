package de.kozdemir.uebung09_todolist;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Todo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id=0;
	private String titel;
	private LocalDateTime erzeugungsDate;
	private Boolean status;
	
		
//	getter and setter methode	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
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

}