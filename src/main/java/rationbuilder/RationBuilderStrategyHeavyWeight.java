package rationbuilder;


import model.Recipe;
import model.Snack;
import org.springframework.stereotype.Component;
import util.rationbuilder.HighCaloriesRationBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component("heavyWeight")
public class RationBuilderStrategyHeavyWeight implements RationBuilderStrategy {
    @Override
    public List<List> buildRation(int calories, List<Recipe> recipes, List<Snack> snacks) {

        Map<String, Set<Recipe>> sortedRecipes =
                util.converter.CollectionConverter.divideRecipesByType(recipes);

        Iterator breakfastIterator = sortedRecipes.get("breakfast").iterator();
        Iterator lunchIterator = sortedRecipes.get("lunch").iterator();
        Iterator dinnerIterator = sortedRecipes.get("dinner").iterator();

        RationBuilderTestStrategy.setBreakfastCaloriesPercent(30);
        RationBuilderTestStrategy.setLunchCaloriesPercent(36);
        RationBuilderTestStrategy.setDinnerCaloriesPercent(34);

        return RationBuilderTestStrategy.buildRation(breakfastIterator, lunchIterator, dinnerIterator, snacks,
                calories);
    }
}
