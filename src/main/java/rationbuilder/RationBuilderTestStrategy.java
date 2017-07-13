package rationbuilder;


import model.BasicMealEntity;
import model.Recipe;
import model.Snack;

import static util.checker.RationBuilderUtils.*;

import java.util.*;


class RationBuilderTestStrategy {
    private static int breakfastCaloriesPercent;
    private static int lunchCaloriesPercent = 45;
    private static int dinnerCaloriesPercent = 25;

    static List<List> buildRation(Iterator breakfastIterator, Iterator lunchIterator, Iterator dinnerIterator,
                                         List<Snack> snacks, int userCalories) {
        int breakfastCalories = (int) getPercentValue(breakfastCaloriesPercent, userCalories);
        int lunchCalories = (int) getPercentValue(lunchCaloriesPercent, userCalories);
        int dinnerCalories = (int) getPercentValue(dinnerCaloriesPercent, userCalories);

        List<BasicMealEntity> breakfast = findPerfectRecipe(breakfastIterator, breakfastCalories, snacks);
        List<BasicMealEntity> lunch = findPerfectRecipe(lunchIterator, lunchCalories, snacks);
        List<BasicMealEntity> dinner = findPerfectRecipe(dinnerIterator, dinnerCalories, snacks);



        return populateList(breakfast, lunch, dinner);
    }

    private static double getPercentValue(int percent, int value) {
        double sum = (double)value / 100 * percent;
        System.out.println(sum);
        return sum;
    }

    private static List<BasicMealEntity> findPerfectRecipe(Iterator recipeIterator, int desiredCalories, List<Snack> snacks) {
        List<BasicMealEntity> recipes = new LinkedList<>();
        int prevClosest = 10000;
        Recipe currentRecipe;
        Recipe closestRecipe = null;

        while (recipeIterator.hasNext()) {
            currentRecipe = (Recipe) recipeIterator.next();
            if (inTheGap(currentRecipe.getCalories(), desiredCalories)) {
                recipes.add(currentRecipe);
                return recipes;
            } else {
                int howClose = closestMuch(currentRecipe.getCalories(), desiredCalories);
                if (howClose > 0) {
                    if (howClose < prevClosest) {
                        prevClosest = howClose;
                        closestRecipe = currentRecipe;
                    }
                }
            }
        }

        if (!recipes.isEmpty()) {
            return recipes;
        }

        assert closestRecipe != null;
        BasicMealEntity drink = addMeal(closestRecipe.getCalories(), desiredCalories, closestRecipe.getDrinks());

        recipes.add(closestRecipe);
        recipes.add(drink);

        if (inTheGap(closestRecipe.getCalories() + drink.getCalories(), desiredCalories)){
            return recipes;
        } else {
            BasicMealEntity snack = addMeal(closestRecipe.getCalories()+ drink.getCalories(), desiredCalories, snacks);
            recipes.add(snack);
            return recipes;
        }
    }

    private static BasicMealEntity addMeal(int currentCalories, int targetCalories, Collection extras) {
        int prevClosest = 10000;
        Iterator mealIterator = extras.iterator();

        BasicMealEntity closestRecipe = null;
        BasicMealEntity currentDrink;

        while (mealIterator.hasNext()) {
            currentDrink = (BasicMealEntity) mealIterator.next();
            if (inTheGap((currentDrink.getCalories() + currentCalories), targetCalories)) {
                return currentDrink;
            } else {
                int howClose = closestMuch(currentDrink.getCalories() + currentCalories, targetCalories);
                if (howClose > 0) {
                    if (howClose < prevClosest) {
                        prevClosest = howClose;
                        closestRecipe = currentDrink;
                    }
                }
            }
        }
        return closestRecipe;
    }

    static void setBreakfastCaloriesPercent(int breakfastCaloriesPercent) {
        RationBuilderTestStrategy.breakfastCaloriesPercent = breakfastCaloriesPercent;
    }

    public static void setLunchCaloriesPercent(int lunchCaloriesPercent) {
        RationBuilderTestStrategy.lunchCaloriesPercent = lunchCaloriesPercent;
    }

    public static void setDinnerCaloriesPercent(int dinnerCaloriesPercent) {
        RationBuilderTestStrategy.dinnerCaloriesPercent = dinnerCaloriesPercent;
    }
}
