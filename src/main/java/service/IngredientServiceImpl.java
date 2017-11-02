package service;

import javassist.NotFoundException;
import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.IngredientRepository;
import util.exception.ExceptionUtil;

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
    public void delete(int id){
        ExceptionUtil.checkNotFoundWithId(ingredientRepository.delete(id), id);
    }

    @Override
    public Ingredient get(int id) {
        return ExceptionUtil.checkNotFoundWithId(ingredientRepository.get(id), id);
    }

    @Override
    public Ingredient findByName(String name) {
        return ExceptionUtil.checkNotFoundWithId(ingredientRepository.findByName(name), name);
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
