package nurbol.seydazimov.web;

import java.util.List;
import java.util.UUID;
import nurbol.seydazimov.domain.User;
import nurbol.seydazimov.exceptions.UserNotFoundException;
import nurbol.seydazimov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/user")
    public User addUser(
            @RequestBody User user
    ) {
        return userRepository.save(
                new User(UUID.randomUUID(), user.getUsername(), user.getEmail())
        );
    }

    @GetMapping("user/{id}")
    public User getUser(
            @PathVariable UUID id
    ) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("user/{id}")
    public User updateUser(
            @PathVariable UUID id,
            @RequestBody User user
    ) {
        return userRepository.save(new User(id, user.getUsername(), user.getEmail()));
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(
            @PathVariable UUID id
    ) {
        userRepository.deleteById(id);
    }
}
