package ru.mrchebik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.User;
import ru.mrchebik.repository.UserRepository;
import ru.mrchebik.service.UserService;

/**
 * Created by mrchebik on 02.10.16.
 */
@Service
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(final User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findUser(final String username) {
        return userRepository.findByName(username);
    }
}