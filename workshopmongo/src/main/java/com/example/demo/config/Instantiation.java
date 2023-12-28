/*------------------- packages -------------------*/
package com.example.demo.config;

/*------------------- imports -------------------*/
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

/*------------------- class Instantiation -------------------*/
@Configuration
public class Instantiation implements CommandLineRunner {
	
	/*------------------- attributes -------------------*/
	@Autowired
	private UserRepository user_repository;

	/*------------------- methods -------------------*/
	@Override
	public void run(String... args) throws Exception {
		this.user_repository.deleteAll();
		
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
	}

	private User instanceateUser() {
		return new User();
	}
}
