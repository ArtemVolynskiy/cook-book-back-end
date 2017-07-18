package util.checker;


import model.BasicMealEntity;
import model.Recipe;

import java.util.LinkedList;
import java.util.List;

public class RationBuilderUtils {
    public static int checkValueIsInTheGap(int caloriesSum, int userCalories) {
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

    public static boolean inTheGap(int caloriesSum, int userCalories) {
        double loverGap = ((double)userCalories / 100) * 90;
        double upperGap = ((double)userCalories / 100) * 110;

        return caloriesSum <= upperGap && caloriesSum >= loverGap;
    }

    public static int closestMuch(int caloriesSum, int userCalories) {
        return userCalories - caloriesSum;
    }

    public static List<Recipe> populateList (Recipe breakfast, Recipe lunch, Recipe dinner) {
        List<Recipe> finalList = new LinkedList<>();
        finalList.add(breakfast);
        finalList.add(lunch);
        finalList.add(dinner);

        return finalList;
    }
}
