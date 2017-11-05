package web.controllers;


import model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.IngredientService;
import util.error.CustomError;

import java.util.List;



public class AbstractIngredientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractIngredientController.class);

    private final
    IngredientService ingredientService; // Entity responsible for all the data manipulations with ingredients


    public AbstractIngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    /**
     * <p>Method is responsible for retrieving ingredients from ingredientService provided by Spring
     * through autowired annotation</p>
     *
     * <p>Search is based on the name of the ingredient. In case if requested ingredient does not exist HttpStatus 'Not Found' will be returned.</p>
     * @param ingredientName the name of the ingredient about to be retrieved. Case insensitive.
     * @return single ingredient entity
     */
    protected ResponseEntity<?> findIngredientByName(String ingredientName) {
        LOGGER.info("Fetching ingredient with name: {}", ingredientName);

        Ingredient ingredient = ingredientService.findByName(ingredientName.toLowerCase());
        if (ingredient == null) {
            LOGGER.error("Ingredient not found: {}", ingredientName);
            return new ResponseEntity<>(new CustomError("Unable to update, ingredient with name: " + ingredientName + " does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for creating new ingredient. In case if provided ingredient is already exists in the database HttpStatus 'Conflict' will be returned.</p>
     * @param ingredient the ingredient about to be created
     * @return single ingredient entity
     */
    protected ResponseEntity<?> createIngredient (Ingredient ingredient ) {
        LOGGER.info("Creating ingredient: {}", ingredient);

        Ingredient currentIngredient = ingredientService.findByName(ingredient.getName().toLowerCase());
        if (currentIngredient != null) {
            LOGGER.error("Unable to create, ingredient with name: {} already exists", ingredient.getName());
            return new ResponseEntity<>(new CustomError("Unable to create, ingredient with name: " + currentIngredient.getName() + " already exists"), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ingredientService.save(ingredient), HttpStatus.CREATED);
    }

    /**
     * <p>Method is responsible for updating existing ingredient. If provided ingredient is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param ingredient the ingredient about to be updated
     * @return ResponseEntity with relevant HttpStatus
     */
    protected ResponseEntity<?> updateIngredient(Ingredient ingredient) {
        LOGGER.info("Updating ingredient with id: {}", ingredient.getId());

        Ingredient currentIngredient = ingredientService.get(ingredient.getId());
        if (currentIngredient == null) {
            LOGGER.error("Failed to update, ingredient with id: {} doesn't exist");
            return new ResponseEntity<>(new CustomError("Unable to update, ingredient with name: " + ingredient.getName() + " does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ingredientService.update(ingredient), HttpStatus.OK);
    }

    /**
     * <p>Method is responsible for deleting existing ingredient. If provided ingredient is not registered in the database HttpStatus 'Not Found' will be returned</p>
     * @param id the id of the ingredient about to be deleted
     * @return relevant HttpStatus
     */
    protected ResponseEntity<?> deleteIngredient (int id) {
        LOGGER.info("Deleting ingredient with id: {}", id);

        if(!ingredientService.delete(id)){
            LOGGER.error("Delete failed, ingredient with id: {} not found", id);
            return new ResponseEntity<>(new CustomError("Unable to delete, recipe with id: " + id + " does not exist"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User with id: " + id + " was successfully deleted",HttpStatus.OK);
    }


    /**
     * <p>Method is responsible for retrieving all the ingredients registered in the database.</p>
     * @return List of ingredients
     */
    protected ResponseEntity<?> findAll () {
        LOGGER.info("Retrieving all ingredients");
        List<Ingredient> ingredients = ingredientService.getAll();
        if (ingredients == null || ingredients.size() == 0) {
            LOGGER.error("Couldn't fetch ingredient list, returned list is either empty or not initialized");
            return new ResponseEntity<>(new CustomError("Couldn't fetch ingredient list, returned list is either empty or not initialized"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }
}
