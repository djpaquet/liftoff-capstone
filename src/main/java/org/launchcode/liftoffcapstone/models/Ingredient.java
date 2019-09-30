package org.launchcode.liftoffcapstone.models;

import javax.persistence.*;
;import java.util.Objects;

import static org.launchcode.liftoffcapstone.models.MeasurementUnit.TSP;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    private String ingredientName;

    private double ingredientAmount;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    private String ingredientDescription;


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public Ingredient(String ingredientName, double ingredientAmount, MeasurementUnit measurementUnit, String ingredientDescription){
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;
        this.measurementUnit = measurementUnit;
        this.ingredientDescription = ingredientDescription;
    }

    public Ingredient(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(double ingredientAmount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getId() == that.getId() &&
                Double.compare(that.getIngredientAmount(), getIngredientAmount()) == 0 &&
                Objects.equals(getIngredientName(), that.getIngredientName()) &&
                getMeasurementUnit() == that.getMeasurementUnit() &&
                Objects.equals(getIngredientDescription(), that.getIngredientDescription()) &&
                Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIngredientName(), getIngredientAmount(), getMeasurementUnit(), getIngredientDescription(), getRecipe());
    }
}
