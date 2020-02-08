package nurbol.seydazimov.services;

import nurbol.seydazimov.domain.UserEntity;
import nurbol.seydazimov.model.User;
import nurbol.seydazimov.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void test() {
        User user = new User(
                "mock username",
                "mock mail",
                "mock password"
        );

        UserEntity userEntity = userService.register(user);

        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertEquals("mock username", userEntity.getUsername());
        Assertions.assertEquals("mock mail", userEntity.getEmail());
        Assertions.assertEquals("Hash Of(mock password)", userEntity.getHashedPassword());
    }
}
