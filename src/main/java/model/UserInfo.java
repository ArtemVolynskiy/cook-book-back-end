package model;


import util.ratecounter.ActivityLevel;
import util.ratecounter.Goal;
import util.ratecounter.Sex;

public class UserInfo {

    private Sex sex;
    private int weight;
    private int height;
    private int age;
    private ActivityLevel activityLevel;
    private Goal goal;

    public UserInfo () {}

    public UserInfo(UserInfo userInfo) {
        this(userInfo.sex, userInfo.weight, userInfo.height, userInfo.age, userInfo.activityLevel, userInfo.goal);
    }

    public UserInfo(Sex sex, int weight, int height, int age, ActivityLevel activityLevel, Goal goal) {
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityLevel = activityLevel;
        this.goal = goal;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
