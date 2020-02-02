package nurbol.seydazimov.services;

import java.util.UUID;
import nurbol.seydazimov.domain.UserEntity;
import nurbol.seydazimov.model.User;
import nurbol.seydazimov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity register(User user) {
        return new UserEntity(
                UUID.randomUUID(),
                user.getUsername(),
                user.getMail(),
                String.format("Hash Of(%s)", user.getPassword())
        );
    }
}
