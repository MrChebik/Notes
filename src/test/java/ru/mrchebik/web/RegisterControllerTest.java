package ru.mrchebik.web;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrchebik.model.User;
import ru.mrchebik.service.UserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 23.12.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/servlet-context.xml")
@WebAppConfiguration("webapp/WEB-INF/spring/appServlet")
public class RegisterControllerTest {
    private static MockMvc mockMvc;
    private static UserService mockService;

    @BeforeClass
    public static void setup() {
        mockService = mock(UserService.class);

        RegisterController registerController = new RegisterController(mockService);
        mockMvc = standaloneSetup(registerController).build();
    }

    @Test
    public void testRegisterPageName() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(view().name("SignInUp"));
    }

    @Test
    public void testDuplicatePageName() throws Exception {
        mockMvc.perform(get("/register/duplicate"))
                .andExpect(view().name("Duplicate"));
    }

    @Test
    public void testNotExistsPageName() throws Exception {
        mockMvc.perform(get("/register/notExists"))
                .andExpect(view().name("NotRegister"));
    }

    @Test
    public void testRegisterPageLogic_Duplicate() throws Exception {
        when(mockService.add(Matchers.any(User.class))).thenThrow(new DataIntegrityViolationException(""));

        mockMvc.perform(post("/register")
                .param("hide", "up")
                .param("username", "Jorg")
                .param("password", "Brush"))
                .andExpect(redirectedUrl("/register/duplicate"));

        Mockito.verify(mockService, atLeastOnce()).add(Matchers.any(User.class));
    }

    @Test
    public void testRegisterPageLogic_NotExists() throws Exception {
        when(mockService.findUser(Matchers.anyString())).thenReturn(null);

        mockMvc.perform(post("/register")
                .param("hide", "in")
                .param("username", "Jorg")
                .param("password", "Brush"))
                .andExpect(redirectedUrl("/register/notExists"));

        Mockito.verify(mockService, atLeastOnce()).findUser(Matchers.anyString());
    }

    @Test
    public void testRegisterPageLogic_Register() throws Exception {
        when(mockService.findUser(Matchers.anyString())).thenReturn(new User("test", "test"));

        mockMvc.perform(post("/register")
                .param("hide", "in")
                .param("username", "Jorg")
                .param("password", "Brush"))
                .andExpect(redirectedUrl("/notes/test"));

        Mockito.verify(mockService, atLeastOnce()).findUser(Matchers.anyString());
    }
}