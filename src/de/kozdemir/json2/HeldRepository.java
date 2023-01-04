package de.kozdemir.json2;

import java.time.LocalDateTime;
import java.util.List;

public class HeldRepository {
	
	private List<Held> cache;
	private LocalDateTime cacheTime;
	
	public List<Held> getAll() throws Exception {
		
		if(cache == null || !Utils.fresh(cacheTime)) {
			String json = Utils.requestJson("helden");
			cache = Utils.computeAll(json, Held[].class);
			cacheTime = LocalDateTime.now();
		}
		return cache;
	}
	
	public Held getOne(int id) throws Exception {
		String json = Utils.requestJson("helden", id + "");
		return Utils.computeOne(json, Held.class);
	}
}
