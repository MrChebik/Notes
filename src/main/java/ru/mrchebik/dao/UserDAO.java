package ru.mrchebik.dao;

import org.hibernate.Query;
import ru.mrchebik.command.CommandFactory;
import ru.mrchebik.entity.User;

import java.util.List;

/**
 * Created by mrchebik on 22.07.16.
 */
public class UserDAO extends DAO {

    private final CommandFactory commandFactory = new CommandFactory();

    public User add(final User user) {
        return commandFactory.transaction(() -> {
            try {
                getSession().save(user);
            } catch (Exception e) {
                getSession().getTransaction().rollback();
                return null;
            }
            return user;
        });
    }

    public User get(final String username) {
        return commandFactory.transaction(() -> {
            Query query = getSession().createQuery("from ru.mrchebik.entity.User where name = :username").setString("username", username);
            List<User> user = query.list();
            return user.iterator().next();
        });
    }
}
