package netgloo.controllers;

import netgloo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  @RequestMapping(value = "/login",method = RequestMethod.GET)
  public ModelAndView login() {
    User user = new User();
    ModelAndView model = new ModelAndView();
    model.addObject(user);
    model.setViewName("login");
    return model;
  }

  @RequestMapping(value = "/register")
  public ModelAndView register() {
    User user = new User();
    ModelAndView model = new ModelAndView();
    model.addObject(user);
    model.setViewName("reg");
    return model;
  }

  @RequestMapping(value = "/")
  public ModelAndView index() {
    User user = new User();
    ModelAndView model = new ModelAndView();
    model.addObject(user);
    model.setViewName("login");
    return model;
  }
}
