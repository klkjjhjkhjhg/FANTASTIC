package netgloo.controllers;

import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import sun.org.mozilla.javascript.internal.json.JsonParser;

/**
 * Created by qiton on 2017/5/17.
 */
@Controller
public class HelloController {
    @RequestMapping(value="/submit",  method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "user")User user) {
        User user0 = userDao.findByEmail(user.getEmail());
        ModelAndView model = new ModelAndView();
        if(user0 == null){
            model.setViewName("login");
            model.addObject(user0);
            return model;
        }
        if(!user0.getUserpwd().equals(user.getUserpwd())){
            System.out.println(user0.getUserpwd());
            System.out.println(user.getUserpwd());
            model.setViewName("login");
            model.addObject(user0);
            return model;
        }
        if(user0.getGroupid() == 1){
            model.setViewName("index");
            model.addObject(user0);
            return model;
        }
        if(user0.getGroupid() == 2){
            model.setViewName("admin");
            model.addObject(user0);
            return model;
        }
        model.setViewName("login");
        model.addObject(user0);
        return model;
    }

    @Autowired
    private UserDao userDao;
}
