package de.kozdemir.json2;

import java.time.LocalDateTime;
import java.util.List;

public class PostController {
	
	private List<Post> cache;
	private LocalDateTime cacheTime;
	
	
	public void getAll() throws Exception {
		String json = Utils.requestJson("posts");
		cache = Utils.computeAll(json, Post[].class);
		cacheTime = LocalDateTime.now(); 
		System.out.println(cache);
	}
		
	
//public void computeOnePostJson(String json) {
//	Post post = gson.fromJson(json, Post.class);
//	System.out.println(post.getId() + " " + post.getTitel());
//}

//public void computeAllPostJson(String json) {
//	List<Post> postsCache = gson.fromJson(json, new TypeToken<List<Post>>(){}.getType());
//	postsCacheTime = LocalDateTime.now();
//	postsCache.forEach(p -> System.out.println(p.getId() + " " + p.getTitel()));
//}
//

}
