package service;


import model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient save (Ingredient ingredient);

    boolean delete (int id);

    Ingredient get (int id);

    Ingredient findByName (String name);

    List<Ingredient> getAll();

    Ingredient update (Ingredient ingredient);
}
