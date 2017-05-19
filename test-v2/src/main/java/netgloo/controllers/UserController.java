package netgloo.controllers;

import netgloo.models.Group;
import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@Controller
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------


  @RequestMapping(value="/create",  method = RequestMethod.POST)
  public ModelAndView create(@ModelAttribute(value = "user")User user, BindingResult bindingResult) {
    System.out.println(user.getEmail());
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());
    System.out.println("ok");
    //user.setGroupid(1);
    Group group = new Group();
    Long newId = 1L;
    group.setId(newId);
    group.setName("ROLE_ADMIN");
    List<Group> groups = new ArrayList<Group>();
    System.out.println(group);
    groups.add(group);

    user.setRoles(groups);
    System.out.println(groups);

    userDao.save(user);

    ModelAndView model = new ModelAndView();
    model.setViewName("login");
    model.addObject(new User());
    return model;
  }

  /**
   * /delete  --> Delete the user having the passed id.
   *
   * @param id The id of the user to delete
   * @return A string describing if the user is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }

  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   *
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  /**
   * /get-by-name  --> Return the id for the user having the passed name.
   *
   * @param name The name to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-name")
  @ResponseBody
  public String getByName(String name) {
    String userId;
    try {
      User user = userDao.findByUsername(name);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  /**
   * /update  --> Update the email and the name for the user in the database
   * having the passed id.
   *
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(long id, String email, String name) {
    try {
      User user = userDao.findOne(id);
      user.setEmail(email);
      user.setUsername(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserDao userDao;

} // class UserController
