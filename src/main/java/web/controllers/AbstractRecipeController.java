package web.controllers;


import model.Recipe;
import model.RecipeIngredients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.RecipeService;

import java.util.List;
import java.util.Set;

public class AbstractRecipeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRecipeController.class);

    private final RecipeService recipeService; // Entity responsible for all the data manipulations with recipes


    protected AbstractRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * <p>Method is responsible for retrieving recipe ingredients from recipeService provided by Spring
     * through autowired annotation</p>
     *
     * <p>Search is based on the name of the recipe. In case if requested recipe does not exist HttpStatus 'Not Found' will be returned.</p>
     * @param recipeName the name of the recipe whose ingredients about to be retrieved. Case insensitive.
     * @return Set of ingredients from given recipe.
     */
    protected  ResponseEntity<Set<RecipeIngredients>> findRecipeIngredients(String recipeName) {
        LOGGER.info("Fetching recipe ingredients for {}", recipeName);

        Recipe recipe = recipeService.findByName(recipeName.toLowerCase());
        if (recipe == null) {
            LOGGER.error("Recipe not found: {}", recipeName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe.getIngredients(), HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for creating new recipe. In case if provided recipe is already exists in the database HttpStatus 'Conflict' will be returned.</p>
     * @param recipe the ingredient about to be created
     * @return single recipe entity
     */
    protected ResponseEntity<Recipe> createRecipe(Recipe recipe) {
        LOGGER.info("Creating recipe with name: {}", recipe.getName());

        Recipe currentRecipe = recipeService.findByName(recipe.getName());
        if (currentRecipe != null) {
            LOGGER.error("Unable to create, recipe with name: {} already exists", recipe.getName());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.CREATED);
    }

    /**
     * <p>Method is responsible for updating existing recipe. If provided recipe is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param recipe the recipe about to be updated
     * @return ResponseEntity with relevant HttpStatus
     */
    protected ResponseEntity<Recipe> updateRecipe(Recipe recipe) {
        LOGGER.info("Updating recipe with name: {}", recipe.getName());

        Recipe currentRecipe = recipeService.get(recipe.getId());

        if (currentRecipe == null) {
            LOGGER.error("Unable to update, recipe with name: {} does not exist", recipe.getName());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recipeService.update(recipe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for deleting existing recipe. Ingredients from the deleted recipe remain in the database.
     * If provided recipe is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param id the id of the ingredient about to be deleted
     * @return relevant HttpStatus
     */
    protected ResponseEntity<Recipe> deleteIngredient (int id) {
        LOGGER.info("Deleting recipe with id: {}", id);

        Recipe recipe = recipeService.get(id);
        if (recipe == null) {
            LOGGER.error("Delete failed, recipe with id: {} not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        recipeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for retrieving all the recipes registered in the database.</p>
     * @return List of ingredients
     */
    protected ResponseEntity<List<Recipe>> getAllRecipes () {
        LOGGER.info("Retrieving all recipes");
        return  new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }
}
