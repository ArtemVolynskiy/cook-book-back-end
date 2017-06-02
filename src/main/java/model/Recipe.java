package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipe", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name", "recipe"})})
@NamedQueries({
        @NamedQuery(name = Recipe.DELETE, query = "DELETE FROM Recipe r WHERE r.name=:name"),
        @NamedQuery(name = Recipe.GET_ALL, query = "SELECT r FROM Recipe r ORDER BY r.name"),
})
public class Recipe extends NamedEntity {
    public static final String DELETE = "Recipe.delete";
    public static final String GET_ALL = "Recipe.getAll";


    @Column (name = "calories")
    @NotEmpty
    @Length(min = 3)
    private int calories;

    @Column (name = "cooking_time")
    @NotEmpty
    private int cookingTimeMinutes;

    @Column (name = "image")
    private byte [] image;

    @JoinTable(name = "recipe_ingredient", joinColumns = { @JoinColumn(name = "recipe_name") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_name") })
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;

    @Column (name = "recipe")
    @NotNull
    private String recipe;

    public Recipe () {}

    public Recipe (int id, String name, int calories, int cookingTimeMinutes, byte [] image, Set<Ingredient> ingredients,
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
