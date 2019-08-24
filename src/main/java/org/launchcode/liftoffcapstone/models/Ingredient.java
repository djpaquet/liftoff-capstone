package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "What is this ingredients name?")
    @Size(min = 2)
    private String ingredientName;

    @NotNull(message = "Must enter an amount")
//    @Size(min=1)
    private int ingredientAmount;

   private MeasurementUnit unit;

    private String ingredientDescription;


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Ingredient(String ingredientName, int ingredientAmount, String ingredientDescription){
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.ingredientDescription = ingredientDescription;
    }

    public Ingredient(){}

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }


    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }



}
