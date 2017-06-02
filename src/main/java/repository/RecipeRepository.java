package repository;

import model.Recipe;


import java.util.List;

public interface RecipeRepository {
    Recipe save(Recipe recipe);

    // Null if not found
    Recipe get (String name);

    // False if not found
    boolean delete (String name);

    List<Recipe> getAll();

}
