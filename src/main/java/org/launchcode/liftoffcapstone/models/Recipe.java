package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Please give your recipe a title!")
    @Size(min=3)
    private String name;


    private int yield;

    private String yieldType;

    private String instructions;

    private String notes;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredients> ingredients = new ArrayList<>();

    public Recipe(String name, int yield, String yieldType, String notes, String instructions){
        this.name = name;
        this.yield = yield;
        this.yieldType = yieldType;
        this.instructions = instructions;
        this.notes = notes;

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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getYield() == recipe.getYield() &&
                getName().equals(recipe.getName()) &&
                Objects.equals(getYieldType(), recipe.getYieldType()) &&
                getInstructions().equals(recipe.getInstructions()) &&
                getNotes().equals(recipe.getNotes()) &&
                getCategory().equals(recipe.getCategory()) &&
                getIngredients().equals(recipe.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYield(), getYieldType(), getInstructions(), getNotes(), getCategory(), getIngredients());
    }
}
