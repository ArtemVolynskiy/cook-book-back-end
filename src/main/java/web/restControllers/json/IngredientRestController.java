package web.restControllers.json;


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
@CrossOrigin()
@RequestMapping (value = IngredientRestController.INGREDIENTS_URL)
public class IngredientRestController {
    static final String INGREDIENTS_URL = "/admin/ingredient";

    private final
    IngredientService ingredientService;

    @Autowired
    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    String greetings () {
        return "Welcome to ingredients controller!";
    }

    @GetMapping (value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> findIngredient (@RequestParam ("name") String name) {
        try {
            Ingredient foundIngredient = ingredientService.findByName(name.toLowerCase());
            return new ResponseEntity<Ingredient>(foundIngredient, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<Ingredient>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient ingredient ) {
        return new ResponseEntity<Ingredient>(ingredientService.save(ingredient), HttpStatus.CREATED);
    }

    @PostMapping (value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus updateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.update(ingredient);
        return HttpStatus.OK;
    }

    @DeleteMapping (value = "/delete")
    HttpStatus deleteIngredient (@RequestParam int id) {
        try {
            ingredientService.delete(id);
            return HttpStatus.OK;
        } catch (NotFoundException e) {
            return HttpStatus.NOT_FOUND;
        }
    }


    @GetMapping (value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Ingredient>> findAll () {
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

}
