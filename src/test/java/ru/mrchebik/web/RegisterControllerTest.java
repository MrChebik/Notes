package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrchebik.data.UserRepository;
import ru.mrchebik.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 09.08.16.
 */
public class RegisterControllerTest {
    @Test
    public void testRegisterPage() throws Exception {
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User("test", "test"));
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findUser("test")).thenReturn(expectedUsers.get(0));
        when(mockRepository.add(new User("test", "test"))).thenReturn(expectedUsers.get(0));

        RegisterController controller = new RegisterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/register")).andExpect(view().name("SignInUp"));
    }
}