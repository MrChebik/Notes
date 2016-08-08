package ru.mrchebik.data;

import ru.mrchebik.entity.User;

/**
 * Created by mrchebik on 08.08.16.
 */
public interface UserRepository {
    Object add(final User user);

    User findUser(final String login);
}
