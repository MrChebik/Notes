package ru.mrchebik.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;
import ru.mrchebik.session.UserSession;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 08.08.16.
 */
@Controller
@RequestMapping("/notes")
public class NotesController {
    private NoteRepository noteRepository;

    public NotesController() {

    }

    @Autowired
    public NotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String notes(@PathVariable String username,
                        Model model) {
        model.addAttribute("username", username);
        return "Notes";
    }

    @RequestMapping(value = "/{username}/add", method = GET)
    public String Get(@PathVariable String username,
                      Model model) {
        model.addAttribute("username", username);
        return "AddNote";
    }

    @RequestMapping(value = "/{username}/add", method = POST)
    public String add(@PathVariable String username,
                      @RequestParam String title,
                      @RequestParam String text,
                      Model model) {
        model.addAttribute("username", username);
        try {
            noteRepository.add(new Note(UserSession.getUser(), title, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AddNote";
    }

    @RequestMapping(value = "/{username}/view", method = GET)
    public String view(@PathVariable String username,
                       @RequestParam(value = "hide", defaultValue = "1") int page,
                       @RequestParam(value = "hideId", defaultValue = "0") long id,
                       Model model) {

        if (id != 0) {
            noteRepository.remove(id);
        }

        List<Note> notes = new ArrayList<>(noteRepository.findNotes(UserSession.getUser().getUSER_ID()));
        UserSession.setPages(notes, UserSession.getCount());

        if (notes.size() > UserSession.getCount()) {
            if (page * UserSession.getCount() > notes.size()) {
                notes = notes.subList((page - 1) * UserSession.getCount(), notes.size());
            } else {
                notes = notes.subList((page - 1) * UserSession.getCount(), page * UserSession.getCount());
            }
        }

        model.addAttribute("username", username);
        model.addAttribute("notes", notes);
        model.addAttribute("page", page);
        model.addAttribute("pages", UserSession.getPages());

        return "ViewNotes";
    }
}
