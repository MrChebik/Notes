package ru.mrchebik.web;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrchebik.model.Note;
import ru.mrchebik.service.NoteService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 23.12.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/servlet-context.xml")
@WebAppConfiguration("webapp/WEB-INF/spring/appServlet")
public class NotesControllerTest {
    private static MockMvc mockMvc;
    private static NoteService mockService;

    @BeforeClass
    public static void setup() {
        mockService = mock(NoteService.class);

        NotesController notesController = new NotesController(mockService);
        mockMvc = standaloneSetup(notesController).build();
    }

    @Test
    public void testNotesPageName() throws Exception {
        mockMvc.perform(get("/notes/test")
                .param("username", "test"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attribute("username", "test"))
                .andExpect(view().name("Notes"));
    }

    @Test
    public void testNotesAddPageName() throws Exception {
        mockMvc.perform(get("/notes/test/add")
                .param("username", "test"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attribute("username", "test"))
                .andExpect(view().name("AddNote"));
    }

    @Test
    public void testNotesExitPageName() throws Exception {
        mockMvc.perform(get("/notes/test/exit"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testNotesViewPageLogic() throws Exception {
        List<Note> expectedListOfNotes = createList(20);

        when(mockService.findNotes(Matchers.anyLong())).thenReturn(expectedListOfNotes);

        mockMvc.perform(get("/notes/test/view")
                .param("username", "test"))
                .andExpect(view().name("ViewNotes"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attribute("username", "test"))
                .andExpect(model().attributeExists("notes"))
                .andExpect(model().attribute("notes", expectedListOfNotes.subList(0, 10)))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attribute("page", 1))
                .andExpect(model().attributeExists("pages"))
                .andExpect(model().attribute("pages", 2));

        verify(mockService, atLeastOnce()).findNotes(Matchers.anyLong());
    }

    public List<Note> createList(int x) {
        List<Note> notes = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            notes.add(new Note(i, "Title" + i, "Text" + i));
        }
        return notes;
    }
}