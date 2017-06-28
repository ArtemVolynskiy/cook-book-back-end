package model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
@Entity
@Table (name = "recipe_ingredients")
public class RecipeIngredients {

    @EmbeddedId
    private RecipeIngredientsPK id;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "RECIPE_ID")
    @JsonBackReference
    private Recipe recipe;

    @Column(name = "quantity")
    private String quantity;



    public RecipeIngredients(){}

    private RecipeIngredients(RecipeIngredientsPK recipeIngredientsPK, Recipe recipe, Ingredient ingredient, String quantity) {
        this.id = recipeIngredientsPK;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public RecipeIngredients (RecipeIngredients recipeIngredients) {
        this(recipeIngredients.getId(), recipeIngredients.getRecipe(), recipeIngredients.getIngredient(), recipeIngredients.getQuantity());
    }



    private Ingredient getIngredient() {
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

    private String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
