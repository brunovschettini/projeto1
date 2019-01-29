package natan.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import natan.io.projeto1.entity.User;
import natan.io.projeto1.entity.UserMongo;
import natan.io.projeto1.repository.UserMongoRepository;
import natan.io.projeto1.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMongoRepository userMongoRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

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

		// user.setEmail("brunovschettini@outlook.com");
		// userRepository.save(user);

		// MYSQL JPA

		System.out.println("Equals: " + user.getName());

		user = userRepository.findByNameAnywhere("Maria");

		System.out.println("Anywhere: " + user.getName());

		user = userRepository.findByNameContains("Ma");

		System.out.println("EndsWiths: " + user.getName());

		user = userRepository.findByEmail("bruno.vsilva@outlook.com");

		System.out.println("Email: " + user.getName());

		user = userRepository.findByNameIgnoreCase("bruno");

		if (user != null) {
			System.out.println("IgnoreCase" + user.getName());
		}

		// MONGO DB TEST

		List<UserMongo> usersMongo = userMongoRepository.findAll();

		if (usersMongo.isEmpty()) {

			createUserMongo("Bruno", "bruno.vsilva@outlook.com");
			createUserMongo("Maria", "maria@outlook.com");
			createUserMongo("José", "jose@outlook.com");

		}

		UserMongo userMongo = userMongoRepository.findByName("Maria");

		System.out.println("Equals: " + userMongo.getName());
		
		userMongo = userMongoRepository.findByNameIgnoreCaseLike("mari");

		System.out.println("Like: " + userMongo.getName());
		
		userMongo = userMongoRepository.findByEmailAnywhere("bruno.vsilva@outlook.com");

		System.out.println("Anywhere email: " + userMongo.getEmail());

	}

	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

	public void createUserMongo(String name, String email) {
		UserMongo userMongo = new UserMongo(name, email);
		userMongoRepository.save(userMongo);
	}

}
