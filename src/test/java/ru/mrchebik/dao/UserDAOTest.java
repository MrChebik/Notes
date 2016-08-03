package ru.mrchebik.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mrchebik.entity.User;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 04.08.16.
 */
public class UserDAOTest {
    private final UserDAO userDAO = new UserDAO();

    @Before
    public void add() {
        userDAO.add(new User("test", "test"));
    }

    @Test
    public void addAndGet() throws Exception {
        assertEquals(userDAO.get("test").getPassword(), "test");
    }
}