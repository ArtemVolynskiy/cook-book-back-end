package service;


import javassist.NotFoundException;
import model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save (Recipe recipe);

    boolean delete (int id);

    Recipe get (int id);

    Recipe findByName (String name);

    List<Recipe> getAll ();

    Recipe update (Recipe recipe);

    List<Recipe> buildRation(int userCalories);
}
