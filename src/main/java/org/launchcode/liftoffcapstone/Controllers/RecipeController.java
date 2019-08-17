package org.launchcode.liftoffcapstone.Controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.launchcode.liftoffcapstone.models.Category;
import org.launchcode.liftoffcapstone.models.Ingredients;
import org.launchcode.liftoffcapstone.models.Recipe;
import org.launchcode.liftoffcapstone.models.data.CategoryDao;
import org.launchcode.liftoffcapstone.models.data.IngredientsDao;
import org.launchcode.liftoffcapstone.models.data.RecipeDao;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller
@RequestMapping(value= "recipe")

public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private IngredientsDao ingredientsDao;



    @RequestMapping(value= "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Recipe());
        model.addAttribute(new Ingredients());
        model.addAttribute(new Category());
        model.addAttribute("title", "Add New Recipe");
        return "recipe/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecipe(Model model, @ModelAttribute @Valid Recipe newRecipe, Errors error_recipe,
                                   @ModelAttribute @Valid Ingredients ingredients, Errors error_ing,
                                   @ModelAttribute @Valid Category category,
                                   Errors errors){



        if (errors.hasErrors() || error_ing.hasErrors() || error_recipe.hasErrors()){
            model.addAttribute("title", "Add New Recipe");
            model.addAttribute("errors", errors);
            model.addAttribute("error_ing", error_ing);
            model.addAttribute("error_recipe", error_recipe);
            return "recipe/add";
        }else {
            categoryDao.save(category);
            ingredientsDao.save(ingredients);
            recipeDao.save(newRecipe);

            return "recipe/view_recipe";
        }

    }


}
