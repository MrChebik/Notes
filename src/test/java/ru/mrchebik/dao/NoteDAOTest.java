package ru.mrchebik.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.mrchebik.entity.Note;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 03.08.16.
 */
public class NoteDAOTest {
    private static final NoteDAO noteDAO = new NoteDAO();

    @BeforeClass
    public static void add() {
        noteDAO.add(new Note(0, "test", "test"));
    }

    @Test
    public void addAndGet() throws Exception {
        assertEquals(noteDAO.findNotes(0).get(0).getTitle(), "test");
        assertEquals(noteDAO.findNotes(0).get(0).getText(), "test");
    }
}