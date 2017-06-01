package model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "recipe", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name", "recipe"})})
public class Recipe extends NamedEntity {


    @Column (name = "calories")
    @NotEmpty
    @Length(min = 3)
    private int calories;

    @Column (name = "cooking_time")
    @NotEmpty
    private int cookingTimeMinutes;

    @Column (name = "image")
    private byte [] image;

    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "recipe_id", nullable = false))
    @OneToMany(fetch = FetchType.LAZY)
    private List <Ingredient> ingredients;

    @Column (name = "recipe")
    @NotNull
    private String recipe;

    public Recipe () {}

    public Recipe (int id, String name, int calories, int cookingTimeMinutes, byte [] image, List<Ingredient> ingredients,
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
