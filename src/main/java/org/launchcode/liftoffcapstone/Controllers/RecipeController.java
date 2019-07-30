package org.launchcode.liftoffcapstone.Controllers;


import org.launchcode.liftoffcapstone.models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value= "recipe")

public class RecipeController {

    @RequestMapping(value= "", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Recipe());
        model.addAttribute("title", "Add New Recipe");
        return "recipe/add";

    }



}
