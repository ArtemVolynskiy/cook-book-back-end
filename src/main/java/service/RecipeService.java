package service;


import javassist.NotFoundException;
import model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save (Recipe recipe);

    void delete (String name) throws NotFoundException;

    Recipe get (String name) throws NotFoundException;

    List<Recipe> getAll ();

    void update (Recipe recipe);
}
