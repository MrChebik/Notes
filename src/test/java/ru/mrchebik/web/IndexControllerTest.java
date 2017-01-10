package ru.mrchebik.web;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 21.12.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration("file:**/servet-context.xml"),
        @ContextConfiguration("file:**/security.xml")
})
@WebAppConfiguration("webapp/WEB-INF/spring/appServlet")
public class IndexControllerTest {
    private static MockMvc mockMvc;

    @BeforeClass
    public static void setup() {
        IndexController indexController = new IndexController();
        mockMvc = standaloneSetup(indexController).build();
    }

    @Test
    public void testIndexPageName() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testAccessDeniedPageName() throws Exception {
        mockMvc.perform(get("/accessDenied"))
                .andExpect(view().name("AccessDenied"));
    }
}