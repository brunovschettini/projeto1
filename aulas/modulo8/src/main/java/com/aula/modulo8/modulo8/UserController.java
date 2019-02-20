package com.aula.modulo8.modulo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    public User getUser() {
        User user = new User("paula", "paula@uol.com.br");
        return user;
    }


    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public User getOneUser() {
        User user = new User("paula", "paula@uol.com.br");
        return user;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
