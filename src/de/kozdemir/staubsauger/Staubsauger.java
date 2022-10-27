package de.kozdemir.staubsauger;

public class Staubsauger {
	
	 private String staubsaugerName;		
	 private Beutel beutel;
	
	
	public Staubsauger(String staubsaugerName, int maxCapacity) {
		this.staubsaugerName = staubsaugerName;
		beutel = new Beutel(maxCapacity);
	}

	public void saugen(int dreck) throws BeutelVollException {
		if(beutel.fuellen(dreck)) {
			throw new BeutelVollException();
		}
	}
	
	public int getBeutelInhalt(){
		return beutel.getdreckImBeutel();
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Staubsauger [staubsaugerName=")
				.append(staubsaugerName).append(", Max Capacity= ")
				.append(beutel.getMAX_CAPACITY())
//				.append(", getBeutelInhalt()=")
//				.append(getBeutelInhalt())
				.append("]");
		return builder.toString();
	}
	
	


	
	
	

}
