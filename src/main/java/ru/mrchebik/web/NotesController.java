package ru.mrchebik.web;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.model.Note;
import ru.mrchebik.service.NoteService;
import ru.mrchebik.service.UserService;
import ru.mrchebik.session.UserSession;

import javax.annotation.Resource;
import java.security.Principal;
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
    @Resource
    private NoteService noteService;
    @Autowired
    private UserService userService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/", method = GET)
    public String notes(Principal principal,
                        Model model) {
        model.addAttribute("username", principal.getName());
        return "Notes";
    }

    @RequestMapping(value = "/{username}/add", method = GET)
    public String Get(@PathVariable String username,
                      Model model) {
        model.addAttribute("username", username);
        return "AddNote";
    }

    @RequestMapping(value = "/{username}/add", method = POST)
    public void add(@RequestBody String note,
                    Principal principal) {
        JSONObject jsonObject = new JSONObject(note);
        noteService.add(new Note(userService.findUser(principal.getName()), jsonObject.getString("title"), jsonObject.getString("text")));
    }

    @RequestMapping(value = "/{username}/view", method = GET)
    public String view(@PathVariable String username,
                       @RequestParam(value = "hide", defaultValue = "1") int page,
                       @RequestParam(value = "hideId", defaultValue = "0") long id,
                       Model model,
                       Principal principal) {
        List<Note> notes = new ArrayList<>(noteService.findNotes(userService.findUser(principal.getName()).getUserId()));

        if (id != 0) {
            if (page != 1 &&
                    page == UserSession.getPages() &&
                    (UserSession.getPages() * UserSession.getCount()) - 9 == notes.size() &&
                    notes.get(notes.size() - 1).getId() == id) {
                page--;
                notes.remove(notes.size() - 1);
            }

            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getId() == id) {
                    notes.remove(i);
                    break;
                }
            }
            noteService.remove(id);
        }

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
