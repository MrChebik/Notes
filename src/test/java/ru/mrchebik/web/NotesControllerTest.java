package ru.mrchebik.web;

import org.junit.Before;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 09.08.16.
 */
public class NotesControllerTest {
    private List<Note> expectedNotes;
    private NoteRepository mockRepository;
    private NotesController controllerDefault;
    private NotesController controller;
    private MockMvc mockMvcDefault;
    private MockMvc mockMvc;

    @Before
    public void before() {
        expectedNotes = new ArrayList<>();
        mockRepository = mock(NoteRepository.class);
        controllerDefault = new NotesController();
        controller = new NotesController(mockRepository);
        mockMvcDefault = standaloneSetup(controllerDefault).build();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testNotesPage() throws Exception {
        mockMvcDefault.perform(get("/notes")).andExpect(view().name("Notes"));
    }

    @Test
    public void testAddPage() throws Exception {
        expectedNotes.add(new Note("test", "test"));
        when(mockRepository.add(new Note("test", "test"))).thenReturn(expectedNotes.get(0));

        mockMvc.perform(get("/notes/add")).andExpect(view().name("AddNote"));

        expectedNotes.clear();
    }

    @Test
    public void testViewPage() throws Exception {
        for (int i = 0; i < 20; i++) {
            expectedNotes.add(0, new Note("test", "test"));
        }

        when(mockRepository.findNotes(0)).thenReturn(expectedNotes);

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

        expectedNotes.clear();
    }
}