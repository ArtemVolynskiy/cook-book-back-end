package web.controllers.dataController;

import model.Recipe;
import model.RecipeIngredients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;
import web.controllers.AbstractRecipeController;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping (RecipeRestController.RECIPE_URL)
public class RecipeRestController extends AbstractRecipeController {
    static final String RECIPE_URL = "/admin/recipe";
    private static final Logger LOG = LoggerFactory.getLogger(RecipeRestController.class);



    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        super(recipeService);
    }

    public @GetMapping (value = "/find")
    ResponseEntity<Set<RecipeIngredients>> findRecipeIngredients(@RequestParam ("name") String recipeName) {
        LOG.debug("Parameter received: recipeName = {}", recipeName);
        return super.findRecipeIngredients(recipeName.toLowerCase());
    }

    public @PutMapping (value = "/create")
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        LOG.debug("Create recipe, parameter received: recipe = {}", recipe);
        return super.createRecipe(recipe);
    }

    public @PostMapping (value = "/update")
    HttpStatus updateRecipe(@RequestBody Recipe recipe) {
        LOG.debug("Update recipe, parameter received: recipe = {}", recipe);
        return super.updateRecipe(recipe);
    }

    public @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
        LOG.debug("Delete recipe, parameter received: id = {}", id);
        return super.deleteIngredient(id);
    }

    public @GetMapping (value = "/all")
    ResponseEntity<List<Recipe>> getAllRecipes () {
        LOG.debug("Get all");
        return super.getAllRecipes();
    }
}
