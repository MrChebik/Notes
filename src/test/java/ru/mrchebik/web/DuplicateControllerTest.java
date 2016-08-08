package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 09.08.16.
 */
public class DuplicateControllerTest {
    @Test
    public void testDuplicatePage() throws Exception {
        DuplicateController controller = new DuplicateController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/duplicate")).andExpect(view().name("Duplicate"));
    }
}