package repository;


import model.Ingredient;
import java.util.List;

public interface IngredientRepository {

    Ingredient save(Ingredient ingredient);

    // Null if not found
    Ingredient get (int id);

    Ingredient findByName (String name);

    // False if not found
    boolean delete (String name);

    List<Ingredient> getAll();

}
