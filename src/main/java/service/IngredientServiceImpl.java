package service;

import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.IngredientRepository;
import util.exception.ExceptionUtil;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final
    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository repository) {
        this.ingredientRepository = repository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        Assert.notNull(ingredient, "Ingredient must not be null");
        return ingredientRepository.save(ingredient);
    }

    @Override
    public boolean delete(int id){
        return ingredientRepository.delete(id);
    }

    @Override
    public Ingredient get(int id) {
        return ExceptionUtil.checkNotFoundWithId(ingredientRepository.get(id), id);
    }

    @Override
    public Ingredient findByName(String name) {
        try {
            return ingredientRepository.findByName(name);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.getAll();
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        Assert.notNull(ingredient, "User must not be null");
        return ingredientRepository.save(ingredient);
    }
}
