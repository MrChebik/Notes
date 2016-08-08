package ru.mrchebik.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;

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
public class AddNoteControllerTest {
    @Test
    public void testAddNotePage() throws Exception {
        List<Note> expectedNotes = new ArrayList<>();
        expectedNotes.add(new Note("test", "test"));
        NoteRepository mockRepository = mock(NoteRepository.class);
        when(mockRepository.add(new Note("test", "test"))).thenReturn(expectedNotes.get(0));

        AddNoteController controller = new AddNoteController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/notes/add")).andExpect(view().name("AddNote"));
    }
}