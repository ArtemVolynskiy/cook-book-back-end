package service;


import javassist.NotFoundException;
import model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient save (Ingredient ingredient);

    void delete (String name) throws NotFoundException;

    Ingredient get (String name) throws NotFoundException;

    List<Ingredient> getAll();

    void update (Ingredient ingredient);
}
