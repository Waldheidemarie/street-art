package nurbol.seydazimov.web;

import nurbol.seydazimov.domain.UserEntity;
import nurbol.seydazimov.model.User;
import nurbol.seydazimov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserEntity register(@RequestBody  User user) {
        return userService.register(user);
    }
}
