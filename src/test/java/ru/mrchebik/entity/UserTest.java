package ru.mrchebik.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mrchebik on 04.08.16.
 */
public class UserTest {
    private final User user = new User("test", "testP");

    @Test
    public void getName() throws Exception {
        assertTrue(user.getUsername().equals("test"));
    }

    @Test
    public void setName() throws Exception {
        user.setUsername("test1");
        assertTrue(user.getUsername().equals("test1"));
        user.setUsername("test");
    }

    @Test
    public void getPassword() throws Exception {
        assertTrue(user.getPassword().equals("testP"));
    }

    @Test
    public void setPassword() throws Exception {
        user.setPassword("testP1");
        assertTrue(user.getPassword().equals("testP1"));
        user.setPassword("testP");
    }

    @Test
    public void getId() throws Exception {
        assertTrue(user.getUSER_ID() == 0);
    }

    @Test
    public void setId() throws Exception {
        user.setUSER_ID(1);
        assertTrue(user.getUSER_ID() == 1);
        user.setUSER_ID(0);
    }

}