package ru.mrchebik.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.mrchebik.model.Note;
import ru.mrchebik.model.User;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 03.08.16.
 */
public class NoteDAOTest {
    private static final NoteDAO noteDAO = new NoteDAO();
    private static final User user = new User("test", "test");
    private static long id;

    @BeforeClass
    public static void add() {
        UserDAO userDAO = new UserDAO();
        User userDemo = userDAO.findUser(user.getUsername());
        try {
            if (userDemo.getUsername().equals("test"));
        } catch (NoSuchElementException e) {
            userDAO.add(user);
        }
        id = userDAO.findUser(user.getUsername()).getUSER_ID();
        noteDAO.add(new Note(userDemo, "testTitle", "testText"));
    }

    @Test
    public void addAndGet() throws Exception {
        assertEquals(noteDAO.findNotes(id).get(0).getTitle(), "testTitle");
        assertEquals(noteDAO.findNotes(id).get(0).getText(), "testText");
    }
}