package org.launchcode.liftoffcapstone.Controllers;


import org.launchcode.liftoffcapstone.models.Category;
import org.launchcode.liftoffcapstone.models.Recipe;
import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.data.CategoryDao;
import org.launchcode.liftoffcapstone.models.data.RecipeDao;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")


public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "sign-up", method = RequestMethod.GET)
    public String sign_up(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Sign up to get started!");
        return "user/sign-up";
    }

    @RequestMapping(value="sign-up", method = RequestMethod.POST)
    public String processSignUp(Model model, @ModelAttribute @Valid User user, String verifyPassword, Errors errors) {

        if (!verifyPassword.equals(user.getPassword()) || errors.hasErrors()){
            model.addAttribute("title", "Sign up to get started!");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Passwords do not match!");
            model.addAttribute("error", errors);
            return "user/sign-up";

        }else{
            userDao.save(user);
            return "user/user_view";
        }

    }



    @RequestMapping(value="user_view", method = RequestMethod.GET)
    public String userView(Model model){


        model.addAttribute("categories", categoryDao.findAll());

        return "user/user_view";
    }





}
