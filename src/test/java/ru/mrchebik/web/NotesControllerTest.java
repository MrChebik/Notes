package ru.mrchebik.web;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.mrchebik.dao.UserDAO;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;
import ru.mrchebik.entity.User;
import ru.mrchebik.session.UserSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by mrchebik on 09.08.16.
 */
public class NotesControllerTest {
    private static List<Note> expectedNotes;
    private static NoteRepository mockRepository;
    private static MockMvc mockMvc;

    @BeforeClass
    public static void before() {
        expectedNotes = new ArrayList<>();
        mockRepository = mock(NoteRepository.class);
        NotesController controller = new NotesController(mockRepository);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testNotesPage() throws Exception {
        NotesController controller = new NotesController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/notes/test")).andExpect(view().name("Notes"));
    }

    @Test
    public void testAddPage() throws Exception {
        expectedNotes.add(new Note("test", "test"));
        when(mockRepository.add(new Note("test", "test"))).thenReturn(expectedNotes.get(0));

        mockMvc.perform(get("/notes/test/add")).andExpect(view().name("AddNote"));

        mockMvc.perform(post("/notes/test/add")
                .param("title", "title")
                .param("test", "text"))
                .andExpect(redirectedUrl(null));

        //verify(mockRepository, atLeastOnce()).add(new Note("test", "test"));
    }

    @Test
    public void testViewPage() throws Exception {
        User user = new User("test", "test");
        UserDAO userDAO = new UserDAO();
        User demo = userDAO.findUser(user.getUsername());

        for (int i = 0; i < 20; i++) {
            expectedNotes.add(0, new Note("test", "test"));
        }

        when(mockRepository.findNotes(userDAO.findUser(user.getUsername()).getUSER_ID())).thenReturn(expectedNotes);

        if (expectedNotes.size() > 10) {
            if (10 > expectedNotes.size()) {
                expectedNotes = expectedNotes.subList(0, expectedNotes.size());
            } else {
                expectedNotes = expectedNotes.subList(0, 10);
            }
        }
        assertEquals(expectedNotes.size(), 10);

        UserSession.setUser(demo);

        mockMvc.perform(get("/notes/test/view"))
                .andExpect(MockMvcResultMatchers.view().name("ViewNotes"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("notes"))
                .andExpect(MockMvcResultMatchers.model().attribute("notes", expectedNotes))
                .andExpect(MockMvcResultMatchers.model().attributeExists("page"))
                .andExpect(MockMvcResultMatchers.model().attribute("page", 1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pages"))
                .andExpect(MockMvcResultMatchers.model().attribute("pages", 2));
    }

    @After
    public void after() {
        expectedNotes.clear();
    }
}