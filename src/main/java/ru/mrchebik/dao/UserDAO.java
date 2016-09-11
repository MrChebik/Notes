package ru.mrchebik.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.command.CommandFactory;
import ru.mrchebik.data.UserRepository;
import ru.mrchebik.model.User;

import java.util.List;

/**
 * Created by mrchebik on 22.07.16.
 */
@Service
@Transactional
public class UserDAO extends DAO implements UserRepository {
    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public Object add(final User user) {
        return commandFactory.transaction(() -> {
            try {
                getSession().save(user);
            } catch (Exception e) {
                getSession().getTransaction().rollback();
            }
            return null;
        });
    }

    @Override
    public User findUser(final String username) {
        return commandFactory.transaction(() -> {
            Query query = getSession().createQuery("from ru.mrchebik.model.User where username = :username").setString("username", username);
            List<User> user = query.list();
            return user.iterator().next();
        });
    }
}
