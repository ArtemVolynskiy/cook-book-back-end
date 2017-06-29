package web.controllers.dataController;



import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IngredientService;
import web.controllers.AbstractIngredientController;

import java.util.List;

@RestController
@RequestMapping (value = IngredientRestController.INGREDIENTS_URL)
public class IngredientRestController extends AbstractIngredientController {
    static final String INGREDIENTS_URL = "/admin/ingredient";



    @Autowired
    public IngredientRestController(IngredientService ingredientService) {
       super(ingredientService);
    }


    public @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings () {
        return super.greetings();
    }

    public @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> findIngredient (@RequestParam ("name") String name) {
       return super.findIngredient(name);
    }

    public @PutMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient ingredient ) {
        return super.createIngredient(ingredient);
    }

    public @PostMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus updateIngredient(@RequestBody Ingredient ingredient) {
        return super.updateIngredient(ingredient);
    }

    public @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
      return super.deleteIngredient(id);
    }


    public @GetMapping (value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Ingredient>> findAll () {
        return super.findAll();
    }

}
