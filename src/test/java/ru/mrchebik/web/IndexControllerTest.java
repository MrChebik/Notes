package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 06.08.16.
 */
public class IndexControllerTest {
    @Test
    public void testRegisterStagePage() throws Exception {
        IndexController controller = new IndexController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }
}
