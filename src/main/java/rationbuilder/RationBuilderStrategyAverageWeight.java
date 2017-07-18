package rationbuilder;

import model.Recipe;
import model.Snack;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component("averageWeight")
public class RationBuilderStrategyAverageWeight implements RationBuilderStrategy {
    @Override
    public List<Recipe> buildRation(int calories, List<Recipe> recipes, List<Snack> snacks) {
        Map<String, Set<Recipe>> sortedRecipes =
                util.converter.CollectionConverter.divideRecipesByType(recipes);

        Iterator breakfastIterator = sortedRecipes.get("breakfast").iterator();
        Iterator lunchIterator = sortedRecipes.get("lunch").iterator();
        Iterator dinnerIterator = sortedRecipes.get("dinner").iterator();

        RationBuilderTestStrategy.setBreakfastCaloriesPercent(35);
        RationBuilderTestStrategy.setLunchCaloriesPercent(45);
        RationBuilderTestStrategy.setDinnerCaloriesPercent(25);

        return RationBuilderTestStrategy.buildRation(breakfastIterator, lunchIterator, dinnerIterator, snacks,
                calories);
    }
}
