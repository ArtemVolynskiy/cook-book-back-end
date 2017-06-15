package model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
@Entity
@Table (name = "recipe_ingredients")
public class RecipeIngredients {
    public RecipeIngredients(){}

    public RecipeIngredients (RecipeIngredientsPK recipeIngredientsPK, Recipe recipe, Ingredient ingredient, String quantity) {
        this.id = recipeIngredientsPK;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public RecipeIngredients (RecipeIngredients recipeIngredients) {
        this(recipeIngredients.getId(), recipeIngredients.getRecipe(), recipeIngredients.getIngredient(), recipeIngredients.getQuantity());
    }

    @EmbeddedId
    private RecipeIngredientsPK id;

    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @ManyToOne
    @MapsId("recipe_id")
    @JoinColumn(name = "RECIPE_ID")
    @JsonBackReference
    private Recipe recipe;

    @Column(name = "quantity")
    private String quantity;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RecipeIngredientsPK getId() {
        return id;
    }

    public void setId(RecipeIngredientsPK id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
