package natan.io.projeto1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import natan.io.projeto1.entity.UserMongo;
import natan.io.projeto1.repository.UserMongoRepository;


// Serviçe é uma camada de negócios/negocial 

@Service
public class UserService {
	
	@Autowired
	UserMongoRepository userRepository;
	
	public List<UserMongo> findAll() {
		return userRepository.findAll();		
	}
	
	

}
