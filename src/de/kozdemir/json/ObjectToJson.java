package de.kozdemir.json;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class ObjectToJson {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Held held = new Held("Peter", "Parker", new String[]{"Berlin", "Kiel"}, 33, false);
		System.out.println(gson.toJson(held));
		
		System.out.println();
		
		List<Held> helden = new ArrayList<>();
		helden.add(new Held("Peter", "Parker", new String[]{"Berlin", "Kiel"}, 33, false));
		helden.add(new Held("Hans", "Baner", new String[]{"Kiel"}, 52, true));
		helden.add(new Held("Steve", "Parker", new String[]{"Berlin"}, 31, false));
		
		// Als JSON ausgeben
		System.out.println(gson.toJson(helden));
		
		// JSON in eine Datei schreiben
		try(Writer out = Files.newBufferedWriter(Paths.get("data2.json"), Charset.forName("UTF-8"))) {
			gson.toJson(helden, out);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
