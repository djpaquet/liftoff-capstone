package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, message = "Must enter an Ingredient")
    private String name;

    @NotNull(message = "Must enter an amount")
    private int ingredientAmount;

    @NotNull(message = "Must enter a measurement")
    private String amountMeasurement;

    private String ingredientDescription;


    @ManyToOne
    private Recipe recipe;


    public Ingredients(String name, int ingredientAmount, String amountMeasurement, String ingredientDescription){
        this.name = name;
        this.ingredientAmount = ingredientAmount;
        this.amountMeasurement = amountMeasurement;
        this.ingredientDescription = ingredientDescription;
    }

    public Ingredients(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getAmountMeasurement() {
        return amountMeasurement;
    }

    public void setAmountMeasurement(String amountMeasurement) {
        this.amountMeasurement = amountMeasurement;
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }
}
