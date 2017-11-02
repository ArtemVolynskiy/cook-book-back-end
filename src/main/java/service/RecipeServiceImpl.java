package service;


import model.Recipe;
import model.Snack;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rationbuilder.RationBuilderStrategy;
import repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final
    RecipeRepository recipeRepository;

    private final
    BeanFactory beanFactory;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, BeanFactory beanFactory) {
        this.recipeRepository = recipeRepository;
        this.beanFactory = beanFactory;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(int id){
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
    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> buildRation(int userCalories) {
        List<Recipe> allRecipes;
        List<Snack> snacks = recipeRepository.getAllSnacks();
        if (userCalories <= 1200) {
            allRecipes = recipeRepository.getLowCaloriesRecipes();
            return beanFactory.getBean("averageWeight", RationBuilderStrategy.class).buildRation(userCalories, allRecipes, snacks);
        } else if (userCalories <= 1800) {
            allRecipes = recipeRepository.getAverageCaloriesRecipes();
            return beanFactory.getBean("averageWeight", RationBuilderStrategy.class).buildRation(userCalories, allRecipes, snacks);
        } else if (userCalories <= 2500) {
            allRecipes = recipeRepository.getHighCaloriesRecipes();
            return beanFactory.getBean("heavyWeight", RationBuilderStrategy.class).buildRation(userCalories, allRecipes, snacks);
        } else {
            allRecipes = recipeRepository.getSuperHighCaloriesRecipes();
            return beanFactory.getBean("heavyWeight", RationBuilderStrategy.class).buildRation(userCalories, allRecipes, snacks);
        }
    }
}
