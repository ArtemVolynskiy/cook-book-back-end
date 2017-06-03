package web.restControllers;

import javassist.NotFoundException;
import model.Ingredient;
import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.IngredientService;
import service.RecipeService;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping (RecipeRestController.RECIPE_URL)
public class RecipeRestController {
    static final String RECIPE_URL = "/recipe";

    @Autowired
    IngredientService ingredientService;

    private final
    RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings(){
        Ingredient ingredient1;
        Ingredient ingredient2;
        try {
            ingredient1 = ingredientService.get("Kartoshka");
            ingredient2 = ingredientService.get("Kurochka");
        } catch (Exception e) {
            ingredient1 = new Ingredient(5, "Kartoshka", 100, true);
            ingredient2 = new Ingredient(6, "Kurochka", 200, true);
        }
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        byte[] bites = new byte[]{0,0,0};
        Recipe recipe = new Recipe(9, "Miaso s kartoshkoi", 400, 70, bites,
                ingredients, "Jarish I beresh");
        recipeService.save(recipe);
        return "Welcome to recipe controller!";
    }

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recipe> findRecipe(@RequestParam ("name") String name) {
        Recipe foundRecipe = recipeService.get(name);
        return new ResponseEntity<Recipe>(foundRecipe, HttpStatus.FOUND);
    }

    @PostMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.save(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @GetMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateRecipe(@RequestBody Recipe recipe) {
        recipeService.update(recipe);
    }

    @DeleteMapping (value = "/delete" )
    void deleteRecipe (@RequestParam ("name") String name) {
        recipeService.delete(name);
    }

    @GetMapping (value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Recipe> getAllRecipes () {
        return  recipeService.getAll();
    }
}
