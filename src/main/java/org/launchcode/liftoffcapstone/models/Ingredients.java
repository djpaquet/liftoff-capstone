package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "What is this ingredients name?")
    @Size(min = 2)
    private String ingredientName;

    @NotNull(message = "Must enter an amount")
//    @Size(min=1)
    private int ingredientAmount;

    @NotNull(message = "Must enter a measurement")
    @Size(min=1)
    private String amountMeasurement;

    private String ingredientDescription;


    @ManyToOne
    @JoinColumn(name= "recipe_Id")
    private Recipe recipe;


    public Ingredients(String ingredientName, int ingredientAmount, String amountMeasurement, String ingredientDescription){
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.amountMeasurement = amountMeasurement;
        this.ingredientDescription = ingredientDescription;
    }

    public Ingredients(){}

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
