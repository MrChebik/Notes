package ru.mrchebik.web;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrchebik.data.UserRepository;
import ru.mrchebik.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 09.08.16.
 */
public class RegisterControllerTest {
    private static MockMvc mockMvc;

    @BeforeClass
    public static void before() {
        RegisterController controllerDefault = new RegisterController();
        mockMvc = standaloneSetup(controllerDefault).build();
    }

    @Test
    public void testRegisterPage() throws Exception {
        List<User> expectedUsers = new ArrayList<>();
        User user = new User("test", "test");
        expectedUsers.add(user);
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.add(user)).thenReturn(user);
        when(mockRepository.findUser(user.getUsername())).thenReturn(expectedUsers.get(0));

        RegisterController controller = new RegisterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/register")
                .param("username", "test")
                .param("password", "test"))
                .andExpect(redirectedUrl(null));

        //verify(mockRepository, atLeastOnce()).add(user);
        //verify(mockRepository, atLeastOnce()).findUser(user.getUsername());
    }

    @Test
    public void testDuplicatePage() throws Exception {
        mockMvc.perform(get("/register/duplicate")).andExpect(view().name("Duplicate"));
    }

    @Test
    public void testNotRegisterPage() throws Exception {
        mockMvc.perform(get("/register/notExists")).andExpect(view().name("NotRegister"));
    }
}