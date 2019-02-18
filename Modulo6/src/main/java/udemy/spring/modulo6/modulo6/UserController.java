package udemy.spring.modulo6.modulo6;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> getUsers() {
        User user = new User();
        List<User> list = new ArrayList<>();
        list.add(new User("A", "a@a.com"));
        list.add(new User("B", "b@a.com"));
        list.add(new User("C", "c@b.com"));
        return list;
    }

    @RequestMapping(value = "user/{name}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable String name) {
        User user = new User();
        List<User> list = new ArrayList<>();
        list.add(new User("A", "a@a.com"));
        list.add(new User("B", "b@a.com"));
        list.add(new User(name, "c@b.com"));
        return list;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User setUser(@RequestBody User user) {
        return user;
    }

}
