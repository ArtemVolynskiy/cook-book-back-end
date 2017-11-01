package repository;


import model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class IngredientRepositoryImpl implements IngredientRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Ingredient save(Ingredient ingredient) {
        if (ingredient.isNew()) {
            ingredient.setName(ingredient.getName().toLowerCase());
            em.persist(ingredient);
            return ingredient;
        } else {
           return em.merge(ingredient);
        }
    }

    @Override
    public Ingredient get(int id) {
      return em.find(Ingredient.class, id);
    }

    @Override
    public Ingredient findByName(String name) {
        return em.createNamedQuery(Ingredient.FIND, Ingredient.class).setParameter("name", name).getSingleResult();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
//        em.remove(em.find(Ingredient.class, id));
        return em.createNamedQuery(Ingredient.DELETE).
                setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Ingredient> getAll() {
        return em.createNamedQuery(Ingredient.GET_ALL, Ingredient.class).getResultList();
    }
}
