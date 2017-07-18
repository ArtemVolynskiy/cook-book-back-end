package service;


import javassist.NotFoundException;
import model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save (Recipe recipe);

    void delete (int id) throws NotFoundException;

    Recipe get (int id) throws NotFoundException;

    Recipe findByName (String name);

    List<Recipe> getAll ();

    void update (Recipe recipe);

    List<Recipe> buildRation(int userCalories);
}
