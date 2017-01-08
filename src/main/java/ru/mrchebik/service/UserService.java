package ru.mrchebik.service;

import ru.mrchebik.model.User;

/**
 * Created by mrchebik on 02.10.16.
 */
public interface UserService {
    User add(final User user);
    User findUser(final String username);
}
