package ru.mrchebik.service;

import ru.mrchebik.model.Note;

import java.util.List;

/**
 * Created by mrchebik on 02.10.16.
 */
public interface NoteService {
    Note add(final Note note);
    List<Note> findNotes(final long id);
    void remove(final long id);
}
