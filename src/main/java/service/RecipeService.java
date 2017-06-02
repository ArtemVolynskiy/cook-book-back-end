package service;


import model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe save (Recipe recipe);

    void delete (String name);

    Recipe get (String name);

    List<Recipe> getAll ();

    void update (Recipe recipe);
}
