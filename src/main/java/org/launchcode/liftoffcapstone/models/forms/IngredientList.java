package org.launchcode.liftoffcapstone.models.forms;

import org.launchcode.liftoffcapstone.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientList {

    private List<Ingredient> ingredient;

    public List<Ingredient> getIngredient() {
        if (ingredient == null){
            ingredient = new ArrayList<Ingredient>();
        }

        return ingredient;
    }
}
