package rationbuilder;


import model.*;

import static util.checker.RationBuilderUtils.*;

import java.util.*;


class RationBuilderTestStrategy {
    private static int breakfastCaloriesPercent;
    private static int lunchCaloriesPercent = 45;
    private static int dinnerCaloriesPercent = 25;

    static List<Recipe> buildRation(Iterator breakfastIterator, Iterator lunchIterator, Iterator dinnerIterator,
                                         List<Snack> snacks, int userCalories) {

        int breakfastCalories = (int) getPercentValue(breakfastCaloriesPercent, userCalories);
        int lunchCalories = (int) getPercentValue(lunchCaloriesPercent, userCalories);
        int dinnerCalories = (int) getPercentValue(dinnerCaloriesPercent, userCalories);

        Recipe breakfast = findPerfectRecipe(breakfastIterator, breakfastCalories, snacks);
        Recipe lunch = findPerfectRecipe(lunchIterator, lunchCalories, snacks);
        Recipe dinner = findPerfectRecipe(dinnerIterator, dinnerCalories, snacks);



        return populateList(breakfast, lunch, dinner);
    }

    private static double getPercentValue(int percent, int value) { // returns percentage of the value sent as an argument
        return (double)value / 100 * percent;
    }

    private static RecipeTO findPerfectRecipe(Iterator recipeIterator, int desiredCalories, List<Snack> snacks) {


        int prevClosest = 10000;
        Recipe currentRecipe;
        Recipe closestRecipe = null;

        while (recipeIterator.hasNext()) {
            currentRecipe = (Recipe) recipeIterator.next();
            if (inTheGap(currentRecipe.getCalories(), desiredCalories)) {
                return  new RecipeTO(currentRecipe);
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


        assert closestRecipe != null;
        Drink drink = (Drink) addMeal(closestRecipe.getCalories(), desiredCalories, closestRecipe.getDrinks());

        if (inTheGap(closestRecipe.getCalories() + drink.getCalories(), desiredCalories)){
            return  new RecipeTO(closestRecipe, drink);
        } else {
            Snack snack = (Snack) addMeal(closestRecipe.getCalories()+ drink.getCalories(), desiredCalories, snacks);
            return new RecipeTO(closestRecipe, drink, snack);
        }
    }

    private static BasicMealEntity addMeal(int currentCalories, int targetCalories, Collection extras) {
        int prevClosest = Integer.MAX_VALUE;
        Iterator mealIterator = extras.iterator();

        BasicMealEntity closestRecipe = null;
        BasicMealEntity currentDrink;

        while (mealIterator.hasNext()) {
            currentDrink = (BasicMealEntity) mealIterator.next();
            if (inTheGap((currentDrink.getCalories() + currentCalories), targetCalories)) {
                return currentDrink;
            } else {
                int howClose = closestMuch(currentDrink.getCalories() + currentCalories, targetCalories);
                if (howClose > 0 && howClose < prevClosest) {
                        prevClosest = howClose;
                        closestRecipe = currentDrink;
                }
            }
        }
        return closestRecipe;
    }

    static void setBreakfastCaloriesPercent(int breakfastCaloriesPercent) {
        RationBuilderTestStrategy.breakfastCaloriesPercent = breakfastCaloriesPercent;
    }

    static void setLunchCaloriesPercent(int lunchCaloriesPercent) {
        RationBuilderTestStrategy.lunchCaloriesPercent = lunchCaloriesPercent;
    }

    static void setDinnerCaloriesPercent(int dinnerCaloriesPercent) {
        RationBuilderTestStrategy.dinnerCaloriesPercent = dinnerCaloriesPercent;
    }
}
