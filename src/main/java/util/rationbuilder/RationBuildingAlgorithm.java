package util.rationbuilder;


import model.Recipe;


import java.util.*;
import java.util.stream.Collectors;

public class RationBuildingAlgorithm {


    public static List<Recipe> buildRation(int userCalories, List<Recipe> recipes) {

        Map<String, Set<Recipe>> result =
                recipes.stream()
                        .collect(Collectors.groupingByConcurrent(Recipe::getType, Collectors.toSet())
                        );


        Iterator breakfastIterator = result.get("breakfast").iterator();
        Iterator lunchIterator = result.get("lunch").iterator();
        Iterator dinnerIterator = result.get("dinner").iterator();


        Recipe breakfast = (Recipe) breakfastIterator.next();
        Recipe lunch = (Recipe) lunchIterator.next();
        Recipe dinner = (Recipe) dinnerIterator.next();

        boolean done = false;


        List<Recipe> finalList = new LinkedList<>();
        int gapResult;

        while (!done){
            if (!breakfastIterator.hasNext() && !lunchIterator.hasNext() && !dinnerIterator.hasNext()) {
                return null;
            }

            if (!finalList.isEmpty()) {
                gapResult = checkIfInTheGap(finalList.get(0).getCalories() + finalList.get(1).getCalories() + finalList.get(2).getCalories(), userCalories);
            } else {
                gapResult = checkIfInTheGap(breakfast.getCalories() + lunch.getCalories() + dinner.getCalories(), userCalories);
            }

            if (gapResult == 0) {
                if (finalList.isEmpty()) {
                    finalList = populateList(breakfast, lunch, dinner);
                }
                done = true;
            } else if (gapResult == -1) {
                finalList = raiseCaloriesInFinalSet(breakfastIterator, lunchIterator, dinnerIterator, breakfast, lunch, dinner, userCalories);
            } else if (gapResult == 1) {
                finalList = reduceCaloriesInFinalSet(breakfastIterator, lunchIterator, dinnerIterator, breakfast, lunch, dinner, userCalories);
            }
        }

        return finalList;
    }

    private static List<Recipe> raiseCaloriesInFinalSet(Iterator breakfastIterator, Iterator lunchIterator,
                                                        Iterator dinnerIterator,  Recipe breakfast, Recipe lunch, Recipe dinner,  int userCalories){
        if (breakfastIterator.hasNext()) {
            breakfast = findRecipeWithMoreCalories(breakfastIterator, breakfast);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
               return  populateList(breakfast, lunch, dinner);
            }
        }
        if (lunchIterator.hasNext()) {
            lunch = findRecipeWithMoreCalories(lunchIterator, lunch);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
               return  populateList(breakfast, lunch, dinner);
            }
        }
        if (dinnerIterator.hasNext()) {
            dinner =  findRecipeWithMoreCalories(dinnerIterator, dinner);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
               return populateList(breakfast, lunch, dinner);
            }
        }
        return populateList(breakfast, lunch, dinner);
    }


    private static List<Recipe> reduceCaloriesInFinalSet(Iterator breakfastIterator, Iterator lunchIterator,
                                                         Iterator dinnerIterator,  Recipe breakfast, Recipe lunch, Recipe dinner, int userCalories){

        if (breakfastIterator.hasNext()) {
            breakfast = findRecipeWithLessCalories(breakfastIterator, breakfast);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
                return populateList(breakfast, lunch, dinner);

            }
        }
        if (lunchIterator.hasNext()) {
            lunch = findRecipeWithLessCalories(lunchIterator, lunch);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
                return populateList(breakfast, lunch, dinner);
            }
        }
        if (dinnerIterator.hasNext()) {
            dinner = findRecipeWithLessCalories(dinnerIterator, dinner);
            if (checkSum(breakfast, lunch, dinner, userCalories)) {
                return populateList(breakfast, lunch, dinner);
            }
        }
        return populateList(breakfast, lunch, dinner);
    }


    private static Recipe findRecipeWithMoreCalories (Iterator iterator, Recipe recipe) {
        Recipe nextRecipe;

        while (iterator.hasNext()) {
            nextRecipe = (Recipe) iterator.next();
            if (recipe.getCalories() < nextRecipe.getCalories()) {
                return nextRecipe;
            }
        }
        return recipe;
    }

    private static Recipe findRecipeWithLessCalories (Iterator iterator, Recipe recipe) {
        Recipe nextRecipe;

        while (iterator.hasNext()) {
            nextRecipe = (Recipe) iterator.next();
            if (recipe.getCalories() > nextRecipe.getCalories()) {
                return nextRecipe;
            }
        }
        return recipe;
    }

    private static boolean checkSum(Recipe breakfast, Recipe lunch, Recipe dinner, int userCalories) {
        return inTheGap(breakfast.getCalories() + lunch.getCalories() + dinner.getCalories(), userCalories);
    }

    private static List<Recipe> populateList (Recipe breakfast, Recipe lunch, Recipe dinner) {
        List<Recipe> finalList = new LinkedList<>();
        finalList.add(breakfast);
        finalList.add(lunch);
        finalList.add(dinner);

        return finalList;
    }

    private static int checkIfInTheGap(int caloriesSum, int userCalories) {

        double loverGap = ((double)userCalories / 100) * 90;

        if (inTheGap(caloriesSum, userCalories)) {
            return 0;
        }
        else if (caloriesSum < loverGap) {
            return -1;  // result array doesn't have enough calories
        } else  {
            return 1; // result array has too many calories
        }
    }

    private static boolean inTheGap(int caloriesSum, int userCalories) {
        double loverGap = ((double)userCalories / 100) * 90;
        double upperGap = ((double)userCalories / 100) * 110;

        return caloriesSum <= upperGap && caloriesSum >= loverGap;
    }
}
