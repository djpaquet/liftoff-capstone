package org.launchcode.liftoffcapstone.Controllers;


import org.launchcode.liftoffcapstone.models.User;
import org.launchcode.liftoffcapstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "sign-up", method = RequestMethod.GET)
    public String sign_up(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Sign up to get started!");
        return "user/add";
    }





}
