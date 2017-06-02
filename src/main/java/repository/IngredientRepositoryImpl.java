package repository;


import model.Ingredient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient.isNew()) {
            em.persist(ingredient);
            return ingredient;
        } else {
           return em.merge(ingredient);
        }
    }

    @Override
    public Ingredient get(String name) {
        return em.find(Ingredient.class, name);
    }

    @Override
    public boolean delete(String name) {
        return em.createNamedQuery(Ingredient.DELETE).setParameter("name", name).executeUpdate() != 0;
    }

    @Override
    public List<Ingredient> getAll() {
        return em.createNamedQuery(Ingredient.GET_ALL, Ingredient.class).getResultList();
    }
}
