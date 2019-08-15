package org.launchcode.liftoffcapstone.Controllers;


import org.launchcode.liftoffcapstone.models.Category;
import org.launchcode.liftoffcapstone.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute(new Category());
        model.addAttribute("title", "Add a new Category");
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Category");
            return "category/add";
        }

        categoryDao.save(category);
        //return recipe/add until build main view//
        return "recipe/add";
    }
}
