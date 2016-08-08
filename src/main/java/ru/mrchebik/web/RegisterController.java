package ru.mrchebik.web;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                           @RequestParam("login") String login,
                           @RequestParam("password") String password,
                           Model model) {

        if (hide.equals("up")) {
            try {
                userRepository.add(new User(login, password));
            } catch (TransactionException e) {
                return "redirect:duplicate";
            }
        }

        User user;
        try {
            user = userRepository.findUser(login);
        } catch (NoSuchElementException e) {
            return "redirect:notRegister";
        }
        UserSession.setId(user.getId());
        return "redirect:notes";
    }
}
