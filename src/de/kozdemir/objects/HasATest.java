package de.kozdemir.objects;

public class HasATest {

	public static void main(String[] args) {
		
		ObjectBox box = new ObjectBox();
		
		box.setContent(new ObjectBox());
		
		box.getContent().setContent(new ObjectBox());
		
		box.getContent().getContent().setContent(new ObjectBox());
		
		
		box.getContent() // 2 ContentBox
			.getContent(); // 3 ContentBox
	}
}
