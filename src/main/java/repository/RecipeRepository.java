package repository;

import model.Recipe;
import model.Snack;


import java.util.List;

public interface RecipeRepository {
    Recipe save(Recipe recipe);

    // Null if not found
    Recipe get (int id);

    Recipe findByName (String name);

    void delete (int id);

    List<Recipe> getAll();

    List<Recipe> getLowCaloriesRecipes();

    List<Recipe> getAverageCaloriesRecipes();

    List<Recipe> getHighCaloriesRecipes();

    List<Recipe> getSuperHighCaloriesRecipes();

    List<Snack> getAllSnacks();
}
