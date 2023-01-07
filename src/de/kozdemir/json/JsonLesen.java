package de.kozdemir.json;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonLesen {

	public static void main(String[] args) {
		
	Gson gson = new Gson();
		
		try(Reader in = Files.newBufferedReader(Paths.get("data2.json"))) {
			
//			Map<?, ?> map = gson.fromJson(in, Map.class);
//			
//			for(Map.Entry<?, ?> e : map.entrySet()) {
//				System.out.println(e.getKey() + " = " + e.getValue());
//			}
			
			
//			// Einen Held einlesen
//			Held held = gson.fromJson(in, Held.class);
//			System.out.println(held);
			
			
			List<Held> helden = gson.fromJson(in, new TypeToken<List<Held>>(){}.getType()); //mit Array
			helden.forEach(System.out::println);
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
