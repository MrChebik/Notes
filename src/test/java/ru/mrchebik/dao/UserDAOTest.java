package ru.mrchebik.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.mrchebik.entity.User;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 04.08.16.
 */
public class UserDAOTest {
    private static final UserDAO userDAO = new UserDAO();

    @BeforeClass
    public static void add() {
        try {
            if (userDAO.findUser("test").getUsername().equals("test"));
        } catch (NoSuchElementException e) {
            userDAO.add(new User("test", "test"));
        }
    }

    @Test
    public void addAndGet() throws Exception {
        assertEquals(userDAO.findUser("test").getPassword(), "test");
    }
}