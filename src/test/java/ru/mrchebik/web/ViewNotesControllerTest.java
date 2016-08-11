package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 07.08.16.
 */
public class ViewNotesControllerTest {
    @Test
    public void view() throws Exception {
        List<Note> expectedNotes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            expectedNotes.add(0, new Note("test", "test"));
        }

        NoteRepository mockRepository = mock(NoteRepository.class);
        when(mockRepository.findNotes(0)).thenReturn(expectedNotes);

        ViewNotesController controller = new ViewNotesController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        if (expectedNotes.size() > 10) {
            if (1 * 10 > expectedNotes.size()) {
                expectedNotes = expectedNotes.subList(0, expectedNotes.size());
            } else {
                expectedNotes = expectedNotes.subList(0, 10);
            }
        }
        assertEquals(expectedNotes.size(), 10);

        mockMvc.perform(get("/notes/view"))
                .andExpect(MockMvcResultMatchers.view().name("ViewNotes"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("notes"))
                .andExpect(MockMvcResultMatchers.model().attribute("notes", expectedNotes))
                .andExpect(MockMvcResultMatchers.model().attributeExists("page"))
                .andExpect(MockMvcResultMatchers.model().attribute("page", 1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pages"))
                .andExpect(MockMvcResultMatchers.model().attribute("pages", 2));
    }
}
