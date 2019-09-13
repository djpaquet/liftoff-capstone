package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
;import static org.launchcode.liftoffcapstone.models.MeasurementUnit.TSP;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String ingredientName;

    private int ingredientAmount;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    private String ingredientDescription;


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Ingredient(String ingredientName, int ingredientAmount, MeasurementUnit measurementUnit, String ingredientDescription){
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.measurementUnit = measurementUnit;
        this.ingredientDescription = ingredientDescription;
    }

    public Ingredient(){}

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
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
