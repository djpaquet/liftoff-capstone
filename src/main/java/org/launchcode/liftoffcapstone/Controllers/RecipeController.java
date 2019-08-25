package org.launchcode.liftoffcapstone.Controllers;

import org.launchcode.liftoffcapstone.models.MeasurementUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.launchcode.liftoffcapstone.models.Category;
import org.launchcode.liftoffcapstone.models.Ingredient;
import org.launchcode.liftoffcapstone.models.Recipe;
import org.launchcode.liftoffcapstone.models.data.CategoryDao;
import org.launchcode.liftoffcapstone.models.data.IngredientsDao;
import org.launchcode.liftoffcapstone.models.data.RecipeDao;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.List;


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

        Recipe recipe = new Recipe();
        recipe.addIngredient(new Ingredient(" ",0," "));

        model.addAttribute("title", "Add New Recipe");
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("measurementUnits", MeasurementUnit.values());

        return "recipe/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecipe(@ModelAttribute @Valid Recipe recipe, Errors errors,
                                    @RequestParam int categoryId, Model model){


        Category cat = categoryDao.findOne(categoryId);


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Recipe");
            model.addAttribute("measurementUnit", MeasurementUnit.values());
            model.addAttribute("errors", errors);

            return "recipe/add";
        }else {

            recipe.setCategory(cat);
            recipeDao.save(recipe);
            return "recipe/view_recipe";
        }
    }


}
