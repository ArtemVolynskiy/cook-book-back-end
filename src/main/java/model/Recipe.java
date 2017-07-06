package model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "recipe", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name", "recipe"})})
@NamedQueries({
        @NamedQuery(name = Recipe.GET_ALL, query = "SELECT r FROM Recipe r ORDER BY r.name"),
        @NamedQuery(name = Recipe.FIND_BY_NAME, query = "SELECT DISTINCT r FROM Recipe r LEFT JOIN FETCH r.ingredients WHERE r.name=:name")
})
@Access(AccessType.FIELD)
public class Recipe extends NamedEntity {
    public static final String GET_ALL = "Recipe.getAll";
    public static final String FIND_BY_NAME = "Recipe.find";

    @Column (name = "type")
    @NotNull
    private String type;

    @Column (name = "calories")
    @NotNull
    private int calories;

    @Column (name = "cookingtime")
    @NotNull
    private int cookingTimeMinutes;

    @Column (name = "image")
    private byte [] image;


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "recipe", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonManagedReference
    private Set<RecipeIngredients> ingredients;

    @Column (name = "recipe")
    @NotEmpty
    private String recipe;

    public Recipe () {}

    public Recipe (int id, String name, String type, int calories, int cookingTimeMinutes, byte [] image, Set<RecipeIngredients> ingredients,
                   String recipe) {
        super(id, name);
        this.calories = calories;
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.image = image;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }


    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCookingTimeMinutes() {
        return cookingTimeMinutes;
    }

    public void setCookingTimeMinutes(int cookingTimeMinutes) {
        this.cookingTimeMinutes = cookingTimeMinutes;
    }


    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<RecipeIngredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredients> recipeIngredients) {
        this.ingredients = recipeIngredients;
    }

    public String toString() {
        return "id: " + this.getId()
                + ", name: " + this.getName()
                + ", total calories: " + this.getCalories()
                + ", cooking time: " + this.getCookingTimeMinutes()
                + ", ingredients" + this.getIngredients()
                + ", recipe: " + this.getRecipe();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
