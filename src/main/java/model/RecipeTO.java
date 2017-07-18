package model;


import java.util.Set;

public class RecipeTO extends Recipe {
    private Snack snack;
    private Drink drink;


    public RecipeTO(){
    }

    public RecipeTO(Recipe recipe) {
        super(recipe.getId(), recipe.getName(), recipe.getType(), recipe.getCalories(), recipe.getCookingTimeMinutes(),
                recipe.getPrepTime(), recipe.getImage(), recipe.getIngredients(), recipe.getDrinks(), recipe.getRecipe());
    }

    public RecipeTO(Recipe recipe, Drink drink) {
        super(recipe.getId(), recipe.getName(), recipe.getType(), recipe.getCalories(), recipe.getCookingTimeMinutes(),
                recipe.getPrepTime(), recipe.getImage(), recipe.getIngredients(), recipe.getDrinks(), recipe.getRecipe());
        this.drink = drink;
    }

    public RecipeTO(Recipe recipe, Drink drink, Snack snack) {
        super(recipe.getId(), recipe.getName(), recipe.getType(), recipe.getCalories(), recipe.getCookingTimeMinutes(),
                recipe.getPrepTime(), recipe.getImage(), recipe.getIngredients(), recipe.getDrinks(), recipe.getRecipe());
        this.drink = drink;
        this.snack = snack;
    }



    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
