package mk.edu.ukim.finki.mvr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class LinkController {

    @RequestMapping(value = "/*")
    public String invalid() {
        return "redirect:/";
    }

    @RequestMapping(value = {"/"})
    public ModelAndView home() {
        ModelAndView result = new ModelAndView("index.jsp");
        return result;
    }
}