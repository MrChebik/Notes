package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;

import java.util.ArrayList;
import java.util.List;

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
        NoteRepository mockRepository = mock(NoteRepository.class);
        when(mockRepository.findNotes(0)).thenReturn(expectedNotes);

        ViewNotesController controller = new ViewNotesController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/notes/view"))
                .andExpect(MockMvcResultMatchers.view().name("ViewNotes"));
    }
}
