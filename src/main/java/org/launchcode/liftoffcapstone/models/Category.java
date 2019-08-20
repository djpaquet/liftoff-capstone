package org.launchcode.liftoffcapstone.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Name your category!")
    @Size(min = 3 , max = 15)
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Recipe> recipes = new ArrayList<>();

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category(){}

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getCategoryName(), category.getCategoryName()) &&
                Objects.equals(getRecipes(), category.getRecipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryName(), getRecipes());
    }
}
