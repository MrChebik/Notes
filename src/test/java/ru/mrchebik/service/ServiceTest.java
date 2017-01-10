package ru.mrchebik.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.mrchebik.model.Note;
import ru.mrchebik.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mrchebik on 05.12.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
    @ContextConfiguration("file:**/servlet-context.xml"),
    @ContextConfiguration("file:**/security.xml")
})
@WebAppConfiguration("webapp/WEB-INF/spring/appServlet")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {
    private User user = new User("test", "test");
    private List<Note> findNotes;
    private User finduUser;

    @Resource
    private NoteService noteService;

    @Resource
    private UserService userService;

    @Test
    public void test01Add() throws Exception {
        userService.add(user);
        noteService.add(new Note(user, "Title", "Text"));
    }

    @Test
    public void test02Find() throws Exception {
        findNotes = noteService.findNotes(userService.findUser("test").getUserId());
        finduUser = userService.findUser("test");
    }

    @Test
    @WithMockUser(roles = {"ROLE_ADMIN"})
    public void test03Clear() throws Exception {
        noteService.remove(findNotes.get(0).getId());
        userService.remove(finduUser.getUserId());
    }
}