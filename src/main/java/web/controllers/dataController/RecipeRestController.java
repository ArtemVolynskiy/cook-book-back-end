package web.controllers.dataController;

import javassist.NotFoundException;
import model.Recipe;
import model.RecipeIngredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RecipeService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping (RecipeRestController.RECIPE_URL)
public class RecipeRestController {
    static final String RECIPE_URL = "/recipe";

    private final
    RecipeService recipeService;


    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings(){
        return "Welcome to recipe controller!";
    }

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Set<RecipeIngredients>> findRecipe(@RequestParam ("name") String name) {
        try {
            Recipe recipe = recipeService.findByName(name.toLowerCase());
            return new ResponseEntity<>(recipe.getIngredients(), HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {

        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.CREATED);
    }

    @PostMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus updateRecipe(@RequestBody Recipe recipe) {
        recipeService.update(recipe);
        return HttpStatus.OK;
    }

    @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
        try {
            recipeService.delete(id);
            return HttpStatus.OK;
        } catch (NotFoundException e) {
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping (value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Recipe>> getAllRecipes () {
        return  new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }
}
