package nurbol.seydazimov.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class GreetingControllerTest {
    final Model model = new ExtendedModelMap();

    @InjectMocks
    private GreetingController greetingController;

    @Test
    void greetingGetRequestTest() {
        String expectedName = "greeting";
        String result = greetingController.greeting(expectedName, model);
        Assertions.assertEquals(result, "greeting");
    }
}
