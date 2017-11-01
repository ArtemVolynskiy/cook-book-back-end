package web.controllers.dataController;



import model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IngredientService;
import web.controllers.AbstractIngredientController;

import java.util.List;

@RestController
@RequestMapping (value = IngredientRestController.INGREDIENTS_URL)
public class IngredientRestController extends AbstractIngredientController {
    static final String INGREDIENTS_URL = "/admin/ingredient";
    private static final Logger LOG = LoggerFactory.getLogger(IngredientRestController.class);



    @Autowired
    public IngredientRestController(IngredientService ingredientService) {
       super(ingredientService);
    }


    public @GetMapping (value = "/find")
    ResponseEntity<Ingredient> findIngredient (@RequestParam ("name") String name) {
        LOG.debug("Find, parameter received: name = {}", name);
       return super.findIngredient(name);
    }

    public @PutMapping (value = "/create")
    ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient ingredient ) {
        LOG.debug("Create, parameter received: ingredient = {}", ingredient);
        return super.createIngredient(ingredient);
    }

    public @PostMapping (value = "/update")
    HttpStatus updateIngredient(@RequestBody Ingredient ingredient) {
        LOG.debug("Update, parameter received: ingredient = {}", ingredient);
        return super.updateIngredient(ingredient);
    }

    public @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
        LOG.debug("Delete, parameter received: id = {}", id);
      return super.deleteIngredient(id);
    }


    public @GetMapping (value = "/all")
    ResponseEntity<List<Ingredient>> findAll () {
        LOG.debug("Get all");
        return super.findAll();
    }

}
