package model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Access(AccessType.PROPERTY)
@Table (name = "recipe_ingredients")
public class RecipeIngredientsPK implements Serializable {

    @Column (name = "INGREDIENT_ID")
    private int ingredientId;

    @Column (name = "RECIPE_ID")
    private int recipeId;


    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipe_id) {
        this.recipeId = recipe_id;
    }
}
