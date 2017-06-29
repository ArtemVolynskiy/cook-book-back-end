package service;


import javassist.NotFoundException;
import model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient save (Ingredient ingredient);

    void delete (int id) throws NotFoundException;

    Ingredient get (int id) throws NotFoundException;

    Ingredient findByName (String name);

    List<Ingredient> getAll();

    void update (Ingredient ingredient);
}
