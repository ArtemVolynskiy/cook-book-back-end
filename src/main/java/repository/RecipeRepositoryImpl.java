package repository;


import model.Recipe;
import model.Snack;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional (readOnly = true)
public class RecipeRepositoryImpl implements RecipeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Recipe save(Recipe recipe) {
        if (recipe.isNew()){
          em.persist(recipe);
          return recipe;
        } else {
           return em.merge(recipe);
        }
    }


    @Override
    public Recipe get(int id) {
        return em.find(Recipe.class, id);
    }

    @Override
    public Recipe findByName(String name) {
        return em.createNamedQuery(Recipe.FIND_BY_NAME, Recipe.class).setParameter("name", name).getSingleResult();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
       return em.createNamedQuery(Recipe.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Recipe> getAll() {
        return em.createNamedQuery(Recipe.GET_ALL, Recipe.class).getResultList();
    }

    @Override
    public List<Recipe> getLowCaloriesRecipes() {
        return em.createNamedQuery(Recipe.GET_LOW_CALORIE_RECIPES, Recipe.class).getResultList();
    }

    @Override
    public List<Recipe> getAverageCaloriesRecipes() {
        return em.createNamedQuery(Recipe.GET_AVERAGE_CALORIE_RECIPES, Recipe.class).getResultList();
    }

    @Override
    public List<Recipe> getHighCaloriesRecipes() {
        return em.createNamedQuery(Recipe.GET_HIGH_CALORIE_RECIPES, Recipe.class).getResultList();
    }

    @Override
    public List<Recipe> getSuperHighCaloriesRecipes() {
        return em.createNamedQuery(Recipe.GET_SUPER_HIGH_CALORIE_RECIPES, Recipe.class).getResultList();
    }

    @Override
    public List<Snack> getAllSnacks() {
        return em.createNamedQuery(Snack.GET_ALL, Snack.class).getResultList();
    }
}
