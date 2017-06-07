package com.spring.controller;

import com.spring.configuration.WebConfiguration;
import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView reg(@ModelAttribute("user") User user) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebConfiguration.class);
        ModelAndView modelAndView = new ModelAndView();
        UserService service = (UserService) context.getBean("userService");

        modelAndView.setViewName("registration");
        modelAndView.addObject("user", user);
        service.saveUser(user);

        context.close();
        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView authorization(@ModelAttribute("user") User user) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebConfiguration.class);
        ModelAndView modelAndView = new ModelAndView();
        UserService service = (UserService) context.getBean("userService");

        modelAndView.addObject("user", user);


        if (!(service.findByLogin(user.getLogin()) == null))
            if (service.findByLogin(user.getLogin()).getPassword().equals(user.getPassword()))
                modelAndView.setViewName("authorization");
        else
            modelAndView.setViewName("authorizeFail");

        context.close();
        return modelAndView;
    }
}
