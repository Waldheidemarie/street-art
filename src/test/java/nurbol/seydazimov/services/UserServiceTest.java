package nurbol.seydazimov.services;

import nurbol.seydazimov.domain.UserEntity;
import nurbol.seydazimov.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

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
