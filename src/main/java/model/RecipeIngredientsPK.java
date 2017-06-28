package model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Access(AccessType.PROPERTY)
@Table (name = "recipe_ingredients")
public class RecipeIngredientsPK implements Serializable {

    @Column (name = "INGREDIENT_ID")
    private int ingredient_id;

    @Column (name = "RECIPE_ID")
    private int recipeId;

    public RecipeIngredientsPK(){}


    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipe_id) {
        this.recipeId = recipe_id;
    }
}
