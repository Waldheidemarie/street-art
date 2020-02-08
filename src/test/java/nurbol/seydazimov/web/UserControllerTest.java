package nurbol.seydazimov.web;

import nurbol.seydazimov.domain.UserEntity;
import nurbol.seydazimov.model.User;
import nurbol.seydazimov.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    void registerPostRequestTest() {
        User user = new User(
                "fake_username",
                "fake_mail@mail.mail",
                "fake_password"
        );

        UUID fakeId = UUID.randomUUID();
        UserEntity expectedUserEntity = new UserEntity(
                fakeId,
                user.getUsername(),
                user.getMail(),
                String.format("Hash Of(%s)", user.getPassword())
        );

        Mockito.when(userService.register(user)).thenReturn(expectedUserEntity);

        UserEntity resultUserEntity = userController.register(user);

        Assertions.assertEquals(expectedUserEntity, resultUserEntity);
    }
}
