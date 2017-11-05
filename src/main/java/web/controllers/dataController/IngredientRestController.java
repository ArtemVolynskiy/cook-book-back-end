package web.controllers.dataController;



import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IngredientService;
import web.controllers.AbstractIngredientController;

import java.util.List;

@RestController
@RequestMapping (value = IngredientRestController.INGREDIENTS_URL)
public class IngredientRestController extends AbstractIngredientController {
    /**
     * JavaDoc for methods provided in this class is available at AbstractIngredientController
     */
    static final String INGREDIENTS_URL = "/admin/ingredient";



    @Autowired
    public IngredientRestController(IngredientService ingredientService) {
       super(ingredientService);
    }


    public @GetMapping (value = "/find")
    ResponseEntity<?> findIngredientByName(@RequestParam ("name") String name) {
       return super.findIngredientByName(name);
    }

    public @PutMapping (value = "/create")
    ResponseEntity<?> createIngredient (@RequestBody Ingredient ingredient ) {
        return super.createIngredient(ingredient);
    }

    public @PostMapping (value = "/update")
    ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient) {
        return super.updateIngredient(ingredient);
    }

    public @DeleteMapping (value = "/delete")
    ResponseEntity<?> deleteIngredient (@RequestParam ("id") int id) {
      return super.deleteIngredient(id);
    }


    public @GetMapping (value = "/all")
    ResponseEntity<?> findAll () {
        return super.findAll();
    }

}
