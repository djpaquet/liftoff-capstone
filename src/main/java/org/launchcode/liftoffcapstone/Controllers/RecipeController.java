package org.launchcode.liftoffcapstone.Controllers;


import org.launchcode.liftoffcapstone.models.*;
import org.launchcode.liftoffcapstone.models.data.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private InstructionDoa instructionDoa;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@RequestParam(value = "searchTerm", required = false) String searchTerm, Model model){


        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("searchResult", recipeDao.findByNameIgnoreCase(searchTerm));
        return "recipe/index";
    }



    @RequestMapping(value= "add", method = RequestMethod.GET)
    public String add(Model model){

        Recipe recipe = new Recipe();
        recipe.addIngredient(new Ingredient(" ",0 , MeasurementUnit.TBS , " "));

        for (int i = 1; i <= 3; i++) {
            recipe.addInstruction(new Instruction(" "));
        }

        model.addAttribute("title", "Add New Recipe");
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("measurementUnits", MeasurementUnit.values());

        return "recipe/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecipe(@ModelAttribute @Valid Recipe recipe, Errors errors,
                                    @RequestParam int categoryId, Model model) {

        Category cat = categoryDao.findOne(categoryId);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Recipe");
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("measurementUnit", MeasurementUnit.values());
            model.addAttribute("errors", errors);
            return "recipe/add";
        } else {
            createRecipe(recipe);
            recipe.setCategory(cat);
            recipeDao.save(recipe);
            return "redirect:/recipe/view_recipe/" + recipe.getId();
        }
    }

    //returns recipe view with id parameter
    @RequestMapping(value = "view_recipe/{recipeId}", method = RequestMethod.GET)
    public String viewRecipe(Model model, @PathVariable int recipeId){

        Recipe recipe = recipeDao.findOne(recipeId);


        model.addAttribute("recipe", recipe);
        model.addAttribute("title", recipe.getName());
        return "recipe/view_recipe";

    }


    @RequestMapping(value = "edit/{recipeId}", method = RequestMethod.GET)
    public String displayEditRecipe(Model model, @PathVariable int recipeId){

        Recipe recipe = recipeDao.findOne(recipeId);
        recipe.getId();
        recipe.getVersion();
        accessRecipe(recipe);

        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredients", recipe.getIngredients());
        model.addAttribute("instructions", recipe.getInstructions());
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("measurementUnit", MeasurementUnit.values());


        return "recipe/edit";

    }

    @RequestMapping(value = "edit/{recipeId}", method = RequestMethod.POST)
    public String processEditRecipe(@PathVariable int recipeId, String name, int yield, String notes, @ModelAttribute @Valid Recipe recipe,
                                    BindingResult result, @RequestParam int categoryId,Model model){

        Category cat = categoryDao.findOne(categoryId);
        Recipe origRecipe = recipeDao.findOne(recipeId);
        accessRecipe(origRecipe);

        if(result.hasErrors()){
            model.addAttribute("recipe", recipe);
            model.addAttribute("categories", categoryDao.findAll());
            model.addAttribute("measurementUnit", MeasurementUnit.values());
            return "recipe/edit";
        }

        origRecipe.setIngredients(recipe.getIngredients());
        origRecipe.setInstructions(recipe.getInstructions());
        createRecipe(origRecipe);
        origRecipe.setName(name);
        origRecipe.setYield(yield);
        origRecipe.setNotes(notes);
        origRecipe.setCategory(cat);
        recipeDao.save(origRecipe);
        return "redirect:/recipe/view_recipe/" + recipeId;
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRecipe(Model model){

        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("title", "Remove Recipes");
        return "recipe/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeRecipe(@RequestParam int[] recipeIds){

        for (int recipeId : recipeIds){
            recipeDao.delete(recipeId);
        }

        return "redirect:";
    }



        private void createRecipe(Recipe recipe){
            recipe.getIngredients().forEach(ingredient -> ingredient.setRecipe(recipe));
            recipe.getInstructions().forEach(instruction -> instruction.setRecipe(recipe));

        }

        private void accessRecipe(Recipe recipe){
            recipe.getIngredients().forEach(ingredient -> ingredient.getId());
            recipe.getIngredients().forEach(ingredient -> ingredient.getVersion());
            recipe.getInstructions().forEach(instruction -> instruction.getId());
            recipe.getInstructions().forEach(instruction -> instruction.getVersion());

        }


}
