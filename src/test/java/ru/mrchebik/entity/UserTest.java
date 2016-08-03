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
        assertTrue(user.getName().equals("test"));
    }

    @Test
    public void setName() throws Exception {
        user.setName("test1");
        assertTrue(user.getName().equals("test1"));
        user.setName("test");
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
        assertTrue(user.getId() == 0);
    }

    @Test
    public void setId() throws Exception {
        user.setId(1);
        assertTrue(user.getId() == 1);
        user.setId(0);
    }

}