package util.ratecounter;


import model.UserInfo;

public class CaloriesUtil {


    public static int countDailyCalories(UserInfo userInfo) {
        float activityCoefficient = ActivityLevel.activityValues.get(userInfo.getActivityLevel());
        int dailyCalories = 0;

        if (userInfo.getSex() == Sex.MALE) {
            dailyCalories =(int) ((88.67F + (13.4F * userInfo.getWeight()) + (4.8F * userInfo.getHeight()) - (5.7F * userInfo.getAge())) * activityCoefficient);
        } else if (userInfo.getSex() == Sex.FEMALE) {
            dailyCalories =(int) ((447.6F + (9.2F * userInfo.getWeight()) + (3.1F * userInfo.getHeight()) - (4.3F * userInfo.getAge())) * activityCoefficient);
        }


        int coefficient = dailyCalories / 100 * 20;

        if (userInfo.getGoal() == Goal.KEEP){
            return dailyCalories;
        } else if (userInfo.getGoal() == Goal.GAIN) {
            dailyCalories += coefficient;
        } else if (userInfo.getGoal() == Goal.LOOSE) {
            dailyCalories -= coefficient;
        }
        return dailyCalories;
    }
}
