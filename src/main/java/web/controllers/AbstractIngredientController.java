package web.controllers;


import javassist.NotFoundException;
import model.Ingredient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.IngredientService;

import javax.persistence.NoResultException;
import java.util.List;

public class AbstractIngredientController {

    private final
    IngredientService ingredientService;


    public AbstractIngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }



    public String greetings () {
        return "Welcome to ingredients controller!";
    }


    public ResponseEntity<Ingredient> findIngredient (String name) {
        try {
            Ingredient foundIngredient = ingredientService.findByName(name.toLowerCase());
            return new ResponseEntity<>(foundIngredient, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Ingredient> createIngredient (Ingredient ingredient ) {
        return new ResponseEntity<>(ingredientService.save(ingredient), HttpStatus.CREATED);
    }


    public HttpStatus updateIngredient(Ingredient ingredient) {
        ingredientService.update(ingredient);
        return HttpStatus.OK;
    }


    public HttpStatus deleteIngredient (int id) {
        try {
            ingredientService.delete(id);
            return HttpStatus.OK;
        } catch (NotFoundException e) {
            return HttpStatus.NOT_FOUND;
        }
    }



    public ResponseEntity<List<Ingredient>> findAll () {
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

}
