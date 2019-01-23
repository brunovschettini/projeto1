package natan.io.projeto1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import natan.io.projeto1.entity.User;
import natan.io.projeto1.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			createUser("Bruno", "bruno.vsilva@outlook.com");
			createUser("Maria", "maria@outlook.com");
			createUser("José", "jose@outlook.com");			
			
		}
		// Pesquisar um ID
		
		User user = userRepository.findByName("Maria");
		
		// Delete Entity
		// userRepository.delete(user);
		// or 
		// userRepository.deleteById(2L);
		
		// Update 
		
		//user.setEmail("brunovschettini@outlook.com");
		//userRepository.save(user);
		
		System.out.println("Equals: " + user.getName());
		
		user = userRepository.findByNameAnywhere("Maria");
		
		System.out.println("Anywhere: " + user.getName());
		
		user = userRepository.findByNameContains("Ma");
		
		System.out.println("EndsWiths: " + user.getName());
		
		user = userRepository.findByEmail("bruno.vsilva@outlook.com");
		
		System.out.println("Email: " + user.getName());
		
	
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

}
