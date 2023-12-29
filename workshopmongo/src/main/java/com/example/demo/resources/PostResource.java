/*------------------- packages -------------------*/
package com.example.demo.resources;

/*------------------- imports -------------------*/
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Post;
import com.example.demo.resources.util.URL;
import com.example.demo.services.PostService;

/*------------------- class PostResource -------------------*/
@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	/*------------------- attributes -------------------*/
	@Autowired
	private PostService service;
	
	/*------------------- methods -------------------*/	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {	
		Post obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {	
		text = URL.decodeParam(text);
		List<Post> list = this.service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "min_date", defaultValue = "") String min_date,
			@RequestParam(value = "max_date", defaultValue = "") String max_date
	) {	
		text = URL.decodeParam(text);
		Date min = URL.convertDate(min_date, new Date(0L));
		Date max = URL.convertDate(max_date, new Date());
		List<Post> list = this.service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
