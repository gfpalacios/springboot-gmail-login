package com.sample.controller;


import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitController {

/*
    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return "index";
    }
*/

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}