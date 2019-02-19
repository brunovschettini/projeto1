package natan.io.projeto1.config;

import java.util.List;
import natan.io.projeto1.entity.Role;
import natan.io.projeto1.entity.StatusRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import natan.io.projeto1.entity.User;
import natan.io.projeto1.repository.RoleRepository;
import natan.io.projeto1.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
//
//    @Autowired
//    UserMongoRepository userMongoRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            Role roleAtivo = setRole("Admin", StatusRole.ATIVO);
            createUser("Bruno", "bruno.vsilva@outlook.com", roleAtivo);
            Role roleInativo = setRole("Admin", StatusRole.INATIVO);
            createUser("Maria", "maria@outlook.com", roleInativo);
        }
        

        // Estudos sobre páginação
        for (int i = 0; i < 1000; i++) {
            createRole("Admin " + i, StatusRole.ATIVO);
        }
        for (int i = 0; i < 1000; i++) {
            createRole("Anything " + i, StatusRole.INATIVO);
        }

        PageRequest pageRequest = PageRequest.of(10, 10);

        Page<Role> roles = this.roleRepository.findAll(pageRequest);
        roles.stream().forEach((t) -> {
            System.out.println("Name: " + t.getName() + " - Status: " + t.getStatus().name());
        });


        // Pesquisar um ID
        User user = userRepository.findByName("Maria");
        
        
        // Persistência aula 46
        Role role1 = new Role("Novo Adlin", StatusRole.ATIVO);
        User newUSer = new User("João", "joao@silva.com.br", role1);
        userRepository.save(newUSer);
        
        System.out.println(newUSer.getRole().getName());

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
//        List<Role> listRoles = roleRepository.findByStatus(StatusRole.ATIVO);
//        if (user != null) {
//            for (int i = 0; i < listRoles.size(); i++) {
//                System.out.println(listRoles.get(i).getName());
//            }
//        }
        // MONGO DB TEST
//		List<UserMongo> usersMongo = userMongoRepository.findAll();
//
//		if (usersMongo.isEmpty()) {
//
//			createUserMongo("Bruno", "bruno.vsilva@outlook.com");
//			createUserMongo("Maria", "maria@outlook.com");
//			createUserMongo("José", "jose@outlook.com");
//
//		}
//
//		UserMongo userMongo = userMongoRepository.findByName("Maria");
//
//		System.out.println("Equals: " + userMongo.getName());
//		
//		userMongo = userMongoRepository.findByNameIgnoreCaseLike("mari");
//
//		System.out.println("Like: " + userMongo.getName());
//		
//		userMongo = userMongoRepository.findByEmailAnywhere("bruno.vsilva@outlook.com");
//
//		System.out.println("Anywhere email: " + userMongo.getEmail());
    }

    public void createUser(String name, String email, Role role) {
        User user = new User(name, email, role);
        userRepository.save(user);
    }

    public Role setRole(String name, StatusRole status) {
        Role role = new Role(name, status);
        return role;
        // return roleRepository.save(role);
    }
    
    public Role createRole(String name, StatusRole status) {
        Role role = new Role(name, status);
        return roleRepository.save(role);
    }

//	public void createUserMongo(String name, String email) {
//		UserMongo userMongo = new UserMongo(name, email);
//		userMongoRepository.save(userMongo);
//	}
}
