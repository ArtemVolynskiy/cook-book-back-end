package web.restControllers;

import com.fasterxml.jackson.databind.node.TextNode;
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

import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping (RecipeRestController.RECIPE_URL)
public class RecipeRestController {
    static final String RECIPE_URL = "/admin/recipe";

    private final
    RecipeService recipeService;

    private final
    IngredientService ingredientService;

    @Autowired
    public RecipeRestController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings(){
        return "Welcome to recipe controller!";
    }

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recipe> findRecipe(@RequestParam ("name") String name) {
        try {
            return new ResponseEntity<Recipe>(recipeService.findByName(name.toLowerCase()), HttpStatus.FOUND);
        } catch (NoResultException e) {
            return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
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
    HttpStatus deleteRecipe (@RequestBody TextNode name) {
        try {
            recipeService.delete(Integer.parseInt(name.textValue()));
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
