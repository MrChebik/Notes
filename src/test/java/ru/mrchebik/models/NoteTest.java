package ru.mrchebik.models;

import org.junit.Test;
import ru.mrchebik.store.Notes_CACHE;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 21.07.16.
 */
public class NoteTest {

    final Note note = new Note("test1", "test2");

    @Test
    public void getTitle() throws Exception {
        assertNotNull(note.getTitle());
        assertEquals("test1", note.getTitle());
    }

    @Test
    public void getText() throws Exception {
        assertNotNull(note.getText());
        assertEquals("test2", note.getText());
    }

}