package natan.io.projeto1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import natan.io.projeto1.entity.UserMongo;
import natan.io.projeto1.repository.UserMongoRepository;

// Responsavel pelo cumnicação model e view
@Controller
public class UserController {

	private UserMongoRepository userRepository;

	public UserController(UserMongoRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Essa anotação é para mapear a rota
	@RequestMapping("/user")
	public String getUsers(Model model) {
		List<UserMongo> list = this.userRepository.findAll();
		model.addAttribute("usersList", this.userRepository.findAll());
		return "user";
	}

}
