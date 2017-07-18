package web.controllers;


import javassist.NotFoundException;
import model.Recipe;
import model.RecipeIngredients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.RecipeService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;

public class AbstractRecipeController {

    private final
    RecipeService recipeService;



    protected AbstractRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    protected String greetings(){
        return "Welcome to recipe controller!";
    }


    protected  ResponseEntity<Set<RecipeIngredients>> findRecipe(String name) {
        try {
            Recipe recipe = recipeService.findByName(name);
            for (int i = 0; i < 100; i++) {
                System.out.println(recipe.getName());
            }
            return new ResponseEntity<>(recipe.getIngredients(), HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    protected ResponseEntity<Recipe> createRecipe(Recipe recipe) {

        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.CREATED);
    }


    protected HttpStatus updateRecipe(Recipe recipe) {
        recipeService.update(recipe);
        return HttpStatus.OK;
    }


    protected HttpStatus deleteIngredient (int id) {
        try {
            recipeService.delete(id);
            return HttpStatus.OK;
        } catch (NotFoundException e) {
            return HttpStatus.NOT_FOUND;
        }
    }


    protected ResponseEntity<List<Recipe>> getAllRecipes () {
        return  new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }
}
