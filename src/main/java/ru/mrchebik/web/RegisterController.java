package ru.mrchebik.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.model.User;
import ru.mrchebik.service.UserService;
import ru.mrchebik.session.UserSession;

import javax.annotation.Resource;

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

    public RegisterController(UserService userService) {
        this.userService = userService;
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
            } catch (DataIntegrityViolationException e) {
                return "redirect:/register/duplicate";
            }
        }
        User user = userService.findUser(username);
        if (user == null) {
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
