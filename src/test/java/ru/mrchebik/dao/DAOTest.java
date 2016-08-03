package ru.mrchebik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.context.ThreadLocalSessionContext;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertFalse(dao.getSession().getTransaction().wasCommitted());
        dao.close();
    }
}