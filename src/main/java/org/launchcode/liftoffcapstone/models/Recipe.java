package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Please give your recipe a title!")
    @Size(min = 3)
    private String name;


    private int yield;

    private MeasurementUnit yieldType;

    @Transient
    private MeasurementUnit measurementUnit;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Instruction> instructions;

    private String notes;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public Recipe(String name, int yield, String notes) {
        this();
        this.name = name;
        this.yield = yield;
        this.notes = notes;

    }

    public Recipe(){
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        for (Ingredient ingredient : ingredients){
            ingredient.setRecipe(this);
        }
    }

    public void addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        ingredient.setMeasurementUnit(measurementUnit);
        ingredients.add(ingredient);
    }

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

    public MeasurementUnit getYieldType() {
        return yieldType;
    }

    public void setYieldType(MeasurementUnit yieldType) {
        this.yieldType = yieldType;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
        for(Instruction instruction : instructions){
            instruction.setRecipe(this);
        }
    }

    public void addInstruction(Instruction instruction){
        instruction.setRecipe(this);
        instructions.add(instruction);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
}
