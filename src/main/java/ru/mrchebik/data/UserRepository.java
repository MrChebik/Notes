package ru.mrchebik.data;

import ru.mrchebik.model.User;

/**
 * Created by mrchebik on 08.08.16.
 */
public interface UserRepository {
    Object add(final User user);

    User findUser(final String login);
}
