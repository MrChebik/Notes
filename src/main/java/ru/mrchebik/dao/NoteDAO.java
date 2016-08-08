package ru.mrchebik.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.command.CommandFactory;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrchebik on 23.07.16.
 */
@Service
@Transactional
public class NoteDAO extends DAO implements NoteRepository {

    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public Object add(final Note note) {
        return commandFactory.transaction(() -> {
            getSession().save(note);
            return null;
        });
    }

    @Override
    public List<Note> findNotes(final long id) {
        return commandFactory.transaction(() -> {
            Query query = getSession().createQuery("select N.title, N.text from ru.mrchebik.entity.Note N where id = :id").setLong("id", id);
            List<Note> note = new ArrayList<Note>();
            Iterator itr = query.list().iterator();
            while (itr.hasNext()) {
                Object[] objects = (Object[]) itr.next();

                String title = String.valueOf(objects[0]);
                String text = String.valueOf(objects[1]);

                note.add(new Note(title, text));
            }
            return note;
        });
    }
}
