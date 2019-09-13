package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;


@Entity
public class Instruction {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String step;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    public Instruction(String instruction){
        this.step = step;
    }

    public Instruction(){};

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
