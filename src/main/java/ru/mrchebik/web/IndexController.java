package ru.mrchebik.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mrchebik on 05.08.16.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(method = GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping("accessDenied")
    public String accessDeniedPage() {
        return "AccessDenied";
    }
}