package de.kozdemir.json2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpApiTest {

	private static final String URL = "https://my-json-server.typicode.com/kozdemirhasan/jsonserv";

	public static void main(String[] args) {

		URI uri = URI.create(URL + "/helden");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
//			.thenAccept(System.out::println)
//			.thenAccept(HttpApiTest::computeJson) // one objects
			.thenAccept(HttpApiTest::computeAllJson) // all objects
			.join();

	}
	
	public static void computeJson(String json) {
		Gson gson = new Gson();
		Held held = gson.fromJson(json,Held.class);
//		System.out.println(held);
		System.out.println(held.getVorname() + " "+ held.getNachname());
		
	}
	
	public static void computeAllJson(String json) {
		Gson gson = new Gson();
		List<Held> helden = gson.fromJson(json,new TypeToken<List<Held>>(){}.getType());
		helden.forEach(h -> System.out.println(h.getVorname() + " "+ h.getNachname()));
		
	}

}
