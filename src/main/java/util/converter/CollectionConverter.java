package util.converter;

import model.Recipe;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



public class CollectionConverter {
    public static Map<String, Set<Recipe>> divideRecipesByType(List<Recipe> recipes) {
        return   recipes.stream()
                .collect(Collectors.groupingByConcurrent(Recipe::getType, Collectors.toSet())
                );
    }
}
