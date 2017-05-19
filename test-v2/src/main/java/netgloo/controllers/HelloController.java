package netgloo.controllers;

import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qiton on 2017/5/17.
 */
@Controller
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        User user = new User();
        ModelAndView model = new ModelAndView();
        model.addObject(user);
        model.setViewName("admin");
        return model;
    }
}
