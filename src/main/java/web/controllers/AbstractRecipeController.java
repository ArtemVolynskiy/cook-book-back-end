package web.controllers;


import model.Recipe;
import model.RecipeIngredients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.RecipeService;

import java.util.List;
import java.util.Set;

public class AbstractRecipeController {

    private final
    RecipeService recipeService;


    protected AbstractRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    protected  ResponseEntity<Set<RecipeIngredients>> findRecipe(String name) {
            Recipe recipe = recipeService.findByName(name);
            return new ResponseEntity<>(recipe.getIngredients(), HttpStatus.OK);
    }


    protected ResponseEntity<Recipe> createRecipe(Recipe recipe) {
        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.CREATED);
    }


    protected HttpStatus updateRecipe(Recipe recipe) {
        recipeService.update(recipe);
        return HttpStatus.OK;
    }


    protected HttpStatus deleteIngredient (int id) {
            recipeService.delete(id);
            return HttpStatus.OK;
    }


    protected ResponseEntity<List<Recipe>> getAllRecipes () {
        return  new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }
}
