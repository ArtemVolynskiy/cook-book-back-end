package utils;


public class CaloriesUtil {


    public static int countDailyCalories(Sex sex, float weight, float height, int age, ActivityLevel activityLevel, Goal goal) {
        float activityCoefficient = ActivityLevel.activityValues.get(activityLevel);
        int dailyCalories = 0;

        if (sex == Sex.MALE) {
            dailyCalories =(int) ((88.67F + (13.4F * weight) + (4.8F * height) - (5.7F * age)) * activityCoefficient);
        } else if (sex == Sex.FEMALE) {
            dailyCalories =(int) ((447.6F + (9.2F * weight) + (3.1F * height) - (4.3F * age)) * activityCoefficient);
        }

        System.out.println(dailyCalories);

        int coefficient = dailyCalories / 100 * 20;
        if (goal == Goal.KEEP){
            return dailyCalories;
        } else if (goal == Goal.GAIN) {
            dailyCalories += coefficient;
        } else if (goal == Goal.LOOSE) {
            dailyCalories -= coefficient;
        }
        return dailyCalories;
    }
}
