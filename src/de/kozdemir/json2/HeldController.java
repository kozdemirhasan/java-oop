package de.kozdemir.json2;

public class HeldController {
	
	private HeldRepository repo = new HeldRepository();
	
	public void getAll() throws Exception {
		for(Held h : repo.getAll()) {
			System.out.println(h.getVorname());
		}
	}
	
	public void getOne(int id) throws Exception {
		System.out.println(repo.getOne(id));
	}
}
