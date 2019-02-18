package natan.io.projeto1.services;

import java.util.List;
import natan.io.projeto1.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natan.io.projeto1.repository.UserRepository;

// Serviçe é uma camada de negócios/negocial 
@Service
public class UserService {
//	
//	@Autowired
//	UserMongoRepository userRepository;

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
