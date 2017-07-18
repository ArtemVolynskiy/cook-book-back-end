package web.controllers.dataController;

import model.Recipe;
import model.RecipeIngredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    public @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings(){
        return super.greetings();
    }

    public @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Set<RecipeIngredients>> findRecipe(@RequestParam ("name") String name) {
      return super.findRecipe(name.toLowerCase());
    }

    public @PutMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return super.createRecipe(recipe);
    }

    public @PostMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus updateRecipe(@RequestBody Recipe recipe) {
       return super.updateRecipe(recipe);
    }

    public @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
       return super.deleteIngredient(id);
    }

    public @GetMapping (value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
        ResponseEntity<List<Recipe>> getAllRecipes () {
           return super.getAllRecipes();
        }
}
