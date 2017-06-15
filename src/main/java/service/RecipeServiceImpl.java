package service;


import javassist.NotFoundException;
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
//
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        recipeRepository.delete(id);
    }

    @Override
    public Recipe get(int id) {
        return recipeRepository.get(id);
    }

    @Override
    public Recipe findByName(String name) {
        return recipeRepository.findByName(name);
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
