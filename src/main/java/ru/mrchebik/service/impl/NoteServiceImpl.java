package ru.mrchebik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.Note;
import ru.mrchebik.repository.NoteRepository;
import ru.mrchebik.service.NoteService;

import java.util.List;

/**
 * Created by mrchebik on 02.10.16.
 */
@Service
@Repository
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note add(final Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @Override
    public List<Note> findNotes(final long userId) {
        return noteRepository.findById(userId);
    }

    @Override
    public void remove(final long id) {
        noteRepository.delete(id);
    }
}
