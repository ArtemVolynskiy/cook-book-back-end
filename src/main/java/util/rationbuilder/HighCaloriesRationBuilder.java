package util.rationbuilder;


import model.Recipe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static util.checker.RationBuilderUtils.checkValueIsInTheGap;
import static util.checker.RationBuilderUtils.inTheGap;

public class HighCaloriesRationBuilder {

    public static List<Recipe> buildRation(Iterator breakfastIterator, Iterator lunchIterator, Iterator dinnerIterator, Iterator snackIterator,
                                           int userCalories) {

        Recipe breakfast = (Recipe) breakfastIterator.next();
        Recipe lunch = (Recipe) lunchIterator.next();
        Recipe dinner = (Recipe) dinnerIterator.next();
        Recipe snack = (Recipe) snackIterator.next();


        boolean done = false;


        List<Recipe> finalList = new LinkedList<>();
        int gapResult;

        while (!done){
            if (!breakfastIterator.hasNext() && !lunchIterator.hasNext() && !dinnerIterator.hasNext() && !snackIterator.hasNext()) {
                return new LinkedList<>();
            }

            if (!finalList.isEmpty()) {
                gapResult = checkValueIsInTheGap(finalList.get(0).getCalories() + finalList.get(1).getCalories() + finalList.get(2).getCalories() + finalList.get(3).getCalories(), userCalories);
            } else {
                gapResult = checkValueIsInTheGap(breakfast.getCalories() + lunch.getCalories() + dinner.getCalories(), userCalories);
            }

            if (gapResult == 0) {
                if (finalList.isEmpty()) {
                    finalList = populateList(breakfast, lunch, dinner, snack);
                }
                done = true;
            } else if (gapResult == -1) {
                finalList = raiseCaloriesInFinalSet(breakfastIterator, lunchIterator, dinnerIterator, snackIterator,
                        breakfast, lunch, dinner, snack, userCalories);
            } else if (gapResult == 1) {
                finalList = reduceCaloriesInFinalSet(breakfastIterator, lunchIterator, dinnerIterator, snackIterator,
                        breakfast, lunch, dinner, snack, userCalories);
            }
        }

        return finalList;
    }

    private static List<Recipe> raiseCaloriesInFinalSet(Iterator breakfastIterator, Iterator lunchIterator, Iterator dinnerIterator, Iterator snackIterator,
                                                        Recipe breakfast, Recipe lunch, Recipe dinner, Recipe snack,
                                                        int userCalories){
        if (breakfastIterator.hasNext()) {
            breakfast = findRecipeWithMoreCalories(breakfastIterator, breakfast);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return  populateList(breakfast, lunch, dinner, snack);
            }
        }
        if (lunchIterator.hasNext()) {
            lunch = findRecipeWithMoreCalories(lunchIterator, lunch);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return  populateList(breakfast, lunch, dinner, snack);
            }
        }
        if (dinnerIterator.hasNext()) {
            dinner =  findRecipeWithMoreCalories(dinnerIterator, dinner);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);
            }
        }
        if (snackIterator.hasNext()) {
            snack =  findRecipeWithMoreCalories(snackIterator, snack);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);
            }
        }
        return populateList(breakfast, lunch, dinner, snack);
    }


    private static List<Recipe> reduceCaloriesInFinalSet(Iterator breakfastIterator, Iterator lunchIterator, Iterator dinnerIterator, Iterator snackIterator,
                                                         Recipe breakfast, Recipe lunch, Recipe dinner, Recipe snack,
                                                         int userCalories){

        if (breakfastIterator.hasNext()) {
            breakfast = findRecipeWithLessCalories(breakfastIterator, breakfast);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);

            }
        }
        if (lunchIterator.hasNext()) {
            lunch = findRecipeWithLessCalories(lunchIterator, lunch);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);
            }
        }
        if (dinnerIterator.hasNext()) {
            dinner = findRecipeWithLessCalories(dinnerIterator, dinner);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);
            }
        }
        if (snackIterator.hasNext()) {
            snack = findRecipeWithLessCalories(dinnerIterator, dinner);
            if (sumMeetsCondition(breakfast, lunch, dinner, snack, userCalories)) {
                return populateList(breakfast, lunch, dinner, snack);
            }
        }
        return populateList(breakfast, lunch, dinner, snack);
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

    private static boolean sumMeetsCondition(Recipe breakfast, Recipe lunch, Recipe dinner, Recipe snack, int userCalories) {
        return inTheGap(breakfast.getCalories() + lunch.getCalories() + dinner.getCalories() + snack.getCalories(), userCalories);
    }

    private static List<Recipe> populateList (Recipe breakfast, Recipe lunch, Recipe dinner, Recipe snack) {
        List<Recipe> finalList = new LinkedList<>();
        finalList.add(breakfast);
        finalList.add(lunch);
        finalList.add(snack);
        finalList.add(dinner);

        return finalList;
    }


}
