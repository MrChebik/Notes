package ru.mrchebik.web;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.data.UserRepository;
import ru.mrchebik.entity.User;
import ru.mrchebik.session.UserSession;

import java.util.NoSuchElementException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 06.08.16.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserRepository userRepository;

    public RegisterController() {

    }

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public String Get() {
        return "SignInUp";
    }

    @RequestMapping(method = POST)
    public String register(@RequestParam("hide") String hide,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password) {

        if (hide.equals("up")) {
            try {
                userRepository.add(new User(username, password));
            } catch (TransactionException e) {
                return "redirect:/register/duplicate";
            }
        }

        User user;
        try {
            user = userRepository.findUser(username);
        } catch (NoSuchElementException e) {
            return "redirect:/register/notExists";
        }
        UserSession.setUsername(user.getUsername());
        UserSession.setId(user.getId());
        return "redirect:/notes/" + UserSession.getUsername();
    }

    @RequestMapping(value = "/duplicate", method = GET)
    public String duplicate() {
        return "Duplicate";
    }

    @RequestMapping(value = "/notExists", method = GET)
    public String notRegister() {
        return "NotRegister";
    }
}
