package service;


import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(String name) {
        recipeRepository.delete(name);
    }

    @Override
    public Recipe get(String name) {
        return recipeRepository.get(name);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.getAll();
    }

    @Override
    public void update(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
