package org.launchcode.liftoffcapstone.models;

import org.launchcode.liftoffcapstone.models.forms.IngredientList;

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

    private String instructions;

    private String notes;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "recipe")
    private List<IngredientList> ingredientList;

    public Recipe(String name, int yield, String notes, String instructions) {
        this.name = name;
        this.yield = yield;
        this.instructions = instructions;
        this.notes = notes;

    }

    public Recipe(){};

    public List<IngredientList> getIngredientList() {
        if(ingredientList == null){
            ingredientList = new ArrayList<IngredientList>();
        }
        return ingredientList;
    }

    public void setIngredientList(List<IngredientList> ingredientList) {
        this.ingredientList = ingredientList;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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


}
