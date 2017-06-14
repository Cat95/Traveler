package com.spring.controller;

import com.spring.model.Place;
import com.spring.model.Score;
import com.spring.model.User;
import com.spring.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class HomeController {

    private SearchOptions oldOptions;
    private User currentUser;

    @Resource(name="placeService")
    private PlaceService placeService;

    @Resource(name="userService")
    private UserService userService;

    @Resource(name="scoreService")
    private ScoreService scoreService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getLogin() == null)
            modelAndView.addObject("user", new User());
        else
            modelAndView.addObject("user", user);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView reg(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("registration");
        modelAndView.addObject("user", user);

        userService.saveUser(user);

        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView authorization(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();

        user = userService.findByLogin(user.getLogin());
        modelAndView.addObject("user", user);
        currentUser = user;

        if (userService.findByLogin(user.getLogin()) != null)
        {
            if (userService.findByLogin(user.getLogin()).getPassword().equals(user.getPassword()))
                modelAndView.setViewName("authorization");
            else
                modelAndView.setViewName("authorizeFail");
        }
        else
        modelAndView.setViewName("authorizeFail");

        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute("user") User user,
                             @ModelAttribute("list") ArrayList<Place> list,
                             @ModelAttribute("options") SearchOptions options,
                             @ModelAttribute("score") Score score) {
        ModelAndView modelAndView = new ModelAndView();

        list = (ArrayList<Place>) placeService.findAllPlaces();

        modelAndView.addObject("user", currentUser);
        modelAndView.addObject("list", list);
        modelAndView.addObject("score", score);
        modelAndView.addObject("options", options);
        modelAndView.addObject("currentUser", currentUser);

        modelAndView.setViewName("list");

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@ModelAttribute("user") User user,
                               @ModelAttribute("options") SearchOptions options) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("options", options);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("search");

        return modelAndView;
    }

    @RequestMapping(value = "/found", method = RequestMethod.GET)
    public ModelAndView found(@ModelAttribute("user") User user,
                              @ModelAttribute("list") ArrayList<Place> list,
                              @ModelAttribute("options") SearchOptions options,
                              @ModelAttribute("score") Score score) {
        ModelAndView modelAndView = new ModelAndView();

        switch (options.getSearchOption()) {
            case "name" :
                list = (ArrayList<Place>) placeService.findBySameName(options.getSearchValue());
                break;
            case "country" :
                list = (ArrayList<Place>) placeService.findByCountry(options.getSearchValue());
                break;
            case "restType" :
                list = (ArrayList<Place>) placeService.findByRestType(options.getSearchValue());
                break;
            case "cost" :
                list = (ArrayList<Place>) placeService.findByCost(options.getSearchValue());
                break;
            case "rate" :
                list = (ArrayList<Place>) placeService.findByRate(Integer.parseInt(options.getSearchValue()));
                break;
        }

        oldOptions = new SearchOptions();
        oldOptions.setSearchOption(options.getSearchOption());
        oldOptions.setSearchValue(options.getSearchValue());

        modelAndView.addObject("list", list);
        modelAndView.addObject("user", user);
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("options", options);
        modelAndView.addObject("score", score);

        if (list.size() > 0)
            modelAndView.setViewName("found");
        else
            modelAndView.setViewName("notFound");

        if(!scoreService.exists(score.getUser(), score.getPlace()))
            scoreService.addScore(score);
        else {
            scoreService.updateScore(score);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/rated", method = RequestMethod.POST)
    public ModelAndView rated(@ModelAttribute("user") User user,
                              @ModelAttribute("list") ArrayList<Place> list,
                              @ModelAttribute("options") SearchOptions options,
                              @ModelAttribute("score") Score score) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            switch (oldOptions.getSearchOption()) {
                case "name":
                    list = (ArrayList<Place>) placeService.findBySameName(oldOptions.getSearchValue());
                    break;
                case "country":
                    list = (ArrayList<Place>) placeService.findByCountry(oldOptions.getSearchValue());
                    break;
                case "restType":
                    list = (ArrayList<Place>) placeService.findByRestType(oldOptions.getSearchValue());
                    break;
                case "cost":
                    list = (ArrayList<Place>) placeService.findByCost(oldOptions.getSearchValue());
                    break;
                case "rate":
                    list = (ArrayList<Place>) placeService.findByRate(Integer.parseInt(oldOptions.getSearchValue()));
                    break;
            }

            oldOptions.setSearchOption(options.getSearchOption());
            oldOptions.setSearchValue(options.getSearchValue());
        }
        catch (Exception ignored) {}

        modelAndView.addObject("list", list);
        modelAndView.addObject("user", user);
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("options", options);
        modelAndView.addObject("score", score);

        if (list.size() > 0)
            modelAndView.setViewName("found");
        else
            modelAndView.setViewName("notFound");

        if(!scoreService.exists(score.getUser(), score.getPlace()))
            scoreService.addScore(score);
        else {
            scoreService.updateScore(score);
        }

        return modelAndView;
    }
}
