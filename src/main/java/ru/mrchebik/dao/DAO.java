package ru.mrchebik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.logging.Logger;

/**
 * Created by mrchebik on 22.07.16.
 */
public class DAO {
    private static final Logger logger = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    public Session getSession() {
        Session session = (Session) DAO.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            DAO.session.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        if (!getSession().getTransaction().wasCommitted()) {
            getSession().getTransaction().commit();
        }
    }

    public void close() {
        getSession().close();
        DAO.session.set(null);
    }
}
