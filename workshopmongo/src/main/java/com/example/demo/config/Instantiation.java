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
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.CommentDTO;
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

		this.user_repository.saveAll(Arrays.asList(maria, alex, bob));

		Post post_1 = instanceatePost();
		post_1.setId(null);
		post_1.setDate(simple_date_format.parse("21/03/2018"));
		post_1.setTitle("Partiu viagem");
		post_1.setBody("Vou viajar para São Paulo. Abraços!");
		post_1.setAuthor(instanceateAuthorDTO(maria));
		
		Post post_2 = instanceatePost();
		post_2.setId(null);
		post_2.setDate(simple_date_format.parse("23/03/2018"));
		post_2.setTitle("Bom dia");
		post_2.setBody("Acordei feliz hoje!");
		post_2.setAuthor(instanceateAuthorDTO(maria));
		
		CommentDTO comment_1 = instanceateCommentDTO();
		comment_1.setText("Boa viagem mano!");
		comment_1.setDate(simple_date_format.parse("21/03/2018"));
		comment_1.setAuthor(instanceateAuthorDTO(alex));
		
		CommentDTO comment_2 = instanceateCommentDTO();
		comment_2.setText("Aproveita");
		comment_2.setDate(simple_date_format.parse("22/03/2018"));
		comment_2.setAuthor(instanceateAuthorDTO(bob));
		
		CommentDTO comment_3 = instanceateCommentDTO();
		comment_3.setText("Tenha um ótimo dia!");
		comment_3.setDate(simple_date_format.parse("23/03/2018"));
		comment_3.setAuthor(instanceateAuthorDTO(alex));
		
		post_1.getComents().addAll(Arrays.asList(comment_1, comment_2));
		post_2.getComents().addAll(Arrays.asList(comment_3));
		
		this.post_repository.saveAll(Arrays.asList(post_1, post_2));
		
		maria.getPosts().addAll(Arrays.asList(post_1, post_2));
		
		this.user_repository.save(maria);
	}

	private CommentDTO instanceateCommentDTO() {
		return new CommentDTO();
	}

	private AuthorDTO instanceateAuthorDTO(User obj) {
		return new AuthorDTO(obj);
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
