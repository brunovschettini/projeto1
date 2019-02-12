package natan.io.projeto1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import natan.io.projeto1.entity.UserMongo;
import natan.io.projeto1.repository.UserMongoRepository;
import natan.io.projeto1.services.UserService;

// Responsavel pelo cumnicação model e view
@Controller
public class UserController {

	//@Autowired
	//private UserMongoRepository userRepository;
	
	// @Autowired removo as instâncias desnecessárias, cito o uso do new User(), new blablabla()...
	// Sempre que há injeção de dependência, só conseguirei usar a class como dependência (CDI) via anotação
	// Sendo impossível usar a instancia new. ... é obrigado o @Autowired nos casos @Component, @Controller, @Service, @Model....
	@Autowired
	 UserService userService;
	// Ao usar a anotação @Autowired posso extinguir o uso do método abaixo, pois é adicionada uma anotação
	// como dependência e instância da classe de cotnroller do user	
//	public UserController(UserMongoRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
	// Rota
	// Essa anotação é para mapear a rota
	@RequestMapping("/user")
	public String getUsers(Model model) {
		// Normal
		// List<UserMongo> list = this.userRepository.findAll();
		// Com serviço
		List<UserMongo> list = this.userService.findAll();
		model.addAttribute("usersList", list);
		// model.addAttribute("usersList", this.userRepository.findAll());
		return "user";
	}

}
