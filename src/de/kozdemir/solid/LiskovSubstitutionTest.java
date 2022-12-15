package de.kozdemir.solid;

public class LiskovSubstitutionTest {

	public static void main(String[] args) {
		
		GeoForm gf1 = new GeoForm();
		gf1.setWidth(100);
		gf1.setHeight(100);
		
		gf1 = new SquareForm();
		gf1.setWidth(100);
		gf1.setHeight(100);

	}
}

class GeoForm {
	
	private double height;
	private double width;
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}

class SquareForm extends GeoForm {
	
	@Override // gibt es in der Elternklasse eine Methode mit gleicher Signatur?
	public void setHeight(double height) {
		super.setHeight(height);
		super.setWidth(height);
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}
}
