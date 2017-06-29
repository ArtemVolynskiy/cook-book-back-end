package repository;

import model.Recipe;


import java.util.List;

public interface RecipeRepository {
    Recipe save(Recipe recipe);

    // Null if not found
    Recipe get (int id);

    Recipe findByName (String name);

    void delete (int id);

    List<Recipe> getAll();

}
