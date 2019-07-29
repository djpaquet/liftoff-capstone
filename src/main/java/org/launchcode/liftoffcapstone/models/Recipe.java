package org.launchcode.liftoffcapstone.models;

public class Recipe {

    private int id;

    private String name;

    private int yield;

    private String yieldType;

    private String ingredientName;

    private int ingredientAmount;

    private String ingredientDescription;

    private String instructions;

    public Recipe(String name, int yield, String ingredientName, int ingredientAmount, String instructions ){
        this.name = name;
        this.yield = yield;
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.instructions = instructions;

    }

    public Recipe(){}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public String getYieldType() {
        return yieldType;
    }

    public void setYieldType(String yieldType) {
        this.yieldType = yieldType;
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

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
