package service;


import com.fasterxml.jackson.databind.node.TextNode;
import javassist.NotFoundException;
import model.Recipe;
import model.User;
import utils.ActivityLevel;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete (int id) throws NotFoundException;

    User get (int id) throws NotFoundException;

    User findByName (String name);

    User findById (int id);

    User getByEmail (String email) throws NotFoundException;

    List<User> getAll();

    void update (User user);

    User saveRecipe(int id, Recipe recipe);

    void countDailyCalories (int id, TextNode userInfo) throws NotFoundException;
}
