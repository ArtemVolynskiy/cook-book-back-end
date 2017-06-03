package web.restControllers;

import javassist.NotFoundException;
import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IngredientService;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping (value = IngredientRestController.INGREDIENTS_URL)
public class IngredientRestController {
     static final String INGREDIENTS_URL = "/ingredient";

     private final
     IngredientService ingredientService;

    @Autowired
    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings () {
//        Ingredient ingredient1 = new Ingredient(5, "Kartoshka", 100, true);
//        ingredientService.save(ingredient1);
        Ingredient ingredient = null;
        try {
            ingredient = ingredientService.get("Kartoshka");
        } catch (Exception e) {
            ingredient = new Ingredient(5, "Kartoshka", 100, true);
        }


//        return "Welcome to ingredients controller!";
        return ingredient.toString();
    }

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> findIngredient (@RequestParam ("name") String name) {
        try {
            Ingredient foundIngredient = ingredientService.get(name);

            return new ResponseEntity<Ingredient>(foundIngredient, HttpStatus.FOUND);
        } catch (NotFoundException e) {
            return new ResponseEntity<Ingredient>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient ingredient ) {
        return new ResponseEntity<Ingredient>(ingredientService.save(ingredient), HttpStatus.CREATED);
    }

    @PostMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.save(ingredient);
    }

    @DeleteMapping (value = "/delete")
    void deleteIngredient (@RequestParam ("name") String name) {
        try {
            ingredientService.delete(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping (value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Ingredient> findAll () {
        return ingredientService.getAll();
    }

}
