package ru.mrchebik.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.entity.Note;
import ru.mrchebik.session.UserSession;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mrchebik on 07.08.16.
 */
@Controller
@RequestMapping("/notes/view")
public class ViewNotesController {
    private NoteRepository noteRepository;

    @Autowired
    public ViewNotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping(method = GET)
    public String view(@RequestParam(value = "hide", defaultValue = "1") int page,
                       Model model) {

        List<Note> notes = new ArrayList<>(noteRepository.findNotes(UserSession.getId()));
        UserSession.setPages(notes, UserSession.getCount());

        if (notes.size() > UserSession.getCount()) {
            if (page * UserSession.getCount() > notes.size()) {
                notes = notes.subList((page - 1) * UserSession.getCount(), notes.size());
            } else {
                notes = notes.subList((page - 1) * UserSession.getCount(), page * UserSession.getCount());
            }
        }

        model.addAttribute("notes", notes);
        model.addAttribute("page", page);
        model.addAttribute("pages", UserSession.getPages());

        return "ViewNotes";
    }
}