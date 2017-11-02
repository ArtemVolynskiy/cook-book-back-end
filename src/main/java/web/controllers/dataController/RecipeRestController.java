package web.controllers.dataController;

import model.Recipe;
import model.RecipeIngredients;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        super(recipeService);
    }

    public @GetMapping (value = "/find")
    ResponseEntity<Set<RecipeIngredients>> findRecipeIngredients(@RequestParam ("name") String recipeName) {
        return super.findRecipeIngredients(recipeName.toLowerCase());
    }

    public @PutMapping (value = "/create")
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return super.createRecipe(recipe);
    }

    public @PostMapping (value = "/update")
    ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return super.updateRecipe(recipe);
    }

    public @DeleteMapping (value = "/delete")
    ResponseEntity<Recipe> deleteIngredient (@RequestParam int id) {
        return super.deleteIngredient(id);
    }

    public @GetMapping (value = "/all")
    ResponseEntity<List<Recipe>> getAllRecipes () {
        return super.getAllRecipes();
    }
}
