package model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Embeddable
@Access(AccessType.PROPERTY)
@Table (name = "recipe_ingredients")
public class RecipeIngredientsPK implements Serializable {

    @Column (name = "INGREDIENT_ID")
    private int ingredient_id;

    @Column (name = "RECIPE_ID")
    private int recipe_id;

    public RecipeIngredientsPK(){}


    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }
}
