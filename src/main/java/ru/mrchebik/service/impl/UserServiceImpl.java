package ru.mrchebik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.User;
import ru.mrchebik.repository.RoleRepository;
import ru.mrchebik.repository.UserRepository;
import ru.mrchebik.service.UserService;

import java.util.HashSet;

/**
 * Created by mrchebik on 02.10.16.
 */
@Service
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User add(final User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findUser(final String username) {
        return userRepository.findByName(username);
    }
}