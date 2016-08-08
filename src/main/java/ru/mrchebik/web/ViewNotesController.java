package ru.mrchebik.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mrchebik.data.NoteRepository;
import ru.mrchebik.session.UserSession;

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
    public String view(Model model) {
        model.addAttribute("notes", noteRepository.findNotes(UserSession.getId()));
        return "ViewNotes";
    }
}