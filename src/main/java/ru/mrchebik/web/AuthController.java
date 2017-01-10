package ru.mrchebik.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mrchebik.model.User;
import ru.mrchebik.service.SecurityService;
import ru.mrchebik.service.UserService;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrchebik on 06.08.16.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    public AuthController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @RequestMapping(value = "/register", method = GET)
    public String Get(Model model) {
        model.addAttribute("userForm", new User());
        return "SignUp";
    }

    @RequestMapping(value = "/register", method = POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                               Model model) {
        try {
            userService.add(userForm);
        } catch (Exception e) {
            model.addAttribute("error", "SQLError");

            return "SignUp";
        }
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/notes/";
    }

    @RequestMapping(value = "/login", method = GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                         Model model) {
        if (error != null) {
            model.addAttribute(error);
        }
        if (logout != null) {
            model.addAttribute(logout);
        }

        return "SignIn";
    }
}
