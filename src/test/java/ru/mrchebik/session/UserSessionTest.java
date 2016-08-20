package ru.mrchebik.session;

import org.junit.Before;
import org.junit.Test;
import ru.mrchebik.entity.Note;
import ru.mrchebik.entity.User;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mrchebik on 09.08.16.
 */
public class UserSessionTest {
    private List<Note> noteList;

    @Before
    public void before() {
        noteList = new ArrayList<>();
        noteList.add(0, new Note("test", "test"));
    }

    @Test
    public void setGetId() throws Exception {
        UserSession.setId(20);
        assertEquals(UserSession.getId(), 20);
    }

    @Test
    public void setGetCount() throws Exception {
        UserSession.setCount(10);
        assertEquals(UserSession.getCount(), 10);
    }

    @Test
    public void setGetPages() throws Exception {
        UserSession.setPages(noteList, 5);
        assertEquals(UserSession.getPages(), 1);
    }

    @Test
    public void setGetUser() throws Exception {
        User user = new User("test", "test");
        UserSession.setUser(user);
        assertEquals(UserSession.getUser(), user);
    }
}