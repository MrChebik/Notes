package ru.mrchebik.web;

import org.hibernate.TransactionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.model.User;
import ru.mrchebik.service.UserService;
import ru.mrchebik.session.UserSession;

import javax.annotation.Resource;
import java.util.NoSuchElementException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 06.08.16.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private UserService userService;

    public RegisterController() {

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
                userService.add(new User(username, password));
            } catch (TransactionException e) {
                return "redirect:/register/duplicate";
            }
        }

        User user;
        try {
            user = userService.findUser(username);
        } catch (NoSuchElementException e) {
            return "redirect:/register/notExists";
        }
        UserSession.setUser(user);
        UserSession.setId(user.getUserId());
        return "redirect:/notes/" + UserSession.getUser().getUsername();
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
