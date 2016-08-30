package ru.mrchebik.dao;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mrchebik on 03.08.16.
 */
public class DAOTest {
    private final DAO dao = new DAO();

    @Test
    public void begined() {
        dao.begin();
        assertTrue(dao.getSession().isOpen());
        assertTrue(dao.getSession().isConnected());
        dao.commit();
        dao.close();
    }
}