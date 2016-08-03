package ru.mrchebik.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 04.08.16.
 */
public class NoteTest {
    private final Note note = new Note(0, "test", "test");

    @Test
    public void getTitle() throws Exception {
        assertTrue(note.getTitle().equals("test"));
    }

    @Test
    public void setTitle() throws Exception {
        note.setTitle("test1");
        assertTrue(note.getTitle().equals("test1"));
        note.setTitle("test");
    }

    @Test
    public void getText() throws Exception {
        assertTrue(note.getText().equals("test"));
    }

    @Test
    public void setText() throws Exception {
        note.setText("test1");
        assertTrue(note.getText().equals("test1"));
        note.setText("test");
    }

    @Test
    public void getId() throws Exception {
        assertTrue(note.getId() == 0);
    }

    @Test
    public void setId() throws Exception {
        note.setId(1);
        assertTrue(note.getId() == 1);
        note.setId(0);
    }
}