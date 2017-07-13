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
        @NamedQuery(name = Recipe.GET_LOW_CALORIE_RECIPES, query = "SELECT r FROM Recipe r WHERE r.calories < 400"),
        @NamedQuery(name = Recipe.GET_AVERAGE_CALORIE_RECIPES, query = "SELECT r FROM Recipe r WHERE r.calories < 600"),
        @NamedQuery(name = Recipe.GET_HIGH_CALORIE_RECIPES, query = "SELECT r FROM Recipe r WHERE r.calories > 400 AND r.calories < 900"),
        @NamedQuery(name = Recipe.GET_SUPER_HIGH_CALORIE_RECIPES, query = "SELECT r FROM Recipe r WHERE r.calories > 600 OR r.type = 'snack'"),
        @NamedQuery(name = Recipe.FIND_BY_NAME, query = "SELECT DISTINCT r FROM Recipe r LEFT JOIN FETCH r.ingredients WHERE r.name=:name")
})
@Access(AccessType.FIELD)
public class Recipe extends BasicMealEntity {
    public static final String GET_ALL = "Recipe.getAll";
    public static final String GET_LOW_CALORIE_RECIPES = "Recipe.getLowCalories";
    public static final String GET_AVERAGE_CALORIE_RECIPES = "Recipe.getAverageCalories";
    public static final String GET_HIGH_CALORIE_RECIPES = "Recipe.getHighCalories";
    public static final String GET_SUPER_HIGH_CALORIE_RECIPES = "Recipe.getSuperHighCalories";
    public static final String FIND_BY_NAME = "Recipe.find";

    @Column (name = "type")
    @NotNull
    private String type;

    @Column (name = "servings")
    @NotNull
    private int servings;
    

    @Column (name = "cookingtime")
    @NotNull
    private int cookingTimeMinutes;

    @Column (name = "preptime")
    @NotNull
    private int prepTime;

    @Column (name = "image")
    private byte [] image;


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "recipe", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonManagedReference
    private Set<RecipeIngredients> ingredients;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "recipe_drinks",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private Set<Drink> drinks;

    @Column (name = "recipe")
    @NotEmpty
    private String recipe;

    public Recipe () {}

    public Recipe (int id, String name, String type, int calories, int cookingTimeMinutes, int prepTime, byte [] image,
                   Set<RecipeIngredients> ingredients, Set<Drink> drinks,
                   String recipe) {
        super(id, name, calories);
        this.type = type;
        this.cookingTimeMinutes = cookingTimeMinutes;
        this.image = image;
        this.ingredients = ingredients;
        this.drinks = drinks;
        this.recipe = recipe;
        this.prepTime = prepTime;
    }


    private int getCookingTimeMinutes() {
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

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Set<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(Set<Drink> drinks) {
        this.drinks = drinks;
    }
}
