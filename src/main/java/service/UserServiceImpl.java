package service;


import com.fasterxml.jackson.databind.node.TextNode;
import javassist.NotFoundException;
import model.Recipe;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import org.springframework.util.Assert;
import utils.ActivityLevel;
import utils.CaloriesUtil;
import utils.Goal;
import utils.Sex;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);
    }

    public User get(int id) throws NotFoundException {
        return userRepository.get(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return userRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "User must not be null");
        userRepository.save(user);
    }

    @Override
    public User saveRecipe(int id, Recipe recipe) {
        User user = findById(id);
        user.getUserRecipes().add(recipe);
        return save(user);
    }

    @Override
    public void countDailyCalories(int userId, TextNode userInfo) throws NotFoundException, IllegalArgumentException {

        String [] userData = userInfo.textValue().split(" ");
        Sex sex = Sex.valueOf(userData[0]);
        float weight = Float.parseFloat(userData[1]);
        float height = Float.parseFloat(userData[2]);
        int age = Integer.parseInt(userData[3]);
        ActivityLevel activityLevel = ActivityLevel.valueOf(userData[4]);
        Goal goal = Goal.valueOf(userData[5]);

        int dailyCalories = CaloriesUtil.countDailyCalories(sex, weight, height, age, activityLevel, goal);
        User user = this.get(userId);
        user.setCalories(dailyCalories);
        this.save(user);
    }


}
