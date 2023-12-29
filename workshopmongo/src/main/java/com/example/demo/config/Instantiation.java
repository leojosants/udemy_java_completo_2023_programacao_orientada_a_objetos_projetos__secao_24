/*------------------- packages -------------------*/
package com.example.demo.config;

/*------------------- imports -------------------*/
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

/*------------------- class Instantiation -------------------*/
@Configuration
public class Instantiation implements CommandLineRunner {
	
	/*------------------- attributes -------------------*/
	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private PostRepository post_repository;

	/*------------------- methods -------------------*/
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat simple_date_format = instanceateSimpleDateFormat();
		simple_date_format.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		this.user_repository.deleteAll();
		this.post_repository.deleteAll();
		
		User maria = instanceateUser();
		maria.setId(null); 
		maria.setName("Maria Brown");
		maria.setEmail("maria@gmail.com");
		
		User alex = instanceateUser();
		alex.setId(null); 
		alex.setName("Alex Green");
		alex.setEmail("alex@gmail.com");
		
		User bob = instanceateUser();
		bob.setId(null); 
		bob.setName("Bob Grey");
		bob.setEmail("bob@gmail.com");

		Post post_1 = instanceatePost();
		post_1.setId(null);
		post_1.setId("21/03/2018");
		post_1.setTitle("Partiu viagem");
		post_1.setBody("Vou viajar para São Paulo. Abraços!");
		post_1.setAuthor(maria);
		
		Post post_2 = instanceatePost();
		post_2.setId(null);
		post_2.setId("23/03/2018");
		post_2.setTitle("Bom dia");
		post_2.setBody("Acordei feliz hoje!");
		post_2.setAuthor(maria);
		
		this.user_repository.saveAll(Arrays.asList(maria, alex, bob));
		this.post_repository.saveAll(Arrays.asList(post_1, post_2));
	}

	private SimpleDateFormat instanceateSimpleDateFormat() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}

	private Post instanceatePost() {
		return new Post();
	}

	private User instanceateUser() {
		return new User();
	}
}
