package service;

import model.Recipe;
import model.User;
import model.UserInfo;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete (int id);

    User get (int id);

    User findByName (String name);

    User findById (int id);

    User getByEmail (String email);

    List<User> getAll();

    User update (User user);

    User saveRecipe(int id, Recipe recipe);

    void countCalories(UserInfo userInfo);
}
