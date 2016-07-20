package ru.mrchebik.store;

import ru.mrchebik.models.Note;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mrchebik on 19.07.16.
 */
public class Notes_CACHE {

    private static ArrayList<Note> notes = new ArrayList<Note>();

    public static void addNote(final Note note) {
        notes.add(note);
    }

    public static Collection<Note> getNotes() {
        return notes;
    }

    public static void clear() {
        notes.clear();
    }

}
