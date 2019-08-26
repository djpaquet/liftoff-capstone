package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;


@Entity
public class Instruction {

    @Id
    @GeneratedValue
    private int id;

    private String step;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    public Instruction(String step){
        this.step = step;
    }

    public Instruction(){};

    public int getId() {
        return id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
