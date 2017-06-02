package service;

import javassist.NotFoundException;
import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IngredientRepository;

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
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(String name) throws NotFoundException {
        ingredientRepository.delete(name);
    }

    @Override
    public Ingredient get(String name) throws NotFoundException {
        return ingredientRepository.get(name);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.getAll();
    }

    @Override
    public void update(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
