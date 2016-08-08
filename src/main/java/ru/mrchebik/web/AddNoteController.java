package ru.mrchebik.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;
import ru.mrchebik.session.UserSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 08.08.16.
 */
@Controller
@RequestMapping("/notes/add")
public class AddNoteController {
    private NoteRepository noteRepository;

    @Autowired
    public AddNoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(method = GET)
    public String Get() {
        return "AddNote";
    }

    @RequestMapping(method = POST)
    public String add(@RequestParam String title,
                      @RequestParam String text) {
        try {
            noteRepository.add(new Note(UserSession.getId(), title, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AddNote";
    }
}
