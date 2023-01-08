package de.kozdemir.json2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Utils {
	
	private static final String URL = "https://my-json-server.typicode.com/kozdemirhasan/jsonserv";
	
	private static final Gson gson = new Gson();

	public static String requestJson(String... part) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		
		StringBuilder sb = new StringBuilder(URL);
		
		for(String p : part) {
			sb.append("/").append(p);
		}
		
		URI uri = URI.create(sb.toString());
		HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
		return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
	}
	
	public static <T> List<T> computeAll(String json, Class<T[]> t) {
		return Arrays.asList(gson.fromJson(json, t));
	}
	
	public static <T> T computeOne(String json, Class<T> t) {
		return gson.fromJson(json, t);
	}
	
	public static boolean fresh(LocalDateTime time) {
		if(time == null)
			return false;
		
		return LocalDateTime.now().isBefore(time.plusSeconds(30)); 
	}
}
