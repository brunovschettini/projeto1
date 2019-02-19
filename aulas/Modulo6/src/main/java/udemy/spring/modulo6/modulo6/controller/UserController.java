package udemy.spring.modulo6.modulo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import udemy.spring.modulo6.modulo6.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getUser(Model model) {
        model.addAttribute("user", new User("A", "a@a.com"));
        return "user";
    }

    @PostMapping("/user")
    public String userSubmit(@ModelAttribute User user) {
        return "result";
    }

}
