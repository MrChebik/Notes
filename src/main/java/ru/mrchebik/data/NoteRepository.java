package ru.mrchebik.data;

import ru.mrchebik.entity.Note;

import java.util.List;

/**
 * Created by mrchebik on 07.08.16.
 */
public interface NoteRepository {
    Object add(final Note note);

    List<Note> findNotes(final long id);
}
